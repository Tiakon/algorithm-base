
#include "../structure/ListNode.h"
#include "../util/Utils.h"
/**
 * 1721. 交换链表中的节点
 * @author tiankai.me@gmail.com on 2023-09-01 7:43.
 */
class LC1721 {
 public:
  ListNode *swapNodes(ListNode *head, int k) {
    ListNode *l = head, *r = head, *swap;
    for (int i = 1; i < k; ++i) {
      r = r->next;
    }
    swap = r;
    while (r->next != nullptr) {
      l = l->next;
      r = r->next;
    }
    int temp = swap->val;
    swap->val = l->val;
    l->val = temp;
    return head;
  }
};

int main(int argc, char **argv) {

  LC1721 lc1721;
  ListNode node5{5};
  ListNode node4{4, &node5};
  ListNode node3{3, &node4};
  ListNode node2{2, &node3};
  ListNode node1{1, &node2};
  int k = 2;
  ListNode *ans = lc1721.swapNodes(&node1, k);

  printListNode(ans);

  return 0;
}