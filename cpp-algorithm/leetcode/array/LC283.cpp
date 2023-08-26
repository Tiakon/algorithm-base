
#include <vector>
#include <iostream>
using namespace std;

class LC283 {
 public:
  /**
   * 复杂度分析
   * 时间复杂度：O(n)，其中 n 为序列长度。每个位置至多被遍历两次。
   * 空间复杂度：O(1)。只需要常数的空间存放若干变量。
   */
  void moveZeroes(vector<int> &nums) {
    int l = 0, r = 0;
    while (r < nums.size()) {
      if (nums[r]) {
        swap(nums[l], nums[r]);
        ++l;
      }
      ++r;
    }
  }

};

/**
 *283. 移动零
 * https://leetcode.cn/problems/move-zeroes/
 * @author tiankai.me@gmail.com on 2023-08-26 11:48.
 */
int main(int argc, char **argv) {
  LC283 lc283;
  vector<int> nums = {0, 1, 0, 3, 12};
  lc283.moveZeroes(nums);
  for (int i = 0; i < nums.size(); ++i) {
    cout << nums[i] << " ";
  }
  cout << endl;

  nums = {1, 0};
  lc283.moveZeroes(nums);
  for (int i = 0; i < nums.size(); ++i) {
    cout << nums[i] << " ";
  }
  cout << endl;

  return 0;
}