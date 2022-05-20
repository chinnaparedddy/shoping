package com.ty.shoping.controls;

import com.ty.shoping.dao.UserDao;
import com.ty.shoping.dto.User;

public class TestUser {

	public static void main(String[] args) {
		UserDao userDao1 = new UserDao();
//		User user = new User();
//		user.setId(7);
//		user.setName("Naresh");
//		user.setEmail("nari@gmail.com");
//		user.setPassword("nari123");
//		user.setMobile(8754214);
//		int res = userDao1.saveUser(user);
//		if (res > 0) {
//			System.out.println("data insearted");
//		} else
//			System.out.println("not insearted");
		User user1 = userDao1.validate("nari@gmail.com", "nari123");
		if (user1 != null) {
			System.out.println(user1.getName());
			System.out.println(user1.getMobile());
		} else {
			System.out.println("Data not found");
	}
	}

}
