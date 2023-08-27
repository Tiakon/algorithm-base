#include <iostream>

#include <unordered_map>
#include <string>
#include "../structure/Node.h"
#include "../util/Utils.h"

using namespace std;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/
 *
 * */
class LC138 {
 public:
  unordered_map<Node *, Node *> cachedNode;

  Node *copyRandomList(Node *head) {
    if (head == nullptr) return nullptr;
    if (!cachedNode.count(head)) {
      Node *headNew = new Node(head->val);
      cachedNode[head] = headNew;
      headNew->next = copyRandomList(head->next);
      headNew->random = copyRandomList(head->random);
    }
    return cachedNode[head];
  }

};

int main() {
  LC138 lc138;

  Node node1{1};
  Node node10{10, &node1};
  Node node11{11, &node10};
  Node node13{13, &node11};
  Node node7{7, &node13};

  node13.random = &node7;
  node11.random = &node1;
  node10.random = &node11;
  node1.random = &node7;

  printNodeWithRandom(&node7);
  // printf %p 的类型代表： 以十六进制的方式，显示内存地址的输出格式。
  printf("node7: %p \n", node7);
  cout << "&node7:" << &node7 << endl;
  Node *ans = lc138.copyRandomList(&node7);
  printf("ans: %p \n", ans);
  printf("*ans: %p \n", *ans);
  cout << "&ans:" << &ans << endl;
  printNodeWithRandom(ans);
  return 0;
}
