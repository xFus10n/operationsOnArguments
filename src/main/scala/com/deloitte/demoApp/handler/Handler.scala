package com.deloitte.demoApp.handler

import org.clapper.classutil.ClassFinder

object Handler extends App {
  val finder = ClassFinder()
  val impl = ClassFinder.concreteSubclasses("com.deloitte.demoApp.operations.Operation",
    finder.getClasses())

  impl.foreach(println)
}
