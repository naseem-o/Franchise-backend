package com.franchise.qa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by noravingal on 07/03/21.
 */
public class SpringJdbc {
    @Configuration
    @ComponentScan("com.franchise.qa.persistance.entity")
    public class SpringJdbcConfig {
        @Bean
        public DataSource mysqlDataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3307/MyDB");
            dataSource.setUsername("root");
            dataSource.setPassword("");

            return dataSource;
        }
    }
}
