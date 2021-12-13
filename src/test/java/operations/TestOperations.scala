package operations

import com.deloitte.demoApp.operations.Operation
import com.deloitte.demoApp.operations.operationImpl.{Sub, Sum}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object TestOperations {
    @Test
    def testSum(): Unit ={
      implicit val args : Array[String] = Array("+", "2.1", "3")
      val sum : Operation = new Sum()
      sum.usage()
      assertEquals("+", sum.getSymbol)
      assertEquals("5.1", sum.doOperation)
    }

  @Test
  def testSub(): Unit ={
    implicit val args : Array[String] = Array("+", "5.1", "3")
    val sub : Operation = new Sub()
    sub.usage()
    assertEquals("-", sub.getSymbol)
    assertEquals("2.1", sub.doOperation)
  }
}
