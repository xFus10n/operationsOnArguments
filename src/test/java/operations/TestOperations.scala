package operations

import com.deloitte.demoApp.operations.{Operation, Sum}
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
}
