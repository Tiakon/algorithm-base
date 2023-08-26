//
// Created by Administrator on 2023-08-25.
//

#include "string"
#include "iostream"
using namespace std;

class LC1768 {
 public:
  string mergeAlternately(string word1, string word2) {
    string ans;
    int str1Len = word1.length(), str2Len = word2.length();
    int l = 0, r = 0;
    while (l < str1Len && r < str2Len) {
      ans += word1[l++];
      ans += word2[r++];
    }
    if (l == str1Len && r < str2Len) ans += word2.substr(r);
    if (r == str2Len && l < str1Len) ans += word1.substr(l);
    return ans;
  }
  string mergeAlternatelyV2(string word1, string word2) {
    int m = word1.size(), n = word2.size();
    int i = 0, j = 0;
    string ans;
    // 指定字符串容量
    ans.reserve(m + n);
    while (i < m || j < n) {
      if (i < m) ans.push_back(word1[i++]); // 从字符串末尾追加字符
      if (j < n) ans.push_back(word2[j++]);
    }
    return ans;
  }
};

int main(int argc, char **argv) {
  LC1768 lc1768l;
  string w1 = "hello";
  string w2 = "world";
  string ans = lc1768l.mergeAlternately(w1, w2);
  if (ans == "hweolrllod")cout << "pass" << endl;
  else cout << "error: " << ans << endl;

  w1 = "hello!!!";
  w2 = "word";
  ans = lc1768l.mergeAlternately(w1, w2);
  if (ans == "hweolrldo!!!")cout << "pass" << endl;
  else cout << "error: " << ans << endl;

  w1 = "hello";
  w2 = "word!!!";
  ans = lc1768l.mergeAlternately(w1, w2);
  if (ans == "hweolrldo!!!")cout << "pass" << endl;
  else cout << "error: " << ans << endl;
  return 0;
}