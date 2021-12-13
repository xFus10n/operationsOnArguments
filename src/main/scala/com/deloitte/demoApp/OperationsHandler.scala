package com.deloitte.demoApp

import com.deloitte.demoApp.operations.{Operation, Sum}

import scala.util.Try

class OperationsHandler(var operationsMap : Map[String, Operation]= Map[String, Operation]()) {
  private val sum : Operation = new Sum()
  initMap

  def initMap: Unit = {
    operationsMap += (sum.getSymbol -> sum)
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
