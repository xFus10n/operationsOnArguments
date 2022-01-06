package com.deloitte.demoApp.handler

import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

import scala.util.Try

class OperationsHandler(val operationsMap : Map[String, Operation] = ConcreteImplementationsHandler.getOperations) {

  // obsolete
  def validArguments(implicit args: Array[String]): Boolean = {
    Try {
      operationsMap.contains(args(0))
    }.getOrElse(false)
  }

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
