package com.deloitte.demoApp.operations.operationImpl.sort

import com.deloitte.demoApp.casting.ArgCaster
import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class SortD extends Operation {
  override def usage(): Unit = println(getSymbol + "\nSort Desc. = 1 3 2 => 3 2 1")

  override def getSymbol: String = "sortd"

  override def doOperation(implicit options: Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster

    val output: String = typez.toLowerCase match {
      case "int" => caster.getIntList.sorted(Ordering.Int.reverse).mkString(" ")
      case "double" => caster.getDoubleList.sorted(Ordering.Double.TotalOrdering.reverse).mkString(" ")
      case "long" => caster.getLongList.sorted(Ordering.Long.reverse).mkString(" ")
    }

    s"$output"
  }
}
