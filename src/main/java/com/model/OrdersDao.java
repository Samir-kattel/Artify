package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersDao {
	/* connection */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "");
		return connection;
	}

	public ArrayList<Orders> fetchOrders(String userEmail) {
		System.out.println("This is");
		System.out.println(userEmail);
		ArrayList<Orders> orderList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "SELECT p.*, o.id as order_id FROM product p JOIN orders o ON p._id = o.product_id WHERE o.user_email = ?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, userEmail);
			ResultSet table = st.executeQuery();
			System.out.println(table);
			while (table.next()) {
				int id = table.getInt(1);
				String name = table.getString(2);
				int price = table.getInt(3);
				String imagePath = table.getString(4);
				int orderId = table.getInt(5);
				System.out.println("This is order data:");
				System.out.println(id);
				System.out.println(name);
                System.out.println(orderId);
   
				Orders orders = new Orders(id, name, price, imagePath, orderId);
				orderList.add(orders);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}
	

}

