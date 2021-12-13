package operations

import com.deloitte.demoApp.operations.Operation
import com.deloitte.demoApp.operations.operationImpl.{Prod, Sub, Sum}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestOperations {
    @Test
    def testSum(): Unit ={
      implicit val args : Array[String] = Array("+", "2.1", "3")
      val sum : Operation = new Sum()
      sum.usage()
      assertEquals("sum", sum.getSymbol)
      assertEquals("5.1", sum.doOperation)
    }

  @Test
  def testSub(): Unit ={
    implicit val args : Array[String] = Array("+", "5.1", "3")
    val sub : Operation = new Sub()
    sub.usage()
    assertEquals("sub", sub.getSymbol)
    assertEquals("2.1", sub.doOperation)
  }

  @Test
  def testMultiplication(): Unit ={
    implicit val args : Array[String] = Array("*", "5", "3")
    val prod : Operation = new Prod()
    prod.usage()
    assertEquals("mult", prod.getSymbol)
    assertEquals("15.0", prod.doOperation)
  }
}
