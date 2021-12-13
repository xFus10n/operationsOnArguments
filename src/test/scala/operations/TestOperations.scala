package operations

import com.deloitte.demoApp.operations.OperationsHandler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestOperations {
  val ops : OperationsHandler = new OperationsHandler()

    @Test
    def testSum(): Unit ={
      implicit val args : Array[String] = Array("sum", "2.1", "3")
      val output = ops.processOperation
      assertEquals("5.1", output)
    }

  @Test
  def testSub(): Unit ={
    implicit val args : Array[String] = Array("sub", "5.1", "3")
    val output = ops.processOperation
    assertEquals("2.1", output)
  }

  @Test
  def testMultiplication(): Unit ={
    implicit val args : Array[String] = Array("mult", "5", "3")
    val output = ops.processOperation
    assertEquals("15.0", output)
  }
}
