package com.deloitte.demoApp

import com.deloitte.demoApp.cli.{CLIparser, Config}
import com.deloitte.demoApp.exceptions.CalcExceptions.ListCastError
import com.deloitte.demoApp.handler.OperationsHandler

object MainApp extends App {

  /* cli options */
  val options: Option[Config] = new CLIparser(args).getParser
  val output = options match {
    case Some(value) => execute(value)
    case None => "Failed due to missing arguments"
  }
  println(output)

  def execute(implicit cmd: Config): String = {
    /* Operations */
    val operation = new OperationsHandler()
    try {
      operation.processOperation
    } catch {
      case e: ListCastError => e.toString
      case _: NoSuchElementException => s"Operation not found for symbol << ${cmd.operation} >>"
    }
  }
}
