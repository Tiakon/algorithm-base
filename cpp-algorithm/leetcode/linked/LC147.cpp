
#include "../structure/ListNode.h"
class LC147 {
 public:
  ListNode *insertionSortList(ListNode *head) {
    if (head == nullptr) return head;
    ListNode *dummyHead = new ListNode(0);
    dummyHead->next = head;
    ListNode *lastSorted = head;
    ListNode *curr = head->next;
    while (curr != nullptr) {
      if (lastSorted->val <= curr->val)lastSorted = lastSorted->next;
      else {
        ListNode *prev = dummyHead;
        while (prev->next->val <= curr->val) {
          prev = prev->next;
        }
        lastSorted->next = curr->next;
        curr->next = prev->next;
        prev->next = curr;
      }
      curr = lastSorted->next;
    }
    return dummyHead->next;
  }
};