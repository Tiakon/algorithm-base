//
// Created by Administrator on 2023-08-26.
//

#ifndef CPP_ALGORITHM_LEETCODE_UTIL_UTILS_H_
#define CPP_ALGORITHM_LEETCODE_UTIL_UTILS_H_

#include<vector>
#include "../structure/ListNode.h"
#include "../structure/Node.h"
using namespace std;

void assertEqualInt(int actual, int expect);

void printVector(const vector<int> &nums);
void printNode(Node *curr);
void printNodeWithRandom(Node *curr);
void printListNode(ListNode *curr);
void bubbleSort(vector<int> &nums);

int gcd(int a, int b);
#endif //CPP_ALGORITHM_LEETCODE_UTIL_UTILS_H_
