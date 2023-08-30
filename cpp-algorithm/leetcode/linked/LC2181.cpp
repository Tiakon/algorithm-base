#include "../structure/ListNode.h"

class LC2181 {
 public:
  ListNode *mergeNodes(ListNode *head) {
    ListNode *p = head->next;
    while (p && p->next)
      if (p->next->val) {
        p->val += p->next->val;
        p->next = p->next->next;
      } else {
        p->next = p->next->next;
        p = p->next;
      }
    return head->next;
  }
};
int main(int argc, char **argv) {

  return 0;
}