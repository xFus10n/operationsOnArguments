//package com.deloitte.demoApp.operations.operationImpl.math
//
//import com.deloitte.demoApp.operations.{ArgCaster, Operation}
//
//class Sub extends Operation {
//  override def usage(): Unit = println(getSymbol + "\nsubtraction => 10 - 5 - 1 ...")
//
//  override def getSymbol: String = "sub"
//
//  override def doOperation(implicit args: Array[String]): String = {
//    var accumulator : Double = ArgCaster.get[Double](1).getOrElse(0.0)
//    for (item <- 2 until args.length) {
//      accumulator -= ArgCaster.get[Double](item).get
//    }
//    /* precision */
//    val output = BigDecimal(accumulator).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
//    s"$output"
//  }
//}
