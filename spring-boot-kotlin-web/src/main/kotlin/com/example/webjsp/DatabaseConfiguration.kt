package com.example.webjsp

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import javax.sql.DataSource

@Configuration
class DatabaseConfiguration {

    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Bean
    fun hikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun dataSource(): DataSource {
        return HikariDataSource(hikariConfig())
    }

    @Bean
    @Throws(Exception::class)
    fun getSqlSessionFactory(dataSource: DataSource?): SqlSessionFactory? {
        val sessionFactory = SqlSessionFactoryBean()
        sessionFactory.setDataSource(dataSource)
        val resolver = PathMatchingResourcePatternResolver()
        sessionFactory.setMapperLocations(*resolver.getResources("classpath:mapper/**/*.xml"))
        sessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"))
        return sessionFactory.getObject()
    }

    @Bean
    fun getSqlSessionTemplate(sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }
}
