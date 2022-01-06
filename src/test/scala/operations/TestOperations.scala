package operations

import com.deloitte.demoApp.MainApp.args
import com.deloitte.demoApp.cli.{CLIparser, Config}
import com.deloitte.demoApp.handler.OperationsHandler
import org.junit.jupiter.api.Assertions.{assertEquals, assertThrows, assertTrue}
import org.junit.jupiter.api.Test


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

  /* validate / handle missing options in cli / handle incorrect format args*/

  @Test
  def testSub(): Unit ={
    val args : Array[String] = Array("-o", "sub", "-t", "int", "-a", "5,3")
    val output = getOutput(args)
    assertEquals("2", output)
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

//  @Test
//  def testSortAsc(): Unit ={
//    implicit val args : Array[String] = Array("sorta", "10", "5", "1", "0")
//    val output = ops.processOperation
//    assertEquals("0.0 1.0 5.0 10.0", output)
//  }
//
//  @Test
//  def testSortDesc(): Unit ={
//    implicit val args : Array[String] = Array("sortd", "1", "5", "10.1", "7.5")
//    val output = ops.processOperation
//    assertEquals("10.1 7.5 5.0 1.0", output)
//  }
//
//  @Test
//  def testSortBubble(): Unit ={
//    implicit val args : Array[String] = Array("sortb", "1", "5", "10.1", "7.5", "4")
//    val output = ops.processOperation
//    assertEquals("1.0 4.0 5.0 7.5 10.1", output)
//  }
}
