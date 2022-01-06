package com.deloitte.demoApp.operations.operationImpl.math

import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.{ArgCaster, Operation}

class Sub extends Operation {
  override def usage(): Unit = println(getSymbol + "\nsubtraction => 10 - 5 - 1 ...")

  override def getSymbol: String = "sub"

  override def doOperation(implicit options : Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez

    var accumulator : Double = ArgCaster.get[Double](0).get
    for (item <- 1 until operands.length) {
      accumulator -= ArgCaster.get[Double](item).get
    }
    /* precision */
    val output = BigDecimal(accumulator).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
    s"$output"
  }
}
