package com.deloitte.demoApp.handler

import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class OperationsHandler(val operationsMap : Map[String, Operation] = ConcreteImplementationsHandler.getOperations) {

  def processOperation(implicit options : Config) : String = {
      val operation = operationsMap(options.operation)
      operation.doOperation
  }
}

object Operations {
  def getPrintHelp: String = {
    val operationsMap = new OperationsHandler().operationsMap
    operationsMap.map(item => "\n" + item._2.getSymbol + item._2.usage()).toList.sorted.mkString
  }
}