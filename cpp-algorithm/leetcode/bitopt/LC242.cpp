#include <string>
#include <vector>
#include <algorithm>

using namespace std;
/**
 * 242. 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/
 * @author tiankai.me@gmail.com on 2023-08-26 13:33.
 */
class LC242 {
 public:
  bool isAnagram(string s, string t) {
    if (s.length() != t.length()) return false;
    vector<int> nums(128, 0);
    for (char i : s) ++nums[i];
    for (char i : t) {
      if (--nums[i] < 0) return false;
    }
    return true;
  }
  bool isAnagramV2(string s, string t) {
    if (s.length() != t.length()) return false;
    sort(s.begin(), s.end());
    sort(t.begin(), t.end());
    return s == t;
  }
};