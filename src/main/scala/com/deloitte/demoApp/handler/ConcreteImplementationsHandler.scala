package com.deloitte.demoApp.handler

import com.deloitte.demoApp.operations.Operation
import org.clapper.classutil.ClassFinder

import scala.collection.mutable.ListBuffer

object ConcreteImplementationsHandler {

  def getOperations: Map[String, Operation]= {
    val finder = ClassFinder()
    val impl = ClassFinder.concreteSubclasses("com.deloitte.demoApp.operations.Operation",
      finder.getClasses())

    val ops = new ListBuffer[Operation]()
    for (item <- impl) {
      ops += Class.forName(item.toString()).newInstance.asInstanceOf[Operation]
    }
    toMap(ops.toList)
  }

  private def toMap(list: List[Operation]): Map[String, Operation] = {
    Map(list map {op => (op.getSymbol, op)} :_*)
  }
}
