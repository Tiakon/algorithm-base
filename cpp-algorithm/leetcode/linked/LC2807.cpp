
#include <iostream>
#include "../structure/ListNode.h"
#include "../util/Utils.h"

class LC2807 {
 public:
  ListNode *insertGreatestCommonDivisors(ListNode *head) {
    ListNode *curr = head;
    while (curr != nullptr && curr->next != nullptr) {
      ListNode *next = curr->next;
      int g = gcd(curr->val, next->val);
      // 分配到堆上
      ListNode *node = new ListNode(g, next);
      curr->next = node;
      curr = next;
    }
    return head;
  }
};

int main(int argc, char **argv) {
  LC2807 lc2807;
  ListNode node3{3};
  ListNode node10{10, &node3};
  ListNode node6{6, &node10};
  ListNode node18{18, &node6};
  ListNode *ans = lc2807.insertGreatestCommonDivisors(&node18);
  printListNode(ans);
  return 0;
}