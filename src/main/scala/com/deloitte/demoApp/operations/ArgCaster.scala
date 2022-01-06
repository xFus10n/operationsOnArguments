package com.deloitte.demoApp.operations

import scala.util.Try

object ArgCaster {

  def get[T](item: Int)(implicit converter: Converter[T], arrayElement: List[String]): Option[T] = {
    Try {
      Some(converter.convert(arrayElement(item)))
    } getOrElse None
  }

  trait Converter[T] {
    def convert(v: String): T
  }

  object Converter {
    implicit val longLoader: Converter[Long] = (v: String) => v.toLong
    implicit val stringLoader: Converter[String] = (v: String) => v
    implicit val intLoader: Converter[Int] = (v: String) => v.toInt
    implicit val doubleLoader: Converter[Double] = (v: String) => Try {v.toDouble}.getOrElse(0.0)
    // Add any other types you want to convert to, even custom types!
  }
}
