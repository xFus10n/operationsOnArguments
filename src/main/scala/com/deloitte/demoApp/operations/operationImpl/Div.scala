package com.deloitte.demoApp.operations.operationImpl

import com.deloitte.demoApp.operations.Operation

class Div extends Operation {
  override def usage(): Unit = println("")

  override def getSymbol: String = "NoArgs"

  override def doOperation(implicit args: Array[String]): String = "0.0"
}
