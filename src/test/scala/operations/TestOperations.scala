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
  def testSubWithOneArg(): Unit ={
    implicit val args : Array[String] = Array("sub", "5.1")
    val output = ops.processOperation
    assertEquals("5.1", output)
  }

  @Test
  def testSubWithNoOperand(): Unit ={
    implicit val args : Array[String] = Array("sub")
    val output = ops.processOperation
    assertEquals("0.0", output)
  }

  @Test
  def testMultiplication(): Unit ={
    implicit val args : Array[String] = Array("mult", "5", "3")
    val output = ops.processOperation
    assertEquals("15.0", output)
  }

  @Test
  def testMultiplicationWithOneArg(): Unit ={
    implicit val args : Array[String] = Array("mult", "5")
    val output = ops.processOperation
    assertEquals("5.0", output)
  }

  @Test
  def testDivision(): Unit ={
    implicit val args : Array[String] = Array("div", "100", "2", "0.5")
    val output = ops.processOperation
    assertEquals("100.0", output)
  }

  @Test
  def testDivisionWithOneArg(): Unit ={
    implicit val args : Array[String] = Array("div", "100")
    val output = ops.processOperation
    assertEquals("100.0", output)
  }

  @Test
  def testDivisionByZero(): Unit ={
    implicit val args : Array[String] = Array("div", "100", "0")
    val output = ops.processOperation
    assertEquals("inf", output)
  }

  @Test
  def testDivisionZeroBy(): Unit ={
    implicit val args : Array[String] = Array("div", "0", "100")
    val output = ops.processOperation
    assertEquals("0.0", output)
  }

  @Test
  def testDivisionOnNonNumber(): Unit ={
    implicit val args : Array[String] = Array("div", "5.5", "u")
    val output = ops.processOperation
    assertEquals("inf", output)
  }

  @Test
  def testSortAsc(): Unit ={
    implicit val args : Array[String] = Array("sorta", "1", "0", "3.5", "2.1")
    val output = ops.processOperation
    assertEquals("0 1 2.1 3.5", output)
  }
}
