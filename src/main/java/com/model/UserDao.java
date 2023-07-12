package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

	/* connection */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "");
		return connection;
	}

	public String registerUser(User user) {
		String message = "";
		try {
			Connection con = getConnection();
			String query = "INSERT INTO User (_id, username, email, password, profile_picture) VALUES (NULL, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getImage_path());
			int rows = pst.executeUpdate();
			if (rows >= 1) {
				message = "Registration Successfull, Now you can log in:";
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				if (e.getMessage().contains("unique_username")) {
					message = "Username already exists";
				} else if (e.getMessage().contains("unique_email")) {
					message = "Email already exists";
				}
			} else {
				message = "An error occurred while registering user";
				System.out.println(e.getMessage());
			}
		}
		return message;
	}
	
	public boolean checkLogin(String email, String password) {
		boolean isValid = false;
		try {
			Connection con = getConnection();
			String query = "select * from User where email=? and password=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet table = st.executeQuery();
			if(table.next()) {
				isValid = true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}
	
	/* get User by Id */
	public User getUserById(String email) {
		Connection con = null;
		User user = null;
		try {
			con = getConnection();
			String query = "select * from user where email=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			ResultSet table = st.executeQuery();
			if (table.next()) {
				String email2 = table.getString(3);
				String username = table.getString(2);
				String password = table.getString(4);
				String img = table.getString(5);
				System.out.println(email2);
				System.out.println(username);
				System.out.println(password);
				System.out.println(img);
				user = new User(username, email2, password, img);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return user;

	}
	
	/* update user */
	public String updateUser(User user) {
		System.out.println("update user called function");
		System.out.println(user);
		String message = "";
		try {

			Connection con = getConnection();
			String query = "UPDATE user SET username=?, email=?, profile_picture=? where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getImage_path());
			pst.setString(4, user.getEmail());

			int rows = pst.executeUpdate();
			if (rows >= 1) {
				message = "Successfully updated";
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;
	}
	
	/* fetch all product */
	public ArrayList<User> fetchAllUser() {
		ArrayList<User> UserList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "select * from user";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				String username = table.getString(2);
				String email = table.getString(3);
				String password = table.getString(4);
				String imagePath = table.getString(5);

				User user = new User(username, email, password, imagePath);
				UserList.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return UserList;

	}
	


}
