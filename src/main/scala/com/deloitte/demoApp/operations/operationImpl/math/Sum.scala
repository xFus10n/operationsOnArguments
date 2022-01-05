package com.deloitte.demoApp.operations.operationImpl.math

import com.deloitte.demoApp.operations.{ArgCaster, Operation}

class Sum extends Operation {
  override def usage(): Unit = println(getSymbol + "\naddition => 1 + 2 + 3 ...")

  override def getSymbol: String = "sum"

  override def doOperation(implicit args: Array[String]): String = {
    var accumulator : Double = 0.0
    for (item <- 1 until args.length) {
      accumulator += ArgCaster.get[Double](item).get
    }
    /* precision */
    val output = BigDecimal(accumulator).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
    s"$output"
  }
}
