
#include "vector"
#include <algorithm>
#include "../util/Utils.h"

using namespace std;
/**
 * 1979. 找出数组的最大公约数
 * https://leetcode.cn/problems/find-greatest-common-divisor-of-array/
 * @author tiankai.me@gmail.com on 2023-08-27 10:52.
 */
class LC1979 {
 public:
  int findGCD(vector<int> &nums) {
    for (int i = 0; i < nums.size(); ++i) {
      for (int j = 1; j < nums.size() - i; ++j) {
        if (nums[j - 1] > nums[j]) swap(nums[j - 1], nums[j]);
      }
    }
    int ans = findGreatestCommonDivisor(nums[nums.size() - 1], nums[0]);
    return ans;
  }
  int findGCDV2(vector<int> &nums) {
    int mx = *max_element(nums.begin(), nums.end());
    int mn = *min_element(nums.begin(), nums.end());
    return __gcd(mx, mn);
  }

 private:
  int findGreatestCommonDivisor(int max, int min) {
    if (max % min == 0) return min;
    int ans = min;
    while (ans-- > 0) {
      if (max % ans == 0 && min % ans == 0) return ans;
    }
    return 1;
  }
};

int main(int argc, char **argv) {
  LC1979 lc1979;
  vector<int> nums = {2, 5, 6, 9, 10};
  int ans = lc1979.findGCD(nums);
  assertEqualInt(2, ans);

  nums = {7, 5, 6, 8, 3};
  ans = lc1979.findGCD(nums);
  assertEqualInt(1, ans);

  nums = {3, 3};
  ans = lc1979.findGCD(nums);
  assertEqualInt(3, ans);

  return 0;
}