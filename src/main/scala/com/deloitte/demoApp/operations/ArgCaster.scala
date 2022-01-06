package com.deloitte.demoApp.operations

class ArgCaster(implicit val operands: List[String]) {

  def getLongList: List[Long] = operands.map(_.toLong)

  def getStringList: List[String] = operands

  def getDoubleList: List[Double] = operands.map(_.toDouble)

  def getIntList: List[Int] = operands.map(_.toInt)

  object Types extends Enumeration {
    type Type = Value
    val String, Int, Double, Long = Value
  }
}
