package com.deloitte.demoApp.handler

import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class OperationsHandler(val operationsMap : Map[String, Operation] = ConcreteImplementationsHandler.getOperations) {

  def processOperation(implicit options : Config) : String = {
      val operation = operationsMap(options.operation)
      operation.doOperation
  }

  def printHelp() : Unit = {
    println("Calculator usage: ")
    operationsMap.foreach( item => {
      item._2.usage()
    })
  }
}
