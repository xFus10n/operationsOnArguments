package com.deloitte.demoApp.operations.operationImpl

import com.deloitte.demoApp.operations.Operation

class Sub extends Operation {
  override def usage(): Unit = println("- => Sub(1 .. N)")

  override def getSymbol: String = "sub"

  override def doOperation(implicit args: Array[String]): String = {
    var accumulator : Double = getArgument(1)
    for (item <- 2 until args.length) {
      accumulator -=  getArgument(item)
    }
    /* precision */
    val output = BigDecimal(accumulator).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
    s"$output"
  }
}
