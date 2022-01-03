package com.deloitte.demoApp.handler

import com.deloitte.demoApp.operations.Operation

import scala.util.Try

class OperationsHandler(val operationsMap : Map[String, Operation] = ConcreteImplementationsHandler.getOperations) {

  def validArguments(implicit args: Array[String]): Boolean = {
    Try {
      operationsMap.contains(args(0))
    }.getOrElse(false)
  }

  def processOperation(implicit args : Array[String]) : String = {
      val operation = operationsMap(args(0))
      operation.doOperation
  }

  def printHelp : Unit = {
    println("Calculator usage: ")
    operationsMap.foreach( item => {
      val help = item._2.getSymbol + " : " + item._2.usage()
      print(help)
    })
  }
}
