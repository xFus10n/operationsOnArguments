package com.deloitte.demoApp

import com.deloitte.demoApp.cli.{CLIparser, Config}
import com.deloitte.demoApp.handler.OperationsHandler

//import scala.util.Try

object MainApp extends App {

  /* cli options */
  val parser = new CLIparser(args)
  implicit val options : Config = parser.getParser.get

  /* Operations */
  val operation = new OperationsHandler()
  println(operation.processOperation)

//  implicit val arguments: Array[String] = args
//  val operation = new OperationsHandler()
//  if (operation.validArguments) {
//    println(operation.processOperation)
//  } else {
//    Try {
//      println(s"Operation not found for symbol << ${arguments(0)} >>")
//      operation.printHelp()
//    } getOrElse println("Error identifying operation")
//  }
}
