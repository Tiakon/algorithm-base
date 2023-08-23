#include <iostream>

using namespace std;

/**
 *258. 各位相加
 * https://leetcode.cn/problems/add-digits/
 * */
class LC258 {
 public:
  int addDigits(int num) {
    return (num - 1) % 9 + 1;;
  }
  int addDigitsV1(int num) {
    while (num >= 10) {
      int sum = 0;
      while (num > 0) {
        sum += num % 10;
        num /= 10;
      }
      num = sum;
    }
    return num;
  }
};

int main() {
  LC258 lc;
  int ans = lc.addDigits(38);
  if (ans == 2) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  cout << "-----------" << endl;
  ans = lc.addDigits(0);
  if (ans == 0) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  cout << "-----------" << endl;
  ans = lc.addDigits(10);
  if (ans == 1) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  cout << "-----------" << endl;
  return 0;
}