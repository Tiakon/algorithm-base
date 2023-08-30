#include <stack>
#include "../structure/ListNode.h"

using namespace std;

/**
 * 445. 两数相加 II
 * https://leetcode.cn/problems/add-two-numbers-ii/description/
 * @author tiankai.me@gmail.com on 2023-08-29 23:48.
 */
class LC445 {
 public:
  ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    stack<int> s1, s2;
    while (l1) {
      s1.push(l1->val);
      l1 = l1->next;
    }
    while (l2) {
      s2.push(l2->val);
      l2 = l2->next;
    }
    int carry = 0;
    ListNode *ans = nullptr;
    while (!s1.empty() or !s2.empty() or carry != 0) {
      int a = s1.empty() ? 0 : s1.top();
      int b = s2.empty() ? 0 : s2.top();
      if (!s1.empty()) s1.pop();
      if (!s2.empty()) s2.pop();
      int cur = a + b + carry;
      carry = cur / 10;
      cur %= 10;
      auto curnode = new ListNode(cur);
      curnode->next = ans;
      ans = curnode;
    }
    return ans;
  }
};

int main(int argc, char **argv) {

  return 0;
}