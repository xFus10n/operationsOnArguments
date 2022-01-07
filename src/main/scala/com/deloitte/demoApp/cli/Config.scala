package com.deloitte.demoApp.cli

case class Config( typez:     String = "",
                   operation: String = "",
                   help: Boolean = false,
                   operands:  Seq[String] = Seq())
