package com.deloitte.demoApp.operations.operationImpl.math

import com.deloitte.demoApp.casting.ArgCaster
import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class Sub extends Operation {
  override def usage(): String = " : subtraction => 10 - 5 - 1 ..."

  override def getSymbol: String = "sub"

  override def doOperation(implicit options: Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster

    val output = typez.toLowerCase match {
      case "int" => sub_v2[Int](caster.getIntList).toString //caster.getIntList.reduce(_ - _).toString
      case "double" => sub_v1[Double](caster.getDoubleList).toString //caster.getDoubleList.reduce(_ - _).toString
      case "long" => caster.getLongList.reduce(_ - _).toString
    }

    s"$output"
  }

  def sub_v1[T: Numeric](list: List[T]): T = list.reduce(implicitly[Numeric[T]].minus)

  def sub_v2[T](list: List[T])(implicit num: Numeric[T]): T = list.reduce((x, y) => num.minus(x, y))
}
