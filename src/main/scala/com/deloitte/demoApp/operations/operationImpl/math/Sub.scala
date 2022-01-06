package com.deloitte.demoApp.operations.operationImpl.math

import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.{ArgCaster, Operation}

class Sub extends Operation {
  override def usage(): Unit = println(getSymbol + "\nsubtraction => 10 - 5 - 1 ...")

  override def getSymbol: String = "sub"

  override def doOperation(implicit options : Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster

    val output = typez.toLowerCase match {
      case "int" => caster.getIntList.reduce(_ - _).toString
      case "double" => caster.getDoubleList.reduce(_ - _).toString
      case "long" => caster.getLongList.reduce(_ - _).toString
    }

    s"$output"
  }
}
