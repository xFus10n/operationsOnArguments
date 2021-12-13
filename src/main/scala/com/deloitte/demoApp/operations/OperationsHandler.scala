package com.deloitte.demoApp.operations

import com.deloitte.demoApp.operations.operationImpl.{Sub, Sum}

import scala.util.Try

class OperationsHandler(var operationsMap : Map[String, Operation]= Map[String, Operation]()) {
  private val sum : Operation = new Sum()
  private val sub : Operation = new Sub()
  initMap()

  def initMap(): Unit = {
    operationsMap += (sum.getSymbol -> sum)
    operationsMap += (sub.getSymbol -> sub)
  }

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
