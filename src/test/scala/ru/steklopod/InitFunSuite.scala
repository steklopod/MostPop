package ru.steklopod

import org.scalatest.{FunSuite, Matchers}
import ru.steklopod.util.Parser._

class InitFunSuite extends FunSuite with Matchers {

  private[this] val sessionValue = "$2a$10$SjInPRoSm"

  test(" Test println() ") {
    println(sessionValue)
    sessionValue.isEmpty should be(false)
  }

  test("Parser") {
//    val keyWordObj = new KeyWord("смерть", 0, new URL("https://lenta.ru"))

    parseURL("https://lenta.ru")


  }

}
