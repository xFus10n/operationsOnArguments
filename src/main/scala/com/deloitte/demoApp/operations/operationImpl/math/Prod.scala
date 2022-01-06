//package com.deloitte.demoApp.operations.operationImpl.math
//
//import com.deloitte.demoApp.operations.{ArgCaster, Operation}
//
//class Prod extends Operation {
//  override def usage(): Unit = println(getSymbol + "\nproduct = 1 * 2 * 3 ...")
//
//  override def getSymbol: String = "mult"
//
//  override def doOperation(implicit args: Array[String]): String = {
//    var accumulator : Double = ArgCaster.get[Double](1).getOrElse(0.0)
//    for (item <- 2 until args.length) {
//      accumulator *=  ArgCaster.get[Double](item).get
//    }
//    /* precision */
//    val output = BigDecimal(accumulator).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
//    s"$output"
//  }
//}
