package com.deloitte.demoApp.cli

import com.deloitte.demoApp.casting.AllowedTypes
import com.deloitte.demoApp.handler.{Operations, OperationsHandler}
import scopt.OptionParser

class CLIparser (args : Array[String]){
  val parser: OptionParser[Config] = new scopt.OptionParser[Config]("scopt") {
    head("scopt", "4.x")

    opt[String]('t', "type")
      .required()
      .valueName("<type>")
      .action((x, c) => c.copy(typez = x))
      .validate(x => {
        if (AllowedTypes.isAllowedType(x.toLowerCase)) success
        else failure(s"$x is not allowed type")
      })
      .text("types of incoming operands, allowed types :" + AllowedTypes.getAllowedTypes)

    opt[String]('o', "oper")
      .required()
      .valueName("<operation>")
      .action((x, c) => c.copy(operation = x))
      .text("performed operation on the operands")

    opt[Seq[String]]('a', "args")
      .required()
      .valueName("<operand1>, <operand2>, ...")
      .action((x,c) => c.copy(operands = x))
      .text("sequence of operands for the performed action")

    help("help").text(Operations.getPrintHelp)
  }

  def getParser: Option[Config] = {
  parser.parse(args, Config()) match {
      case Some(config) => Some(config)
      case None => None
    }
  }
}
