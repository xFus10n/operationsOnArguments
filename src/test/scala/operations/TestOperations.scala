package operations

import com.deloitte.demoApp.cli.{CLIparser, Config}
import com.deloitte.demoApp.handler.OperationsHandler
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class TestOperations {
  val ops : OperationsHandler = new OperationsHandler()

  def getOutput(args : Array[String]) : String = {
    val parser = new CLIparser(args)
    implicit val options : Config = parser.getParser.get
    ops.processOperation
  }
    @Test
    def testSum(): Unit ={
      val args : Array[String] = Array("-o", "sum", "-t", "double", "-a", "2.1,3")
      val output = getOutput(args)
      assertEquals("5.1", output)
    }

  @Test
  def testSumWithOneOperand(): Unit ={
    val args : Array[String] = Array("-o", "sum", "-t", "int", "-a", "2")
    val output = getOutput(args)
    assertEquals("2", output)
  }

  @Test
  def testSub(): Unit ={
    val args : Array[String] = Array("-o", "sub", "-t", "int", "-a", "5,3")
    val output = getOutput(args)
    assertEquals("2", output)
  }

  @Test
  def testSubOneArg(): Unit ={
    val args : Array[String] = Array("-o", "sub", "-t", "Double", "-a", "5.0")
    val output = getOutput(args)
    assertEquals("5.0", output)
  }

  @Test
  def testMultiplication(): Unit ={
    val args : Array[String] = Array("-o", "mult", "-t", "double", "-a", "5,3")
    val output = getOutput(args)
    assertEquals("15.0", output)
  }

  @Test
  def testMultiplicationWithOneArg(): Unit ={
    val args : Array[String] = Array("-o", "mult", "-t", "double", "-a", "5")
    val output = getOutput(args)
    assertEquals("5.0", output)
  }

  @Test
  def testDivision(): Unit ={
    val args : Array[String] = Array("-o", "div", "-t", "int", "-a", "10,2,5")
    val output = getOutput(args)
    assertEquals("1", output)
  }

  @Test
  def testDivisionWithOneArg(): Unit ={
    val args : Array[String] = Array("-o", "div", "-t", "int", "-a", "2")
    val output = getOutput(args)
    assertEquals("2", output)
  }

  @Test
  def testDivisionByZero(): Unit ={
    val args : Array[String] = Array("-o", "div", "-t", "double", "-a", "2,0")
    val output = getOutput(args)
    assertEquals("Infinity", output)
  }

  @Test
  def testDivisionZeroBy(): Unit ={
    val args : Array[String] = Array("-o", "div", "-t", "int", "-a", "0,2")
    val output = getOutput(args)
    assertEquals("0", output)
  }

  @Test
  def testSortAsc(): Unit ={
    val args : Array[String] = Array("-o", "sorta", "-t", "int", "-a", "0,2,-1")
    val output = getOutput(args)
    assertEquals("-1 0 2", output)
  }

  @Test
  def testSortDesc(): Unit ={
    val args : Array[String] = Array("-o", "sortd", "-t", "Double", "-a", "0,2,1.3,-4.5")
    val output = getOutput(args)
    assertEquals("2.0 1.3 0.0 -4.5", output)
  }

  @Test
  def testSortBubble(): Unit ={
    val args : Array[String] = Array("-o", "sortb", "-t", "long", "-a", "-4,5,2,10")
    val output = getOutput(args)
    assertEquals("-4 2 5 10", output)
  }

  @Test
  def testSortQuick() : Unit = {
    val args : Array[String] = Array("-o", "sortq", "-t", "int", "-a", "1,3,9,5,4")
    val output = getOutput(args)
    assertEquals("1 3 4 5 9", output)
  }

  @Test
  def testSortQuickDouble() : Unit = {
    val args : Array[String] = Array("-o", "sortq", "-t", "double", "-a", "1.1,-3,9.0,5.5,4")
    val output = getOutput(args)
    assertEquals("-3.0 1.1 4.0 5.5 9.0", output)
  }
}
