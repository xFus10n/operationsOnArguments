package com.deloitte.demoApp

import com.deloitte.demoApp.operations.OperationsHandler

import scala.util.Try

object MainApp extends App {
  implicit val arguments: Array[String] = args
  val operation = new OperationsHandler()
  if (operation.validArguments) {
    println(operation.processOperation)
  } else {
    Try {
      println(s"Operation not found for symbol << ${arguments(0)} >>")
    } getOrElse println("Error identifying operation")
  }
}
