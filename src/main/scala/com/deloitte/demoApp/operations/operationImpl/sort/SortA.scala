package com.deloitte.demoApp.operations.operationImpl.sort

import com.deloitte.demoApp.casting.ArgCaster
import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class SortA extends Operation {
  override def usage(): String = " : Sort Asc. = 1 3 2 => 1 2 3"

  override def getSymbol: String = "sorta"

  override def doOperation(implicit options: Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster

    val output: String = typez.toLowerCase match {
      case "int" => caster.getIntList.sorted.mkString(" ")
      case "double" => caster.getDoubleList.sorted.mkString(" ")
      case "long" => caster.getLongList.sorted.mkString(" ")
    }

    s"$output"
  }
}
