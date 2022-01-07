package com.deloitte.demoApp.operations.operationImpl.math

import com.deloitte.demoApp.casting.ArgCaster
import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class Prod extends Operation {
  override def usage(): Unit = println(getSymbol + "\nproduct = 1 * 2 * 3 ...")

  override def getSymbol: String = "mult"

  override def doOperation(implicit options: Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster

    val output : String = typez.toLowerCase match {
      case "int" => caster.getIntList.product.toString
      case "double" => caster.getDoubleList.product.toString
      case "long" => caster.getLongList.product.toString
    }

    s"$output"
  }
}
