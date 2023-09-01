#include <vector>
#include <algorithm>
using namespace std;

/**
 * 896. 单调数列
 * https://leetcode.cn/problems/monotonic-array/
 * @author tiankai.me@gmail.com on 2023-08-30 23:10.
 */
class LC896 {
 public:
  bool isMonotonic(vector<int> &nums) {
    int i, j;
    for (i = 1; i < nums.size(); ++i) {
      if (nums[i - 1] > nums[i]) break;
    }
    if (i == nums.size()) return true;
    for (j = 1; j < nums.size(); ++j) {
      if (nums[j - 1] < nums[j]) break;
    }
    return j == nums.size();
  }
  bool isMonotonicV2(vector<int> &nums) {
    //  is_sorted 如果指定范围中的元素按顺序排序，则返回 true。
    //  rbegin() 返回Vector尾部的逆迭代器
    //  rend() 返回Vector起始的逆迭代器
    return is_sorted(nums.begin(), nums.end()) || is_sorted(nums.rbegin(), nums.rend());
  }
  bool isMonotonicV3(vector<int> &nums) {
    bool inc = true, dec = true;
    for (int i = 1; i < nums.size(); ++i) {
      if (nums[i - 1] > nums[i]) inc = false;
      if (nums[i - 1] < nums[i]) dec = false;
    }
    return inc || dec;
  }
};
