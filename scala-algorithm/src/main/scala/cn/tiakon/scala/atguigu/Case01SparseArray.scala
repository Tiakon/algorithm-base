package cn.tiakon.scala.atguigu

import java.io.{File, PrintWriter}

import org.slf4j.{Logger, LoggerFactory}

import scala.io.{BufferedSource, Source}

/**
  * 稀疏数组
  *
  * 基本介绍
  * 当一个数组中大部分元素为0，或者为同一个值的数组时，可以使用稀疏数组来保 存该数组。
  *
  * 稀疏数组的处理方法是:
  * 1)   记录数组一共有几行几列，有多少个不同的值
  * 2)   把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模。
  *
  * project : algorithm-base
  * package : cn.tiakon.scala
  * email : tiankai.me@gmail.com
  *
  * @author Created by Tiakon on 2019/2/26 0:14.
  */
object Case01SparseArray {
  private val logger: Logger = LoggerFactory.getLogger(Case01SparseArray.getClass)

  def main(args: Array[String]): Unit = {

    val chessboard = Array.ofDim[Int](11, 11)
    chessboard(2)(3) = 1
    chessboard(6)(8) = 2

    val sparseArray = collection.mutable.ArrayBuffer[Node]()
    val recordBuffer = new StringBuffer()
    sparseArray += Node(11, 11, 0)
    recordBuffer.append(s"${11}\t${11}\t${0}\n")
    for (i <- chessboard.indices) {
      for (j <- chessboard(i).indices) {
        printf("%d\t", chessboard(i)(j))
        if (chessboard(i)(j) != 0) {
          recordBuffer.append(s"$i\t$j\t${chessboard(i)(j)}\n")
          sparseArray.append(Node(i, j, chessboard(i)(j)))
        }
      }
      println("")
    }
    logger.warn("-> 将二维数组进行压缩 ")
    for (elem <- sparseArray) {
      printf("%d\t%d\t%d\n", elem.row, elem.col, elem.value)
    }
    val recordStr = "D:\\testdata\\user\\tiakon\\algorithm-base\\scala\\Case01SparseArray\\record"
    logger.warn(s"-> 开始存盘到 : {}", recordStr)
    val recordFile = new File(recordStr)
    // 不对文件覆盖，只对内容追加时该怎么办？
    val printWriter = new PrintWriter(recordFile)
    printWriter.write(recordBuffer.toString, 0, recordBuffer.toString.length)
    printWriter.flush()
    printWriter.close()
    logger.warn("-> 存盘结束...")

    logger.warn("-> 开始续盘...")
    logger.warn("-> 还原棋盘...")
    val source: BufferedSource = Source.fromFile(recordFile)
    val recordArray: Array[String] = source.getLines().toArray
    val rowSize = recordArray(0).split("\t")(0).toInt
    val colSize = recordArray(0).split("\t")(1).toInt

    val chessArr: Array[Array[Int]] = Array.ofDim[Int](rowSize, colSize)
    for (i <- 1 until recordArray.length) {
      val row = recordArray(i).split("\t")(0).toInt
      val col = recordArray(i).split("\t")(1).toInt
      val value = recordArray(i).split("\t")(2).toInt
      chessArr(row)(col) = value
    }
    for (i <- chessArr.indices) {
      for (j <- 0 until chessArr(i).length) {
        printf("%d\t", chessArr(i)(j))
      }
      println("")
    }
  }
}

case class Node(row: Int, col: Int, value: Int)
