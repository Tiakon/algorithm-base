#include <iostream>

#include<vector>
using namespace std;

/**
 * 1822. 数组元素积的符号
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 *
 * */
class LC1822 {
 public:
  int arraySign(vector<int> &nums) {
    int ans = 1;
    for (int num : nums) {
      if (num == 0) return 0;
      else if (num < 0) ans *= -1;
    }
    return ans;
  }
};
