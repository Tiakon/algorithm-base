#include <iostream>

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