package com.deloitte.demoApp.operations.operationImpl.sort

import com.deloitte.demoApp.operations.Operation

class SortA extends Operation {
  override def usage(): Unit = println("Sort Asc. = 1 3 2 => 1 2 3")

  override def getSymbol: String = "sorta"

  override def doOperation(implicit args: Array[String]): String = {
    val list : List[String] = args.slice(1, args.length).toList
    list.map(x => x.toDouble).sortWith((x,y) => x < y).mkString(" ")
  }
}
