package ru.steklopod

import org.scalatest.{FunSuite, Matchers}
import ru.steklopod.util.Parser._

import scala.util.{Failure, Success}

class InitFunSuite extends FunSuite with Matchers {

  private[this] val sessionValue = "$2a$10$SjInPRoSm"
  private[this] val url = "https://lenta.ru"

  test(" Test println() ") {
    println(sessionValue)
    sessionValue.isEmpty should be(false)
  }

  test("Parser") {
//    val keyWordObj = new KeyWord("смерть", 0, new URL("https://lenta.ru"))
    parseURL(url).foreach(println)
  }

  test("Get content from website"){
    getUrlContent(url) match {
      case Success(lines) => lines.foreach(println)
      case Failure(ex) => println(s"Problem rendering URL content: ${ex.getMessage}")
    }

  }

}
