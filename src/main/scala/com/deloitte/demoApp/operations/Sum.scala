package com.deloitte.demoApp.operations

class Sum extends Operation {
  override def usage(): Unit = println("+ => Sum(1..N)")

  override def getSymbol: String = "+"

  override def doOperation(implicit args: Array[String]): String = {
    val x: Double = getArgument(1)
    val y: Double = getArgument(2)
    val z: Double = x + y
    s"$z"
  }
}
