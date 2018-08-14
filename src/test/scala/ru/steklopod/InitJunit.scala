package ru.steklopod

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InitJunit extends FunSuite {

  test("Init") {
    assert(2 == List(1, 2).size)
  }

}
