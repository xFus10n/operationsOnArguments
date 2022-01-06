package com.deloitte.demoApp.operations.operationImpl.math

import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.{ArgCaster, Operation}

class Sum extends Operation {
  override def usage(): Unit = println(getSymbol + "\naddition => 1 + 2 + 3 ...")

  override def getSymbol: String = "sum"

  override def doOperation(implicit options : Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez

    var accumulator : Double = 0.0
    for (item <- operands.indices) {
      accumulator += ArgCaster.get[Double](item).get
    }

    /* precision */
    val output = BigDecimal(accumulator).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
    s"$output"
  }
}
