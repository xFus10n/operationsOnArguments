package operations

import com.deloitte.demoApp.operations.OperationsHandler
import org.junit.jupiter.api.Assertions.{assertEquals, assertThrows, assertTrue}
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
  def testSumWithOneOperand(): Unit ={
    implicit val args : Array[String] = Array("sum", "2.1")
    val output = ops.processOperation
    assertEquals("2.1", output)
  }

  @Test
  def testSumWithNoOperand(): Unit ={
    implicit val args : Array[String] = Array("sum")
    val output = ops.processOperation
    assertEquals("0.0", output)
  }

  @Test
  def testWithNoArgs(): Unit ={
    implicit val args : Array[String] = Array()
    val exception = assertThrows(classOf[ArrayIndexOutOfBoundsException], () => {
      def test() = ops.processOperation
      test()
    })
    assertTrue(exception.toString.contains("ArrayIndexOutOfBoundsException"))
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
