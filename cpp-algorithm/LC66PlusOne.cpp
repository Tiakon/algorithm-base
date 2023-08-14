#include <iostream>

#include<vector>
using namespace std;

/**
 * 66. 加一
 * https://leetcode.cn/problems/plus-one/
 *
 * */
class LC66PlusOne {
 public:
  vector<int> plusOne(vector<int> &digits) {
    int carry = 1;
    for (int i = digits.size() - 1; i >= 0; i--) {
      int sum = carry + digits[i];
      carry = sum >= 10 ? 1 : 0;
      digits[i] = sum % 10;
      if (carry == 0) return digits;
    }
    // carry == 1
    // digits.insert(digits.begin(),1);
    vector<int> ans(digits.size() + 1, 0);
    ans[0] = 1;
    return ans;
  }
};

int main() {
  LC66PlusOne *plusOne = new LC66PlusOne();
  vector<int> ve{1, 2, 3, 4};
  vector<int> ans = plusOne->plusOne(ve);
  for (int i:ans) {
    cout << i << "\t";
  }
  cout << endl << "-----------" << endl;
  ve = {6, 7, 8};
  ans = plusOne->plusOne(ve);
  for (int i:ans) {
    cout << i << "\t";
  }
  cout << endl << "-----------" << endl;
  ve = {9, 9, 9, 9, 9};
  ans = plusOne->plusOne(ve);
  for (int i:ans) {
    cout << i << "\t";
  }
  return 0;
}
