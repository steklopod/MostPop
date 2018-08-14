package ru.steklopod.entities

import java.net.URL
import java.time.ZonedDateTime

import scalikejdbc._


case class KeyWord(id: Option[Long],
                   word: String,
                   counts: Int,
                   website: String,
                   day: ZonedDateTime) {
  def this(word: String, counts: Int, website: String) {
    this(Option.empty[Long], word, counts, website, ZonedDateTime.now())
  }
  def this(word: String, counts: Int, website: URL) {
    this(Option.empty[Long], word, counts, website.toString, ZonedDateTime.now())
  }
}


object KeyWord extends SQLSyntaxSupport[KeyWord] {

  override val tableName = "keywords"
  private val g = syntax

  def apply(r: ResultName[KeyWord])(rs: WrappedResultSet) =
    new KeyWord(
      rs.longOpt(r.id),
      rs.string(r.word),
      rs.int(r.counts),
      rs.string(r.website),
      rs.dateTime(r.day)
    )

  def create(keyWord: KeyWord)(implicit session: DBSession = AutoSession): Long = {
    val sql = withSQL(insert.into(KeyWord).namedValues(
      column.id -> keyWord.id,
      column.word -> keyWord.word,
      column.counts -> keyWord.counts,
      column.website -> keyWord.website,
      column.day -> keyWord.day
    ))
    val createdID: Long = sql.updateAndReturnGeneratedKey().apply()
    println(s"Keywords [${keyWord.word}] successfully added with `id` $createdID")
    createdID
  }

}

