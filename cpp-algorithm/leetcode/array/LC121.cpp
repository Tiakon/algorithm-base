#include <iostream>

#include<vector>
#include<algorithm>
using namespace std;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * */
class LC2682 {
 public:
  //
  /**
   * 一次遍历，记录历史最低点的价格，返回最大值即可。
   * 复杂度分析
   * 时间复杂度：O(n)，只需要遍历一次。
   * 空间复杂度：O(1)，只使用了常数个变量。
   * */
  int maxProfit(vector<int> &prices) {
    int ans = 0, j = prices[0];
    for (int i = 1; i < prices.size(); ++i) {
      ans = max(ans, prices[i] - j);
      j = min(j, prices[i]);
    }
    return ans;
  }
  int maxProfitV1(vector<int> &prices) {
    int ans = 0;
    for (int i = 0; i < prices.size(); ++i) {
      for (int j = i + 1; j < prices.size(); ++j) {
        ans = max(ans, prices[j] - prices[i]);
      }
    }
    return ans;
  }

};

int main() {
  LC2682 sellStock;
  vector<int> ve{7, 1, 5, 3, 6, 4};
  int ans = sellStock.maxProfit(ve);
  if (ans == 5) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  cout << endl << "-----------" << endl;
  ve = {7, 6, 4, 3, 1};
  ans = sellStock.maxProfit(ve);
  if (ans == 0) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  cout << endl << "-----------" << endl;
  ve = {1};
  if (ans == 0) cout << "pass" << endl;
  else cout << "error!ans: " << ans << endl;
  return 0;
}
