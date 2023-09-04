
#include <vector>

using namespace std;

class LC912 {
 public:
  // 插入排序
  vector<int> sortArray(vector<int> &nums) {
    for (int i = 0; i < nums.size(); i++) {
      for (int j = i + 1; j < nums.size(); j++) {
        if (nums[i] > nums[j]) {
          swap(nums[i], nums[j]);
        }
      }
    }
    return nums;
  }
};