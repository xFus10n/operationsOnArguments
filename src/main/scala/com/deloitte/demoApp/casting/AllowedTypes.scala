package com.deloitte.demoApp.casting

object AllowedTypes extends Enumeration {
  type OrderType = Value
  val int: AllowedTypes.Value = Value("int")
  val double: AllowedTypes.Value = Value("double")
  val long: AllowedTypes.Value = Value("long")

  def isAllowedType(s: String): Boolean = values.exists(_.toString == s)
  def getAllowedTypes: Any = values.fold("")((x, y) => x + " " + y )
}
