//
// Created by Administrator on 2023-08-27.
//

#ifndef CPP_ALGORITHM_LEETCODE_STRUCTURE_LISTNODE_H_
#define CPP_ALGORITHM_LEETCODE_STRUCTURE_LISTNODE_H_

struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

#endif //CPP_ALGORITHM_LEETCODE_STRUCTURE_LISTNODE_H_
