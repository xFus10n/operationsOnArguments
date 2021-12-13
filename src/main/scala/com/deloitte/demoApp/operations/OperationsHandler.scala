package com.deloitte.demoApp.operations

import com.deloitte.demoApp.operations.operationImpl.{Prod, Sub, Sum}

import scala.util.Try

class OperationsHandler(var operationsMap : Map[String, Operation]= Map[String, Operation]()) {
  private val sum : Operation = new Sum()
  private val sub : Operation = new Sub()
  private val mult : Operation = new Prod()
  initMap()

  def initMap(): Unit = {
    operationsMap += (sum.getSymbol -> sum)
    operationsMap += (sub.getSymbol -> sub)
    operationsMap += (mult.getSymbol -> mult)
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
