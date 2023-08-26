//
// Created by Administrator on 2023-08-26.
//

#include <string>
#include <vector>
#include <iostream>

using namespace std;

/**
 * 389. 找不同
 * https://leetcode.cn/problems/find-the-difference/
 * @author tiankai.me@gmail.com on 2023-08-26 10:04.
 */
class LC389 {
 public:
  /**
   * 利用 ASCII 码的值求和
   * 复杂度分析:
   * 时间复杂度：O(N)
   * 空间复杂度：O(1)
   */
  char findTheDifference(string s, string t) {
    int sum1 = 0, sum2 = 0;
    for (int i = 0; i < s.size(); i++) {
      sum1 += s[i];
      sum2 += t[i];
    }
    sum2 += t[t.size() - 1];
    return char(sum2 - sum1);
  }
  /**
 * 利用数组对每个字符计数。
 * 复杂度分析:
 * 时间复杂度：O(N)
 * 空间复杂度：O(∣Σ∣)：Σ 是字符集，这道题中字符串只包含小写字母，∣Σ∣=26
 */
  char findTheDifferenceV2(string s, string t) {
    vector<int> cnt(26, 0);
    for (char ch: s) {
      cnt[ch - 'a']++;
    }
    for (char ch: t) {
      cnt[ch - 'a']--;
      if (cnt[ch - 'a'] < 0) {
        return ch;
      }
    }
    return ' ';
  }
  /**
   *位运算
   *如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符。
   * 复杂度分析
   * 时间复杂度：O(N)
   * 空间复杂度：O(1)
   */
  char findTheDifferenceV3(string s, string t) {
    int ret = 0;
    for (char ch: s) {
      ret ^= ch;
    }
    for (char ch: t) {
      ret ^= ch;
    }
    return ret;
  }

};

int main(int argc, char **argv) {
  LC389 lc389;
  string s = "abc";
  string t = "cbad";
  char ans = lc389.findTheDifferenceV3(s, t);
  if (ans == 'd') cout << "pass" << endl;
  else cout << "error!" << ans << endl;
  return 0;
}