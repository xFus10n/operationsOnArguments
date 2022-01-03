package com.deloitte.demoApp.operations.operationImpl.sort

import com.deloitte.demoApp.operations.Operation

class SortB extends Operation{
  override def usage(): Unit = println(getSymbol + "\nBubble Sort = 1 3 2 => 1 2 3")

  override def getSymbol: String = "sortb"

  override def doOperation(implicit args: Array[String]): String = {
    var list : List[Double] = args.slice(1, args.length).toList.map(_.toDouble)
    var swap : Boolean = false
    val size = list.length - 1
    do {
      swap = false
      for (i <- 0 until size) {
        if (i < size) {
          val leadingElement = list(i)
          val tailingElement = list(i + 1)
          if (leadingElement > tailingElement) {
            swap = true
            list = list.updated(i, tailingElement)
            list = list.updated(i + 1, leadingElement)
          }
        }
      }
    } while (swap.equals(true))

    list.mkString(" ")
  }
}
