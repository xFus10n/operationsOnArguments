package com.deloitte.demoApp.operations.operationImpl

import com.deloitte.demoApp.operations.Operation

class Sum extends Operation {
  override def usage(): Unit = println("+ => Sum(1 .. N)")

  override def getSymbol: String = "sum"

  override def doOperation(implicit args: Array[String]): String = {
    var accumulator : Double = 0
    for (item <- 1 until args.length) {
      accumulator +=  getArgument(item)
    }
    /* precision */
    val output = BigDecimal(accumulator).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
    s"$output"
  }
}
