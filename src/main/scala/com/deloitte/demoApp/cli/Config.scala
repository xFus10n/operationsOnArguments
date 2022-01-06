package com.deloitte.demoApp.cli

case class Config(
                   typez:     String = "",
                   operation: String = "",
                   operands:  Seq[String] = Seq())
