package com.deloitte.demoApp.operations.operationImpl.math

import com.deloitte.demoApp.operations.Operation

class Div extends Operation {
  override def usage(): Unit = println(getSymbol + "\nDivision = 10 / 2 / 3 ...")

  override def getSymbol: String = "div"

  override def doOperation(implicit args: Array[String]): String = {
    var accumulator : Double = getArgument(1)
    for (item <- 2 until args.length) {
      accumulator /=  getArgument(item)
    }
    /* precision */
    val output = accumulator match {
      case d if d.isNaN      => "nan"
      case d if d.isInfinite => "inf"
      case d if d.isFinite   => BigDecimal(accumulator).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
    }
    s"$output"
  }
}
