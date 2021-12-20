package com.deloitte.demoApp.operations

import com.deloitte.demoApp.operations.operationImpl.math.{Div, Prod, Sub, Sum}
import com.deloitte.demoApp.operations.operationImpl.sort.SortA

import scala.util.Try

class OperationsHandler(var operationsMap : Map[String, Operation]= Map[String, Operation]()) {
  private val sum : Operation = new Sum()
  private val sub : Operation = new Sub()
  private val mult : Operation = new Prod()
  private val div : Operation = new Div()
  private val sorta : Operation = new SortA()
  initMap()

  def initMap(): Unit = {
    operationsMap += (sum.getSymbol -> sum)
    operationsMap += (sub.getSymbol -> sub)
    operationsMap += (mult.getSymbol -> mult)
    operationsMap += (div.getSymbol -> div)
    operationsMap += (sorta.getSymbol -> sorta)
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
