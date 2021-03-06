package ru.steklopod.repo

import javax.sql.DataSource
import ru.steklopod.repo.KeyWordDb.SHEMA_NAME

object ConnectionAccesNamesStore {
  val URL_POSTGRES: String = "jdbc:postgresql://localhost:5432/home?currentSchema=" + SHEMA_NAME
  val DRIVER_POSTGRES = "org.postgresql.Driver"
  val LOGIN_POSTGRES = "postgres"
  val PSWRD_POSTGRES = "postgres"

  val URL_MARIA: String = "jdbc:mariadb://127.0.0.1:3306/" + SHEMA_NAME
  val DRIVER_MARIA_DB = "org.mariadb.jdbc.Driver"
  var LOGIN_MARIA = "root"
  val PSWRD_MARIA = "root"

  val ADDITIONAL_ARGUMENTS = ";MODE=MYSQL;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;"
  val URL_H2_IN_MEMORY: String = "jdbc:h2:mem:" + SHEMA_NAME + ADDITIONAL_ARGUMENTS
  val DRIVER_H2_IN_MEMORY = "org.h2.Driver"
  val LOGIN_H2_IN_MEMORY = ""
  val PSWRD_H2_IN_MEMORY = ""

  object DataSource {
    import com.zaxxer.hikari._
//  TODO - choose profile `postgres/maria`

    private[this] lazy val dataSource: DataSource = {
      val ds = new HikariDataSource()
      ds.setDriverClassName(DRIVER_MARIA_DB)
      ds.setJdbcUrl(URL_MARIA)
      ds.setPassword(PSWRD_MARIA)
      ds.setUsername(LOGIN_MARIA)
      ds
    }
    def apply(): DataSource = dataSource
  }

}