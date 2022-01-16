package com.deloitte.demoApp.exceptions

object CalcExceptions {
  class ListCastError(val msg : String) extends Exception(msg)
}
