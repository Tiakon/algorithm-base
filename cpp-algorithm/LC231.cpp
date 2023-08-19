#include <iostream>
#include <cmath>
using namespace std;

/**
 *231. 2 的幂
 * https://leetcode.cn/problems/power-of-two/
 * 326. 3 的幂
 * https://leetcode.cn/problems/power-of-three/description/
 *342. 4的幂
 * https://leetcode.cn/problems/power-of-four/description/
 *
 * */
class LC231 {
 public:
  bool isPowerOfTwo(int n) {
    if (n <= 0) return false;
    while (n > 2) {
      if (n % 2 != 0) return false;
      n = n / 2;
    }
    return true;
  }
  // 若n等于2的x次方 , 恒有 n&(n-1)==0
  // n   二进制最高位为 1, 其余所有位为 0
  // n−1 二进制最高位为 0, 其余所有位为 1
  // 一定满足 n>0
  bool isPowerOfTwoV1(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
  // 求出以2为底n的对数是x，是否等于整数。
  bool isPowerOfTwoV2(int n) {
    if (n <= 0) return false;
    return (log2(n) == int(log2(n)));
  }
};

int main() {
  LC231 lc;
  bool ans = lc.isPowerOfTwo(1);
  if (ans) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  ans = lc.isPowerOfTwo(16);
  if (ans) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  ans = lc.isPowerOfTwo(3);
  if (!ans) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  ans = lc.isPowerOfTwo(38);
  if (!ans) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  ans = lc.isPowerOfTwo(4);
  if (ans) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  ans = lc.isPowerOfTwo(5);
  if (!ans) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  return 0;
}