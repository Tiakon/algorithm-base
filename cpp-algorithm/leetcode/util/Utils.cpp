//
// Created by Administrator on 2023-08-26.
//
#include <iostream>
#include<vector>
#include "../structure/Node.h"
#include "../structure/ListNode.h"

using namespace std;

void assertEqualInt(int expect, int actual) {
  if (expect == actual) cout << "pass" << endl;
  else cout << "error!" << actual << endl;
}

void printVector(const vector<int> &nums) {
  for (int num : nums) {
    cout << num << " ";
  }
  cout << endl;
}

void printNodeWithRandom(Node *curr) {
  while (curr != nullptr) {
    int value = curr->val;
    // 指针变量为空，不会报错，程序会直接退出。
    if (curr->random != nullptr) {
      int cv = curr->random->val;
      cout << value << "(" << cv << ") -> ";
    } else cout << value << "(-1) ->";
    curr = curr->next;
  }
  cout << endl;
}

void printNode(Node *curr) {
  while (curr != nullptr) {
    cout << curr->val << "-> ";
    curr = curr->next;
  }
}

void printListNode(ListNode *curr) {
  while (curr) {
    cout << curr->val << " -> ";
    curr = curr->next;
  }
  cout << endl;
}

void bubbleSort(vector<int> &nums) {
  for (int i = 0; i < nums.size(); ++i) {
    for (int j = 1; j < nums.size() - i; ++j) {
      if (nums[j - 1] > nums[j]) {
        int swap = nums[j - 1];
        nums[j - 1] = nums[j];
        nums[j] = swap;
      }
    }
  }
}
// 求最大公约数
int gcd(int a, int b) {
  return b ? gcd(b, a % b) : a;
}