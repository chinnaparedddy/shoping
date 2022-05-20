package com.ty.shoping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.ty.shoping.util.AppConstants.SECRETE_KEY;
import com.ty.shoping.controls.AES;
import com.ty.shoping.dto.User;
import com.ty.shoping.util.ConnectionObject;
public class UserDao {
 public int saveUser(User user)
 {
	 String query="insert into user values(?,?,?,?,?)";
	 Connection connection=ConnectionObject.getConnectio();
	 String enc=AES.encrypt(user.getPassword(), SECRETE_KEY);
	 try {
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, enc);
		preparedStatement.setLong(5,user.getMobile());
		return preparedStatement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 finally {
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	 return 0;
 }
 public User validate(String email,String password)
 {
	 String query="select * from user where email=? and password=?";
	 String en=AES.encrypt(password, SECRETE_KEY);
	 Connection connection=ConnectionObject.getConnectio();
	 try {
		
		 PreparedStatement preparedStatement=connection.prepareStatement(query);
		 preparedStatement.setString(1, email);
		 preparedStatement.setString(2,en);
		 ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			User user=new User();
			user.setName(resultSet.getString(2));
			user.setMobile(resultSet.getLong(5));
			return user;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
	 
 }
}
