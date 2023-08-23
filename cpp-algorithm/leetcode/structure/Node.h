//
// Created by Administrator on 2023-08-23.
//

#ifndef CPP_ALGORITHM__NODE_H_
#define CPP_ALGORITHM__NODE_H_
class Node {
 public:
  int val;
  Node *prev = nullptr;
  Node *next = nullptr;
  Node *child = nullptr;
  Node *random = nullptr;
  Node(int val) {
    this->val = val;
  }
  Node(int val, Node *next) {
    this->val = val;
    this->next = next;
  }
};
#endif //CPP_ALGORITHM__NODE_H_
