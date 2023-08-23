#include <iostream>

#include<vector>
using namespace std;

/**
 * 2682. 找出转圈游戏输家
 * https://leetcode.cn/problems/find-the-losers-of-the-circular-game/
 *
 * */
class LC2682 {
 public:
  vector<int> circularGameLosers(int n, int k) {
    vector<int> arr(n);
    for (int i = 0, j = k; !arr[i]; j += k) {
      arr[i] = 1;
      i = (i + j) % n;
    }
    vector<int> ans;
    for (int i = 1; i < arr.size(); ++i) {
      // 在vector中插入时直接在容器内构造对象，省略了创建临时对象的操作。
      if (arr[i] == 0)ans.emplace_back(i + 1);
    }
    return ans;
  }
  // todo:为啥会出现这种报错？
  // Line 1034: Char 34: runtime error: addition of unsigned offset to 0x6020000000f0 overflowed to 0x6020000000ec (stl_vector.h)
  //SUMMARY: UndefinedBehaviorSanitizer: undefined-behavior /usr/bin/../lib/gcc/x86_64-linux-gnu/9/../../../../include/c++/9/bits/stl_vector.h:1043:34
  vector<int> circularGameLosersV2(int n, int k) {
    vector<int> arr(n);
    for (int i = 0, j = 1; arr[i] < 1 && i >= 0; --i) {
      arr[i] += 1;
      i = ((i + 1) + (j++) * k) % n;
    }
    vector<int> ans;
    for (int i = 1, j; i < arr.size(); ++i) {
      if (arr[i] == 0)ans.emplace_back(i + 1);
    }
    return ans;
  }

};

int main() {
  LC2682 lc;
  int n = 5, k = 2;
  vector<int> ans = lc.circularGameLosers(n, k);
  for (int i = 0; i < ans.size(); ++i) {
    cout << ans[i] << endl;
  }
  cout << "-----------" << endl;
  n = 4, k = 4;
  ans = lc.circularGameLosers(n, k);
  for (int i = 0; i < ans.size(); ++i) {
    cout << ans[i] << endl;
  }
  cout << "-----------" << endl;
  n = 1, k = 1;
  ans = lc.circularGameLosers(n, k);
  cout << "--" << ans.size() << endl;
  for (int i = 0; i < ans.size(); ++i) {
    cout << ans[i] << endl;
  }
  cout << "-----------" << endl;
  return 0;
}
