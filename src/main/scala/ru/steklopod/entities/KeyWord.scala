package ru.steklopod.entities

import java.time.ZonedDateTime
import scalikejdbc._

case class KeyWord(id: Option[Long],
                   word: String,
                   count: Int,
                   website: String,
                   day: Option[ZonedDateTime]) {
  def this(word: String, count: Int, website: String) {
    this(Option.empty[Long], word, count, website, Option.empty[ZonedDateTime])
  }
}


object KeyWord extends SQLSyntaxSupport[KeyWord] {

  override val tableName = "keywords"
  private val g = syntax

  def apply(r: ResultName[KeyWord])(rs: WrappedResultSet) =
    new KeyWord(
      rs.longOpt(r.id),
      rs.string(r.word),
      rs.int(r.count),
      rs.string(r.website),
      rs.dateTimeOpt(r.day)
    )

  def create(keyWord: KeyWord)(implicit session: DBSession = AutoSession): Long = {
    val sql = withSQL(insert.into(KeyWord).namedValues(
      column.id -> keyWord.id,
      column.word -> keyWord.word,
      column.count -> keyWord.count,
      column.website -> keyWord.website,
      column.day -> keyWord.day
    ))
    val genId: Long = sql.updateAndReturnGeneratedKey().apply()
    genId
  }
  
}

