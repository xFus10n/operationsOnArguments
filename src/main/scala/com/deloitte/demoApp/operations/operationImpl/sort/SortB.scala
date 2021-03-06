package com.deloitte.demoApp.operations.operationImpl.sort

import com.deloitte.demoApp.casting.ArgCaster
import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation

class SortB extends Operation {
  override def usage(): String = " : Bubble Sort = 1 3 2 => 1 2 3"

  override def getSymbol: String = "sortb"

  override def doOperation(implicit options: Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster

    val output: List[AnyVal] = typez.toLowerCase match {
      case "int"    => bubbleSort[Int](caster.getIntList)
      case "double" => bubbleSortInJavaWay[Double](caster.getDoubleList)
      case "long"   => bubbleSort[Long](caster.getLongList)
    }

    output.mkString(" ")
  }

  def bubbleSortInJavaWay[T](list: List[T])(implicit ev: T => Ordered[T]): List[T] = {
    var listM = list
    var swap: Boolean = false
    val size = list.length - 1
    do {
      swap = false
      for (i <- 0 until size) {
        if (i < size) {
          val leadingElement = listM(i)
          val tailingElement = listM(i + 1)
          if (leadingElement > tailingElement) {
            swap = true
            listM = listM.updated(i, tailingElement)
            listM = listM.updated(i + 1, leadingElement)
          }
        }
      }
    } while (swap.equals(true))
    listM
  }

  // :: - append new element to a list , creates new list
  def getLargest[T](data: List[T])(implicit ev: T => Ordered[T]): (T, List[T]) =
  //  def getLargest(data: List[Double]): (Double, List[Double]) =
    data match {
      case head :: Nil => (head, Nil) // last element of list (head :: nil ~> List(1, nil) )
      case head :: tail => // not last element, tail ~> all other elements of list except first
        val (large, remaining) = getLargest(tail) // (int , List) => (current , List(remaining elements))
        if (large > head) // compare 2 side elements List(x, y, z ...) ~> x > y
          (large, head :: remaining) // if true ~> swap and append remaining part
        else
          (head, large :: remaining) // if not ~> keep order and append remaining part
    }

  // ::: - concatenates two lists, creates new list
  def bubbleSort[T](data: List[T])(implicit ev: T => Ordered[T]): List[T] =
  //  def bubbleSort(data: List[Double]): List[Double] =
    data match {
      case Nil => Nil
      case _ =>
        val (greatest, tail) = getLargest(data)
        bubbleSort(tail) ::: List(greatest)
    }
}
