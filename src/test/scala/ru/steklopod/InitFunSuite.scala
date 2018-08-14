package ru.steklopod

import org.scalatest.{FunSuite, Matchers}

class InitFunSuite extends FunSuite with Matchers {

  private [this] val sessionValue = "$2a$10$SjInPRoSm"

  test(" Test println() ") {
    println(sessionValue)

    sessionValue.isEmpty should be(false)
  }

}
