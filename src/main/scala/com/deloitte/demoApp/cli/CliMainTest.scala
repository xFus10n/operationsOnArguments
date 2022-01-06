package com.deloitte.demoApp.cli

object CliMainTest extends App {
 val parser = new CLIparser(args)
 parser.getParser.get.operands.foreach(println)
}
