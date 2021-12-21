package com.deloitte.demoApp.operations

import com.deloitte.demoApp.handler.Handler

import scala.util.Try

class OperationsHandler(val operationsMap : Map[String, Operation] = Handler.getOperations) {

  def validArguments(implicit args: Array[String]): Boolean = {
    Try {
      operationsMap.contains(args(0))
    }.getOrElse(false)
  }

  def processOperation(implicit args : Array[String]) : String = {
      val operation = operationsMap(args(0))
      operation.doOperation
  }
}
