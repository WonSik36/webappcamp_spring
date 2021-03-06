package com.handong.webcamp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.util.UpdateResult;

@Repository
public class UserDaoJdbc implements UserDao {
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<UserDto> userMapper = new RowMapper<UserDto>() {
    	public UserDto mapRow(ResultSet rs, int rowNum)throws SQLException{
			UserDto user = new UserDto();
			user.setUserID(rs.getString("userID"));
			user.setUserPassword(rs.getString("userPassword"));
			user.setUserName(rs.getString("userName"));
			user.setUserGender(rs.getString("userGender"));
			user.setUserEmail(rs.getString("userEmail"));
			return user;
		}
    };
	
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
    @Override
    public UpdateResult add(UserDto user) {
    	return updateQuery("INSERT INTO user VALUES(?,?,?,?,?)"
				,user.getUserID(),user.getUserPassword(),user.getUserName()
				, user.getUserGender(), user.getUserEmail());
    }

	@Override
	public UserDto get(String id) {
		return jdbcTemplate.queryForObject("SELECT * FROM user WHERE userID = ?", new Object[] {id}, userMapper);
	}

	@Override
	public List<UserDto> getAll() {
		return jdbcTemplate.query("SELECT * FROM user ORDER BY userID",userMapper);
	}

	@Override
	public UpdateResult delete(String id) {
		return updateQuery("DELETE FROM user WHERE userID = ?",id);
	}

	@Override
	public UpdateResult deleteAll() {
		return updateQuery("DELETE FROM user");
	}

	@Override
	public int getCount() {
		return jdbcTemplate.queryForInt("SELECT COUNT(*) FROM user");
	}

	@Override
	public UpdateResult update(UserDto user) {
		return updateQuery("UPDATE user SET userPassword=?, userName=?, userGender=?, userEmail=? WHERE userID=?"
				,user.getUserPassword(), user.getUserName(), user.getUserGender(), user.getUserEmail(), user.getUserID());
	}

	private UpdateResult updateQuery(String sql, Object...obj) {
		try {
			jdbcTemplate.update(sql,obj);
		}catch(DuplicateKeyException e) {
			return UpdateResult.ERR_DUP_KEY;
		}catch(RuntimeException e) {
			e.printStackTrace();
			return UpdateResult.ERR_UNKNOWN;
		}
		
		return UpdateResult.OK;
	}
}
