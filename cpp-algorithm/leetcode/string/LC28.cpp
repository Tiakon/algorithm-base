#include <string>
#include "../util/Utils.h"
using namespace std;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * @author tiankai.me@gmail.com on 2023-08-26 12:26.
 */
class LC28 {
 public:
  int strStr(string haystack, string needle) {
    int ans = -1, r = 0;
    for (int i = 0; i < haystack.size() && r < needle.size(); ++i) {
      ans = i;
      for (int j = i; r < needle.size(); ++j) {
        if (haystack[j] == needle[r]) ++r;
        else {
          r = 0, ans = -1;
          break;
        }
      }
    }
    return ans;
  }
  /**
   * 直观的解法的是：枚举原串 ss 中的每个字符作为「发起点」，每次从原串的「发起点」和匹配串的「首位」开始尝试匹配：
   * 匹配成功：返回本次匹配的原串「发起点」。
   * 匹配失败：枚举原串的下一个「发起点」，重新尝试匹配。
   *
   * 复杂度分析：
   * 时间复杂度：n 为原串的长度，m 为匹配串的长度。其中枚举的复杂度为 O(n−m)，构造和比较字符串的复杂度为 O(m)。
   * 整体复杂度为 O((n−m)∗m)。
   * 空间复杂度：O(1)
   *
   * @author tiankai.me@gmail.com on 2023-08-26 15:13.
   */
  int strStrV2(string s, string p) {
    int n = s.size(), m = p.size();
    // 枚举原串的「发起点」，假设在n - m下标的位置，s中后面的字符串才与p相等。所以i最大也只需达到n-m的位置便可找出所求下标。
    for (int i = 0; i <= n - m; i++) {
      // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
      int j = i, k = 0;
      while (k < m and s[j] == p[k]) {
        j++;
        k++;
      }
      // 如果能够完全匹配，返回原串的「发起点」下标
      if (k == m) return i;
    }
    return -1;
  }
};

int main(int argc, char **argv) {
  LC28 lc28;
  string s1 = "sadbutsad";
  string s2 = "sad";
  int ans = lc28.strStrV2(s1, s2);
  assertEqualInt(0, ans);

  s1 = "leetcode";
  s2 = "leeto";
  ans = lc28.strStrV2(s1, s2);
  assertEqualInt(-1, ans);

  s1 = "leetcode";
  s2 = "code";
  ans = lc28.strStrV2(s1, s2);
  assertEqualInt(4, ans);
  return 0;
}