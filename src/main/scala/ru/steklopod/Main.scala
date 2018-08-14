package ru.steklopod

import ru.steklopod.entities.KeyWord
import ru.steklopod.repo.DBKeywordRepository


  object Main {
    def main(args: Array[String]) {

      val testKeyWord = new KeyWord("смерть", 0, "https://lenta.ru")
      println(testKeyWord)

      DBKeywordRepository.createKeyWord(testKeyWord)

    }



}