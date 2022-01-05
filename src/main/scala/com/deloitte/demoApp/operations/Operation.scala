package com.deloitte.demoApp.operations

trait Operation {
  def usage() : Unit
  def getSymbol: String
  def doOperation(implicit args : Array[String]): String
}
