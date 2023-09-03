
#include <string>
#include <iostream>

using namespace std;

/**
 * 1472. 设计浏览器历史记录
 * https://leetcode.cn/problems/design-browser-history/description/
 *
 * @author tiankai.me@gmail.com on 2023-09-03 11:49.
 */
struct ListNode {
  string val;
  ListNode *pre;
  ListNode *next;
  ListNode() : val(""), pre(nullptr), next(nullptr) {}
  ListNode(string x) : val(x), pre(nullptr), next(nullptr) {}
  ListNode(string x, ListNode *next) : val(x), pre(nullptr), next(next) {}
  ListNode(ListNode *pre, string x) : pre(pre), val(x), next(nullptr) {}
};

class BrowserHistory {
 public:
  ListNode *curr = nullptr;
  BrowserHistory(string homepage) {
    curr = new ListNode(homepage);
  }
  void visit(string url) {
    ListNode *node = new ListNode(curr, url);
    curr->next = node;
    curr = node;
  }
  string back(int steps) {
    while (steps-- > 0 && curr != nullptr && curr->pre != nullptr) {
      curr = curr->pre;
    }
    return curr->val;
  }
  string forward(int steps) {
    while (steps-- > 0 && curr != nullptr && curr->next != nullptr) {
      curr = curr->next;
    }
    return curr->val;
  }
};

int main(int argc, char **argv) {
  BrowserHistory browserHistory{"leetcode.com"};
  browserHistory.visit("google.com");               // 你原本在浏览 "leetcode.com" 。访问 "google.com"
  browserHistory.visit("facebook.com");             // 你原本在浏览 "google.com" 。访问 "facebook.com"
  browserHistory.visit("youtube.com");              // 你原本在浏览 "facebook.com" 。访问 "youtube.com"

  // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
  string ans = browserHistory.back(1);
  if ("facebook.com" == ans) cout << "pass" << endl;
  else cout << "error!, ans:" << ans << endl;

  // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
  ans = browserHistory.back(1);
  if ("google.com" == ans) cout << "pass" << endl;
  else cout << "error!, ans:" << ans << endl;

  // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
  ans = browserHistory.forward(1);
  if ("facebook.com" == ans) cout << "pass" << endl;
  else cout << "error!, ans:" << ans << endl;

  // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
  browserHistory.visit("linkedin.com");

  // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
  ans = browserHistory.forward(2);
  if ("linkedin.com" == ans) cout << "pass" << endl;
  else cout << "error!, ans:" << ans << endl;

  // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
  ans = browserHistory.back(2);
  if ("google.com" == ans) cout << "pass" << endl;
  else cout << "error!, ans:" << ans << endl;

  // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
  ans = browserHistory.back(7);
  if ("leetcode.com" == ans) cout << "pass" << endl;
  else cout << "error!, ans:" << ans << endl;

  return 0;
}