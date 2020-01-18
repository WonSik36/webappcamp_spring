package com.handong.webcamp.mybatis;


import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:database.properties")
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MySQLConnectionTest {
	@Autowired
	@Qualifier("dataSourceMyBatis")
	DataSource dataSource;

	@Test
	public void testConnection() throws Exception {
		assertThat(dataSource.getClass().getSimpleName(), is("DriverManagerDataSource"));
		try {
			Connection con = dataSource.getConnection();
			System.out.println("\n >>>>>>>>>> Connection 출력 : " + con + "\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
