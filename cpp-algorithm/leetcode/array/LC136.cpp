
#include <vector>
#include "../util/Utils.h"

using namespace std;

/**
 * 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 *
 * @author tiankai.me@gmail.com on 2023-08-26 10:46.
 */

class LC136 {
 public:
  /**
   * 复杂度分析
   * 时间复杂度：O(n) ，其中 n 是数组长度。只需要对数组遍历一次。
   * 空间复杂度：O(1)
   */
  int singleNumber(vector<int> &nums) {
    int ans = 0;
    for (int num : nums) {
      ans ^= num;
    }
    return ans;
  }
};

int main(int argc, char **argv) {

  LC136 lc136;

  vector<int> nums{2, 2, 1};
  int ans = lc136.singleNumber(nums);
  assertEqualInt(1,ans);
  nums = {4, 1, 2, 1, 2};
  ans = lc136.singleNumber(nums);
  assertEqualInt(4,ans);

  return 0;
}
