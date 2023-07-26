package cn.tiakon.scala.atguigu

;

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

object HeapSort {
  def main(args: Array[String]): Unit = {
    var arr = ArrayBuffer(4, 6, 8, 5, 9)
    println(sort(arr))
    /*
     *      4
     *   6     8
     * 5   9
     * */
  }

  def sort(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var i = arr.length / 2 //从第一个非叶子结点开始调整使其满足大顶堆定义.
    //从左到右,自下而上,构建大顶堆.
    while (i >= 1) {
      heap(arr, i - 1, arr.length - 1)
      i -= 1
    }
    var j = arr.length - 1
    //自上而下从大顶堆中将最大数放置末尾,并且余下的结构也要满足大顶堆的定义.
    while (j > 0) {
      val x = arr(0)
      arr(0) = arr(j)
      arr(j) = x
      heap(arr, 0, j - 1)
      j -= 1
    }
    arr
  }

  def heap(arr: ArrayBuffer[Int], m: Int, j: Int): Unit = {
    var i = m
    var k = 2 * i + 1 //左子节点的索引.
    val x = arr(i)
    breakable {
      while (k <= j) {
        if (k < j) if (arr(k) < arr(k + 1)) k += 1 //此时,判断左右子结点谁大,就记录谁的索引.
        if (x >= arr(k)) break //如何父节点大于左右结点的较大值,满足大顶堆定义,直接跳出.
        else { //否则,将左右子结点中的较大值给父节点.
          arr(i) = arr(k)
          i = k //继续检查交换后的结点是否满足大顶堆的定义.
          k = 2 * i + 1 //记录的是左子结点的索引.
        }
      }
    }
    arr(i) = x //将父节点的值赋给子节点
  }
}
