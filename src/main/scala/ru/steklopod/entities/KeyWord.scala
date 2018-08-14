package ru.steklopod.entities

import java.net.URL
import java.sql.Timestamp


case class KeyWord(id: Option[Long],
                   word: String,
                   count: Int,
                   website: URL,
                   day: Option[Timestamp]) {

  def this(word: String, count: Int, website: URL) {
    this(Option.empty[Long], word, count, website, Option.empty[Timestamp])
  }
}
