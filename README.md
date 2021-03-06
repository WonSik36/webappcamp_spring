# 01.15

* Hello<br>
	![Hello Spring](https://github.com/WonSik36/webappcamp_spring/blob/master/images_readme/hello.PNG)
	
# 01.16

* 스프링 동작 원리 실습, Hello Spring 예제 실습
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/dto/UserDto.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/dao/UserDao.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/dao/UserDaoJdbc.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/service/UserService.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/service/UserServiceImpl.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/controller/UserController.java
	
* Controller parameter, return type 예제 실습
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/controller/UserController.java
	
* 실습 결과<br>
	![list](https://github.com/WonSik36/webappcamp_spring/blob/master/images_readme/list.png)
	![signup](https://github.com/WonSik36/webappcamp_spring/blob/master/images_readme/signup.PNG)
	![signup_success](https://github.com/WonSik36/webappcamp_spring/blob/master/images_readme/signup_success.PNG)
	
# 01.17

* 프로젝트 1<br>
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/dao/UserDaoJdbc.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/service/UserServiceImpl.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/controller/UserController.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/util/UpdateResult.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/util/CharacterEncodingFilter.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/webapp/WEB-INF/web.xml
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/webapp/WEB-INF/views/userList.jsp
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/webapp/WEB-INF/views/userForm.jsp
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/webapp/WEB-INF/views/userEdit.jsp
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/webapp/WEB-INF/views/result.jsp
	
* 프로젝트 2<br>
	https://github.com/WonSik36/webappcamp_spring/blob/master/pom.xml
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/webapp/WEB-INF/spring/root-context.xml
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/test/java/com/handong/webcamp/mybatis/MySQLConnectionTest.java
	https://github.com/WonSik36/webappcamp_spring/blob/master/src/test/java/com/handong/webcamp/mybatis/MyBatisTest.java
	
* 프로젝트 3<br>
	* 매퍼를 인터페이스를 이용하여 호출
		https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/webapp/WEB-INF/spring/root-context.xml
		https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/mapper/UserMapper.java
		https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/resources/mapper/sql-user.xml
	* 테스트
		https://github.com/WonSik36/webappcamp_spring/blob/master/src/test/java/com/handong/webcamp/mybatis/UserMapperTest.java
		https://github.com/WonSik36/webappcamp_spring/blob/master/src/test/java/com/handong/webcamp/mybatis/application-context.xml
		https://github.com/WonSik36/webappcamp_spring/blob/master/src/test/resources/database.properties
	* 컨트롤러, 서비스
		https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/controller/UserMapperController.java
		https://github.com/WonSik36/webappcamp_spring/blob/master/src/main/java/com/handong/webcamp/service/UserServiceImplMapper.java