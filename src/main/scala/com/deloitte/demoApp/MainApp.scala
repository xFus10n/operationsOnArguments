package com.deloitte.demoApp

import com.deloitte.demoApp.cli.{CLIparser, Config}
import com.deloitte.demoApp.handler.OperationsHandler
import scala.util.Try

object MainApp extends App {

  /* cli options */
  val parser = new CLIparser(args)
  val options : Option[Config] = parser.getParser
  val output = options match {
    case Some(value) =>
      implicit val cmd: Config = value
      /* Operations */
      val operation = new OperationsHandler()
      Try {
        operation.processOperation
      } getOrElse s"Operation not found for symbol << ${cmd.operation} >>"
    case None => "Failed due to missing arguments"
  }
  println(output)
}
