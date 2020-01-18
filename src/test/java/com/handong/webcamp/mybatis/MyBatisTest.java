package com.handong.webcamp.mybatis;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:database.properties")
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MyBatisTest {
	@Autowired
	private SqlSessionFactory sqlFactory;

	@Test
	public void testFactory(){
		System.out.println("\n >>>>>>>>>> sqlFactory 출력 : "+sqlFactory);
	}

	@Test
	public void testSession() {
		assertThat(sqlFactory.getClass().getSimpleName(), is("DefaultSqlSessionFactory"));
		try{
			SqlSession session = sqlFactory.openSession();
			System.out.println(" >>>>>>>>>> session 출력 : "+session+"\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
