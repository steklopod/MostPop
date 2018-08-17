package ru.steklopod.parsers

import java.net.URL

import scala.io.Source
import scala.util.Try

object SimpleParser {

  def parseURL(url: String): Try[URL] = Try(new URL(url))

  def parseHttpUrl(url: String) = parseURL(url).filter(_.getProtocol == "http")

  def getUrlContent(url: String): Try[Iterator[String]] = {
    for {
      url <- parseURL(url)
      connection <- Try(url.openConnection())
      is <- Try(connection.getInputStream())
      source = Source.fromInputStream(is)
    } yield source.getLines()
  }

}