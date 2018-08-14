package ru.steklopod

import java.net.URL

import ru.steklopod.entities.KeyWord
import ru.steklopod.repo.DBKeywordRepository._


object Main {
  def main(args: Array[String]) {
    initSchemaAndTables()

    val testKeyWord = new KeyWord("смерть", 0, new URL("https://lenta.ru"))
    createKeyWord(testKeyWord)


  }


}