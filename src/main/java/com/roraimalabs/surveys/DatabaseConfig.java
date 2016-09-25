/**
 * DatabaseConfig.java Created: Sep 24, 2016 JavierAngelH
 */

package com.roraimalabs.surveys;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * DatabaseConfig -
 *
 */
// @Configuration
// public class DatabaseConfig {
//
//
// @Bean
// public DataSource postgresDataSource() {
// // String databaseUrl = System.getenv("DATABASE_URL");
// String databaseUrl = "postgres:1234@localhost:5432/postgres";
// System.out.println("Initializing PostgreSQL database: {}" + databaseUrl);
//
// URI dbUri;
// try {
// dbUri = new URI(databaseUrl);
// }
// catch (URISyntaxException e) {
// System.out.println(String.format("Invalid DATABASE_URL: %s" + databaseUrl) +
// e);
// return null;
// }
//
// String username = dbUri.getUserInfo().split(":")[0];
// String password = dbUri.getUserInfo().split(":")[1];
// String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':'
// + dbUri.getPort() + dbUri.getPath();
//
// org.apache.tomcat.jdbc.pool.DataSource dataSource
// = new org.apache.tomcat.jdbc.pool.DataSource();
// dataSource.setDriverClassName("org.postgresql.Driver");
// dataSource.setUrl(dbUrl);
// dataSource.setUsername(username);
// dataSource.setPassword(password);
// dataSource.setTestOnBorrow(true);
// dataSource.setTestWhileIdle(true);
// dataSource.setTestOnReturn(true);
// dataSource.setValidationQuery("SELECT 1");
// return dataSource;
// }

@Configuration
public class DatabaseConfig {
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}