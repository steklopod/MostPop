package ru.steklopod.repo

import ru.steklopod.repo.ConnectionAccesNamesStore.DataSource
import scalikejdbc._

object KeyWordDb {
  val SHEMA_NAME = "keywords"

  def init(): Unit = {
    ConnectionPool.singleton(new DataSourceConnectionPool(DataSource()))
  }

  def createSchema(): Boolean = {
    DB autoCommit { implicit session =>
      sql"""
           CREATE SCHEMA IF NOT EXISTS keywords
        """
        .execute.apply()
    }
  }

  def createKeyWordTablesAndEmptyKeyWord(): Unit = {
    DB autoCommit  { implicit session =>
      sql"""
            DROP TABLE IF EXISTS keywords
        """.execute.apply()
      sql"""
           CREATE TABLE IF NOT EXISTS keywords (
             id      SERIAL NOT NULL PRIMARY KEY,
             word    TEXT NOT NULL,
             counts  INT NOT NULL,
             website TEXT NOT NULL,
             day     DATETIME DEFAULT NOW()
           );
      """
        .execute.apply()
    }
  }

  def truncateKeyWord(): Boolean = {
    DB autoCommit { implicit session =>
      sql"""
           TRUNCATE TABLE keywords
        """
        .execute.apply()
    }
  }

}
