package ru.steklopod.util

import java.net.URL

import scala.util.Try

object Parser {

  def parseURL(url: String): Try[URL] = Try(new URL(url))

}
