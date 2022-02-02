package com.deloitte.demoApp.operations.operationImpl.sort

import com.deloitte.demoApp.casting.ArgCaster
import com.deloitte.demoApp.cli.Config
import com.deloitte.demoApp.operations.Operation
import com.deloitte.demoApp.operations.operationImpl.sort.SortQ.quicksort

class SortQ extends Operation{
  override def usage(): String = " : Quick Sort = 1 3 2 => 1 2 3"

  override def getSymbol: String = "sortq"

  override def doOperation(implicit options: Config): String = {
    implicit val operands: List[String] = options.operands.toList
    val typez: String = options.typez
    val caster = new ArgCaster
    val limit = caster.operandsSize - 1

    val output: List[AnyVal] = typez.toLowerCase match {
      case "int"    => quicksort(caster.getIntList.toArray, 0, limit).toList
      case "double" => caster.getDoubleList//bubbleSortInJavaWay[Double](caster.getDoubleList)
      case "long"   => caster.getLongList//bubbleSort[Long](caster.getLongList)
    }

    output.mkString(" ")
  }
}

object SortQ {

  /** Performs recursive quicksort on an array
   *
   * There's an opportunity for limiting space complexity to
   * O(ln(n)) here if we recurse on the larger partition last
   * (tail recursion).
   *  */
  def quicksort[T](array: Array[T], low: Int, hi: Int)(implicit ev: T => Ordered[T]): Array[T] = {
    if (low < hi) {
      val p = partition(array, low, hi)
      quicksort(array, low, p-1)
      quicksort(array, p+1, hi)
    }

    /** Partition an array around some pivot
     *
     *  Chooses a pivot, moves all values less than
     *  the pivot to its left, and moves all values
     *  greater than the pivot to its right.
     *
     *  To optimize: choose pivot corresponding to a median
     *  value of some sample. This helps ensure the
     *  partitioning results in similarly-sized sub-arrays,
     *  and thus the optimal O(n*ln(n)) performance.
     *
     *  @return index (location) of pivot in partitioned array
     */
    def partition[A](subArray: Array[A], low: Int, hi: Int)(implicit ev: A => Ordered[A]): Int = {
      val pivot = hi
      var i = low
      for (
        j <- low to hi
        if subArray(j) < subArray(pivot)
      ) {swap(subArray, i, j); i+=1}

      // Lastly, move pivot value to the dividing line at i
      swap(subArray, i, pivot)
      i
    }

    array
  }

  /** Swaps two values in an array */
  def swap[T](array: Array[T], pos1: Int, pos2: Int): Unit = {
    val stash = array(pos1)
    array(pos1) = array(pos2)
    array(pos2) = stash
  }
}