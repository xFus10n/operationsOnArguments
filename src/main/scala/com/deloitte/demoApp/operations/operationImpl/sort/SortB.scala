package com.deloitte.demoApp.operations.operationImpl.sort

import com.deloitte.demoApp.operations.Operation

class SortB extends Operation{
  override def usage(): Unit = println(getSymbol + "\nBubble Sort = 1 3 2 => 1 2 3")

  override def getSymbol: String = "sortb"

  override def doOperation(implicit args: Array[String]): String = {

    ""
  }
}
