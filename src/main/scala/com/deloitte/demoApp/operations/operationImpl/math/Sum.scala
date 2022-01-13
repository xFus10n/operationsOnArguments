package com.deloitte.demoApp.operations.operationImpl.math

import com.deloitte.demoApp.casting.ArgCaster
import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class Sum extends Operation {
  override def usage(): String = " : addition => 1 + 2 + 3 ..."

  override def getSymbol: String = "sum"

  override def doOperation(implicit options: Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster

    val output : String = typez.toLowerCase match {
      case "int" => sum_v1[Int](caster.getIntList).toString //caster.getIntList.sum.toString
      case "double" => sum_v2[Double](caster.getDoubleList).toString//caster.getDoubleList.sum.toString
      case "long" => sum_v3[Long](caster.getLongList).toString
    }

    s"$output"
  }

  def sum_v1[T](list: List[T])(implicit num: Numeric[T]) : T = {
    import num._
    if (list.isEmpty) zero
    else list.head + sum_v1(list.tail)
  }

  def sum_v2[T : Numeric](list: List[T]): T = {
    if (list.isEmpty) implicitly[Numeric[T]].zero
    else implicitly[Numeric[T]].plus(list.head, sum_v2(list.tail))
  }

  def sum_v3[T](list: List[T])(implicit num: Numeric[T]) : T = list.reduce(num.plus)
}
