package cn.tiakon.java.leetcode.hashtable;

/**
 * 分离链接+红黑树
 *
 * @author tiankai.me@gmail.com on 2023-08-09 15:30.
 */
public class LC706MyHashMapTree {
    private static class TreeNode {
        private int key;
        private int value;
        private boolean color;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        private TreeNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private TreeNode[] hashtable = new TreeNode[1024];
    private int currentSize;

    public void put(int key, int value) {
        if (currentSize >= hashtable.length) {
            resize(); // 从结果来看，加载因子选 1.0 效率较高。
        }
        int index = key & (hashtable.length - 1);
        insert(index, new TreeNode(key, value));
    }

    public int get(int key) {
        int index = key & (hashtable.length - 1);
        TreeNode node = getNode(index, key);
        return node == null ? -1 : node.value;
    }

    public void remove(int key) {
        int index = key & (hashtable.length - 1);
        delete(index, key);
    }

    // 对哈希表进行扩容。
    private void resize() {
        TreeNode[] oldTable = hashtable;
        hashtable = new TreeNode[hashtable.length << 1];
        for (TreeNode root : oldTable) {
            postorderTraversal(root);
        }
        currentSize >>= 1;
    }

    // 获取指定位置上的指定结点。
    private TreeNode getNode(int index, int key) {
        TreeNode current = hashtable[index];
        while (current != null) {
            if (current.key == key) {
                break;
            }
            if (current.key < key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return current;
    }

    // 在指定位置上插入结点。
    private void insert(int index, TreeNode insert) {
        TreeNode current = hashtable[index], parent = null; // 分别保存当前结点及其父结点。
        while (current != null) {
            parent = current;
            if (current.key == insert.key) {
                current.value = insert.value;
                return;
            }
            if (current.key < insert.key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        insert.parent = parent;
        if (parent == null) {
            hashtable[index] = insert;
        } else if (parent.key < insert.key) {
            parent.right = insert;
        } else {
            parent.left = insert;
        }
        currentSize++;
        fixAfterInsertion(index, insert);
    }

    // 删除指定位置上的指定结点。
    private void delete(int index, int key) {
        TreeNode delete = getNode(index, key);
        if (delete == null) {
            return;
        }
        if (delete.left != null && delete.right != null) {
            TreeNode successor = delete.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            delete.key = successor.key;
            delete.value = successor.value;
            delete = successor;
        }
        TreeNode replacement = delete.left == null ? delete.right : delete.left;
        if (replacement == null) {
            fixAfterDeletion(index, delete);
            if (delete.parent == null) {
                hashtable[index] = null;
            } else if (delete.parent.left == delete) {
                delete.parent.left = null;
            } else {
                delete.parent.right = null;
            }
        } else { // 被删除的结点只有一个子结点，那它一定是黑色结点，且它的子结点为红色。
            replacement.parent = delete.parent;
            if (delete.parent == null) {
                hashtable[index] = replacement;
            } else if (delete.parent.left == delete) {
                delete.parent.left = replacement;
            } else {
                delete.parent.right = replacement;
            }
            replacement.color = BLACK;
        }
        currentSize--;
    }

    // 对插入后的结点进行调整。
    private void fixAfterInsertion(int index, TreeNode insert) {
        while (colorOf(insert.parent) == RED) { // 只有父结点是红色才进行处理。
            // 分别保存当前结点的父结点、叔父结点、祖父结点。
            TreeNode parent = insert.parent, uncle = sibling(parent), grand = parent.parent;
            grand.color = RED; // 不管是哪种情况，祖父结点都需要染成红色。
            if (colorOf(uncle) == BLACK) { // 叔父结点为黑色。
                if (grand.left == parent) {
                    if (parent.right == insert) {
                        rotationLeft(index, parent); // LR 情况：先对父结点进行左旋转。
                        parent = insert;
                    }
                    rotationRight(index, grand); // LL 情况：对祖父结点进行右旋转。
                } else {
                    if (parent.left == insert) {
                        rotationRight(index, parent); // RL 情况：先对父结点进行右旋转。
                        parent = insert;
                    }
                    rotationLeft(index, grand); // RR 情况：对祖父结点进行左旋转。
                }
                parent.color = BLACK; // 将旋转后的中心结点染成黑色。
                insert = hashtable[index]; // 处理完直接退出循环。
            } else { // 叔父结点为红色，则将父结点与叔父结点都染成黑色，将祖父结点作为新插入的结点继续处理。
                uncle.color = BLACK;
                parent.color = BLACK;
                insert = grand;
            }
        }
        hashtable[index].color = BLACK; // 根结点必须是黑色。
    }

    // 对删除后的结点进行调整。
    private void fixAfterDeletion(int index, TreeNode delete) {
        while (delete.parent != null && delete.color == BLACK) { // 只有删除的是黑色结点才进行处理。
            // 分别保存当前结点的父结点、兄弟结点。
            TreeNode parent = delete.parent, sibling = sibling(delete);
            if (sibling.color == BLACK) { // 兄弟结点是黑色。
                if (colorOf(sibling.left) == BLACK && colorOf(sibling.right) == BLACK) { // 兄弟结点没有红色子结点。
                    if (parent.color == BLACK) {
                        delete = parent;
                    }
                    parent.color = BLACK;
                    sibling.color = RED;
                } else { // 兄弟结点有红色子结点。
                    if (parent.left == sibling) {
                        if (colorOf(sibling.left) == BLACK) {
                            rotationLeft(index, sibling); // LR 情况：先对兄弟结点进行左旋转。
                            sibling = sibling.parent;
                        }
                        rotationRight(index, parent); // LL 情况：对父结点进行右旋转。
                    } else {
                        if (colorOf(sibling.right) == BLACK) {
                            rotationRight(index, sibling); // RL 情况：先对兄弟结点进行右旋转。
                            sibling = sibling.parent;
                        }
                        rotationLeft(index, parent); // RR 情况：对父结点进行左旋转。
                    }
                    sibling.color = parent.color; // 旋转后中心结点继承父结点的颜色。
                    sibling.left.color = BLACK;
                    sibling.right.color = BLACK;
                    delete = hashtable[index]; // 处理完直接退出循环。
                }
            } else { // 兄弟结点是红色。
                if (parent.left == sibling) {
                    rotationRight(index, parent);
                } else {
                    rotationLeft(index, parent);
                }
                parent.color = RED;
                sibling.color = BLACK;
            }
        }
    }

    // 获取指定结点的兄弟结点。
    private TreeNode sibling(TreeNode node) {
        if (node.parent.left == node) {
            return node.parent.right;
        }
        return node.parent.left;
    }

    // 对指定位置上的指定结点进行左旋转。
    private void rotationLeft(int index, TreeNode node) {
        TreeNode newRoot = node.right; // 结点的右子结点会成为这颗子树的根结点。
        node.right = newRoot.left;
        if (newRoot.left != null) {
            newRoot.left.parent = node;
        }
        newRoot.left = node;
        newRoot.parent = node.parent;
        if (node.parent == null) {
            hashtable[index] = newRoot;
        } else if (node.parent.left == node) {
            node.parent.left = newRoot;
        } else {
            node.parent.right = newRoot;
        }
        node.parent = newRoot;
    }

    // 对指定位置上的指定结点进行右旋转。
    private void rotationRight(int index, TreeNode node) {
        TreeNode newRoot = node.left; // 结点的左子结点会成为这颗子树的根结点。
        node.left = newRoot.right;
        if (newRoot.right != null) {
            newRoot.right.parent = node;
        }
        newRoot.right = node;
        newRoot.parent = node.parent;
        if (node.parent == null) {
            hashtable[index] = newRoot;
        } else if (node.parent.left == node) {
            node.parent.left = newRoot;
        } else {
            node.parent.right = newRoot;
        }
        node.parent = newRoot;
    }

    // 获取指定结点的颜色。
    private boolean colorOf(TreeNode node) {
        return node == null || node.color;
    }

    // 对结点进行后序遍历。
    private void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        node.left = node.right = node.parent = null;
        node.color = RED;
        int index = node.key & (hashtable.length - 1);
        insert(index, node);
    }
}
