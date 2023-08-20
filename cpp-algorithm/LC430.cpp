#include <iostream>

#include<vector>
using namespace std;

/**
 * 430. 扁平化多级双向链表
 * https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * */
class Node {
 public:
  int val;
  Node *prev = nullptr;
  Node *next = nullptr;
  Node *child = nullptr;
  Node(int val) {
    this->val = val;
  }
  Node(int val, Node *next) {
    this->val = val;
    this->next = next;
  }
};

class LC430 {
 private:
  Node *dfs(Node *head) {
    //last前一结点指针
    Node *last = head;
    while (head) {
      if (head->child == nullptr) { //直接往后走
        last = head;
        head = head->next;
      } else {
        //记录head的后继
        Node *next = head->next;
        //下一层结点的起始
        Node *childstart = head->child;
        //下一层结点的结束
        Node *childlast = dfs(head->child);
        //将最后一层合并到其上一层
        head->next = childstart;
        childstart->prev = head;
        head->child = nullptr;
        childlast->next = next;
        if (next != nullptr) {
          next->prev = childlast;
        }
        //更新last和head
        last = childlast;
        head = next;
      }
    }
    return last;
  }
 public:
  Node *flatten(Node *head) {
    dfs(head);
    return head;
  }
};

int main() {
  LC430 *lc;

  Node node3{3};
  Node node2{2};
  Node node1{1, &node2};
  node2.prev = &node1;
  node1.next = &node2;
  node1.child = &node3;

//  *node2.prev = node1;  //这样写是错误的，程序会直接退出且不会打印错误
//  *node1.next = node2;
//  *node1.child = node3;

  Node *ans = lc->flatten(&node1);
  while (ans) {
    cout << ans->val << " ";
    ans = ans->next;
  }

  return 0;
}
