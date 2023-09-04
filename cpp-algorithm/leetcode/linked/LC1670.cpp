
#include <list>
using namespace std;

/**
 * 1670. 设计前中后队列
 * https://leetcode.cn/problems/design-front-middle-back-queue/
 * @author tiankai.me@gmail.com on 2023-09-04 14:31.
 */
class FrontMiddleBackQueue {
 private:
  list<int> q;
  // 指向正中间的指针
  list<int>::iterator it;
  // 指针目前位于第几个元素
  int ptrpos;

 public:
  FrontMiddleBackQueue() : q{initializer_list<int>{42, 42}}, it{q.begin()}, ptrpos{0} {}

  void pushFront(int val) {
    // 指针不指向哑头节点
    if (ptrpos != 0) {
      ++ptrpos;
    }
    q.insert(next(q.begin()), val);
  }

  void pushMiddle(int val) {
    int pos = q.size() / 2;
    // 均摊 O(1)
    advance(it, pos - ptrpos);
    q.insert(it, val);
    ptrpos = pos + 1;
  }

  void pushBack(int val) {
    // 指针指向哑尾节点
    if (ptrpos == q.size() - 1) {
      ++ptrpos;
    }
    q.insert(prev(q.end()), val);
  }

  int popFront() {
    if (q.size() == 2) {
      return -1;
    }
    int ret = *next(q.begin());
    if (ptrpos == 1) {
      it = q.erase(it);
    } else {
      q.erase(next(q.begin()));
      // 指针不指向哑头节点
      if (ptrpos != 0) {
        --ptrpos;
      }
    }
    return ret;
  }

  int popMiddle() {
    if (q.size() == 2) {
      return -1;
    }
    int pos = (q.size() - 1) / 2;
    // 均摊 O(1)
    advance(it, pos - ptrpos);
    int ret = *it;
    it = q.erase(it);
    ptrpos = pos;
    return ret;
  }

  int popBack() {
    if (q.size() == 2) {
      return -1;
    }
    int ret = *prev(prev(q.end()));
    if (ptrpos == q.size() - 2) {
      it = q.erase(it);
    } else {
      q.erase(prev(prev(q.end())));
      // 指针指向哑尾节点
      if (ptrpos == q.size()) {
        --ptrpos;
      }
    }
    return ret;
  }
};

