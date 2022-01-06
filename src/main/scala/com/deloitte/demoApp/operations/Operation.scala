package com.deloitte.demoApp.operations

import com.deloitte.demoApp.cli.Config

trait Operation {
  def usage() : Unit
  def getSymbol: String
  def doOperation(implicit options: Config): String
}
