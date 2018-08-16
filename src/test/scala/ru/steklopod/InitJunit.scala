package ru.steklopod

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InitJunit extends FunSuite {

  private case class Donut(name: String, price: Double)

  private val donuts: Seq[String] = Seq("Plain Donut", "StrawberryDonut", "Glazed Donut")
  private val donuts_2: Seq[Donut] = Seq(Donut("Plain Donut", 15.00), Donut("StrawberryDonut", 25.00), Donut("Glazed Donut", 30.00))

  test("assert size") {
    assert(3 == donuts.size)
  }

  // groupBy[K](f: (A) ⇒ K): immutable.Map[K, Repr] ////////
  test("groupBy() charAt #1") {
    println(s"All donuts: $donuts")

    val donutsGroup = donuts.groupBy(_.charAt(0))
    println(s"Grouped by 1st char: \n $donutsGroup")
  }

  test("groupBy() case class #2") {
    val donutsGroup_2 = donuts_2.groupBy(_.name)
    println(s"Objects Grouped by name char: \n $donutsGroup_2")
  }
  //////////////////////////////////////////////////////////

}
