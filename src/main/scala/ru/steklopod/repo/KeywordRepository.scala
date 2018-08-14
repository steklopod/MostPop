package ru.steklopod.repo

import ru.steklopod.entities.KeyWord
import scalikejdbc.DB

trait KeywordRepository {
  def createKeyWord(keyWord: KeyWord): Long

  //  def getKeyWord(id: Long): Future[Option[KeyWord]]
  //
  //  def findAll(): List[KeyWord]
  //
  //  def findAll(max: Int): List[KeyWord]
  //
  //  def findAll(max: Int, skip: Int): List[KeyWord]

}

object DBKeywordRepository extends KeywordRepository {
  KeyWordDb.init()
  KeyWordDb.createSchema()
  KeyWordDb.createKeyWordTablesAndEmptyKeyWord()


  override def createKeyWord(keyWord: KeyWord): Long =
    DB.autoCommit(implicit session => KeyWord.create(keyWord))


  //  override def createKeyWord(keyWord: KeyWord): Future[Unit] =
  //    DB.futureLocalTx(implicit session => KeyWord.create(keyWord).map(_ => ()))
  //  
  //  override def getKeyWord(id: Long): Future[Option[KeyWord]] =
  //    DB.futureLocalTx(implicit session => KeyWord.findById(id))
  //
  //  override def findAll(): List[KeyWord] = KeyWord.findAll
  //
  //  override def findAll(max: Int): List[KeyWord] = KeyWord.findAll(max: Int)
  //
  //  override def findAll(max: Int, skip: Int): List[KeyWord] = KeyWord.findAll(max: Int, skip: Int)

}
