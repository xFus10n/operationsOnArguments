package com.deloitte.demoApp.operations.operationImpl.sort

import com.deloitte.demoApp.casting.ArgCaster
import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class SortQ extends Operation{
  override def usage(): String = " : Quick Sort = 1 3 2 => 1 2 3"

  override def getSymbol: String = "sortq"

  override def doOperation(implicit options: Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster

    val output: List[AnyVal] = typez.toLowerCase match {
      case "int"    => caster.getIntList//bubbleSort[Int](caster.getIntList)
      case "double" => caster.getDoubleList//bubbleSortInJavaWay[Double](caster.getDoubleList)
      case "long"   => caster.getLongList//bubbleSort[Long](caster.getLongList)
    }

    output.mkString(" ")
  }


}
