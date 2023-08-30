
#include <vector>
#include <unordered_set>
#include "../structure/ListNode.h"

using namespace std;

/**
 * 817. 链表组件
 * https://leetcode.cn/problems/linked-list-components/description/
 * @author tiankai.me@gmail.com on 2023-08-29 15:46.
 */
class LC817 {
 public:
  /**
   * 此题需要计算组件的个数，只需在链表中计算有多少组件的起始位置即可。当一个节点满足以下条件之一时，它是组件的起始位置：
   * 节点的值在数组 nums 中且节点位于链表起始位置；
   * 节点的值在数组 nums 中且节点的前一个点不在数组 nums 中。
   *
   * @author tiankai.me@gmail.com on 2023-08-29 16:36.
   */
  int numComponents(ListNode *head, vector<int> &nums) {
    unordered_set<int> numsSet;
    for (int num : nums) {
      numsSet.emplace(num);
    }
    bool inSet = false;
    int res = 0;
    while (head != nullptr) {
      if (numsSet.count(head->val)) {
        if (!inSet) {
          inSet = true;
          res++;
        }
      } else inSet = false;
      head = head->next;
    }
    return res;
  }
  int numComponentsV2(ListNode *head, vector<int> &nums) {
    unordered_set<int> s(nums.begin(), nums.end());
    int r = 1, ans = 0;
    while (head) {
      if (s.count(head->val)) ans += r, r = 0;
      else r = 1;
      head = head->next;
    }
    return ans;
  }
};

int main(int argc, char **argv) {

  return 0;
}