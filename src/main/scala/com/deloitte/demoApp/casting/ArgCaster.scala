package com.deloitte.demoApp.casting

import com.deloitte.demoApp.exceptions.CalcExceptions.ListCastError

import scala.util.{Failure, Success, Try}

class ArgCaster(implicit val operands: List[String]) {

  private val getInts = () => operands.map(_.toInt)
  private val getLongs = () => operands.map(_.toLong)
  private val getDoubles = () => operands.map(_.toDouble)

  def getLongList: List[Long] = catchException(getLongs, "Long")

  def getStringList: List[String] = operands

  def getDoubleList: List[Double] = catchException(getDoubles, "Double")

  def getIntList: List[Int] = catchException(getInts, "Integer")

  private def catchException[T](f: () => List[T], typez: String): List[T] = {
    val res = Try {
      f.apply
    }
    res match {
      case Success(value) => value
      case Failure(exception) => throw new ListCastError(s"Cannot cast list to $typez")
    }
  }
}
