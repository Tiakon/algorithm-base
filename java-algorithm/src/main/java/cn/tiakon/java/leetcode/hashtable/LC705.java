package cn.tiakon.java.leetcode.hashtable;

/**
 * 705. 设计哈希集合
 * https://leetcode.cn/problems/design-hashset/description/
 *
 * @author tiankai.me@gmail.com on 2023-08-09 7:48.
 */
public class LC705 {
}

class MyHashSet {
    int[] bs = new int[40000];
    public void add(int key) {
        int bucketIdx = key / 32;
        int bitIdx = key % 32;
        setVal(bucketIdx, bitIdx, true);
    }

    public void remove(int key) {
        int bucketIdx = key / 32;
        int bitIdx = key % 32;
        setVal(bucketIdx, bitIdx, false);
    }

    public boolean contains(int key) {
        int bucketIdx = key / 32;
        int bitIdx = key % 32;
        return getVal(bucketIdx, bitIdx);
    }

    void setVal(int bucket, int loc, boolean val) {
        if (val) {
            int u = bs[bucket] | (1 << loc);
            bs[bucket] = u;
        } else {
            int u = bs[bucket] & ~(1 << loc);
            bs[bucket] = u;
        }
    }

    boolean getVal(int bucket, int loc) {
        int u = (bs[bucket] >> loc) & 1;
        return u == 1;
    }
}

/**
 * 复杂度分析
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 * @author tiankai.me@gmail.com on 2023-08-09 16:27.
 */
class MyHashSetBooleanArray {
    boolean[] map;

    public MyHashSetBooleanArray() {
        map = new boolean[(int) Math.pow(10, 6) + 1];
    }

    public void add(int key) {
        map[key] = true;
    }

    public void remove(int key) {
        map[key] = false;
    }

    public boolean contains(int key) {
        return map[key];
    }
}

class MyHashSetMap {
    LC706MyHashMap map;

    public MyHashSetMap() {
        map = new LC706MyHashMap();
    }

    public void add(int key) {
        map.put(key, 0);
    }

    public void remove(int key) {
        map.remove(key);
    }

    public boolean contains(int key) {
        return map.get(key) != -1;
    }
}