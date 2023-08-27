cmake_minimum_required(VERSION 3.17)
project(cpp-algorithm)

set(CMAKE_CXX_STANDARD 11)

add_executable(LC66 leetcode/array/LC66.cpp)
add_executable(LC121 leetcode/array/LC121.cpp)
add_executable(LC2682 leetcode/array/LC2682.cpp)
add_executable(LC136 leetcode/array/LC136.cpp leetcode/util/Utils.h leetcode/util/Utils.cpp)
add_executable(LC283 leetcode/array/LC283.cpp)
add_executable(LC1979 leetcode/array/LC1979.cpp leetcode/util/Utils.h leetcode/util/Utils.cpp)

add_executable(LC258 leetcode/math/LC258.cpp)
add_executable(LC231 leetcode/bitopt/LC231.cpp)
add_executable(LC242 leetcode/bitopt/LC242.cpp)

add_executable(LC430 leetcode/linked/LC430.cpp leetcode/structure/Node.h leetcode/util/Utils.h leetcode/util/Utils.cpp)
add_executable(LC138 leetcode/linked/LC138.cpp leetcode/structure/Node.h leetcode/util/Utils.h leetcode/util/Utils.cpp)
add_executable(LC2807 leetcode/linked/LC2807.cpp leetcode/structure/ListNode.h leetcode/util/Utils.h leetcode/util/Utils.cpp)

add_executable(LC1768 leetcode/string/LC1768.cpp)
add_executable(LC389 leetcode/string/LC389.cpp)
add_executable(LC28 leetcode/string/LC28.cpp leetcode/util/Utils.h leetcode/util/Utils.cpp)
