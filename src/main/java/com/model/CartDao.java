package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDao {
	/* connection */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "");
		return connection;
	}

	public ArrayList<Cart> fetchCart(String userEmail) {
		System.out.println("This is");
		System.out.println(userEmail);
		ArrayList<Cart> cartList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "SELECT p.*, c.id as cart_id FROM cart c JOIN product p ON c.product_id = p._id WHERE c.user_email = ?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, userEmail);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				int id = table.getInt(1);
				String name = table.getString(2);
				int price = table.getInt(3);
				String imagePath = table.getString(4);
				int cartId = table.getInt(5);
				System.out.println(id);
				System.out.println(name);
                System.out.println(cartId);
   
				Cart cart = new Cart(id, name, price, imagePath, cartId);
				cartList.add(cart);
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
		return cartList;
	}
	
	/* delete cart */
	public String deleteCart(int id) {
		String message = "";
		try {
			Connection con = getConnection();
			System.out.println("deltecard function");
			System.out.println(id);
			String query = "DELETE FROM cart WHERE id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			int rows = pst.executeUpdate();
			if (rows >= 1) {
				message = "Successfully deleted";
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;
	}


}
