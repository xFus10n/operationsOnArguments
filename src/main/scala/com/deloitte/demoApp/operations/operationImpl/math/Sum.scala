package com.deloitte.demoApp.operations.operationImpl.math

import com.deloitte.demoApp.casting.ArgCaster
import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class Sum extends Operation {
  override def usage(): Unit = println(getSymbol + "\naddition => 1 + 2 + 3 ...")

  override def getSymbol: String = "sum"

  override def doOperation(implicit options: Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster

    val output : String = typez.toLowerCase match {
      case "int" => caster.getIntList.sum.toString
      case "double" => caster.getDoubleList.sum.toString
      case "long" => caster.getLongList.sum.toString
    }

    s"$output"
  }
}
