package com.deloitte.demoApp.operations

import scala.util.Try

trait Operation {
  def usage() : Unit
  def getSymbol: String
  def doOperation(implicit args : Array[String]): String

  def getArgument(element: Int)(implicit arrayElement: Array[String]) = {
    Try {
      arrayElement(element).toDouble
    }.getOrElse(0.0)
  }
}
