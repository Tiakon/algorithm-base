//
// Created by Administrator on 2023-08-26.
//
#include <iostream>

using namespace std;

void assertEqualInt(int expect,int actual) {
  if (expect == actual) cout << "pass" << endl;
  else cout << "error!" << actual << endl;
}
