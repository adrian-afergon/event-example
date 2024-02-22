package es.leanmind.eventexample

import liquibase.integration.spring.SpringLiquibase
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class LiquibaseConfig {
    @Bean
    fun liquibase(dataSource: DataSource, @Value("\${spring.liquibase.change-log}") changeLog: String): SpringLiquibase {
        val liquibase = SpringLiquibase()
        liquibase.dataSource = dataSource
        liquibase.changeLog = changeLog
        return liquibase
    }
}