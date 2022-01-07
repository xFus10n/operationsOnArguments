package com.deloitte.demoApp.operations

import com.deloitte.demoApp.cli.Config

trait Operation {
  def usage() : String
  def getSymbol: String
  def doOperation(implicit options: Config): String
}
