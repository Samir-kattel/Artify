package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	/* connection */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "");
		return connection;
	}

	public String addProduct(Product product) {
		String message = "";
		try {
			Connection con = getConnection();
			String query = "INSERT INTO product (_id, name, price , img_path) VALUES (NULL, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, product.getName());
			pst.setInt(2, product.getPrice());
			pst.setString(3, product.getImg_path());
			int rows = pst.executeUpdate();
			if (rows >= 1) {
				message = "Product Added Successfully";
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {

		}
		return message;
	}

	/* fetch all product */
	public ArrayList<Product> fetchAllProduct() {
		ArrayList<Product> productList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "select * from product";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while (table.next()) {
				int id = table.getInt(1);
				String name = table.getString(2);
				int price = table.getInt(3);
				String imagePath = table.getString(4);

				Product product = new Product(id, name, price, imagePath);
				productList.add(product);
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
		return productList;

	}
	
	/* fetch all product low to high */
	public ArrayList<Product> fetchProductLowHigh() {
	    ArrayList<Product> productList = new ArrayList<>();
	    Connection con = null;
	    try {
	        con = getConnection();
	        String query = "SELECT * FROM product ORDER BY price ASC";
	        PreparedStatement st = con.prepareStatement(query);
	        ResultSet table = st.executeQuery();
	        while (table.next()) {
	            int id = table.getInt(1);
	            String name = table.getString(2);
	            int price = table.getInt(3);
	            String imagePath = table.getString(4);

	            Product product = new Product(id, name, price, imagePath);
	            productList.add(product);
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
	    return productList;
	}
	
	


	/* get product by Id */
	public Product getProductById(int id) {
		Connection con = null;
		Product product = null;
		try {
			con = getConnection();
			String query = "select * from product where _id=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			ResultSet table = st.executeQuery();
			if (table.next()) {
				int id2 = table.getInt(1);
				String name = table.getString(2);
				int price = table.getInt(3);
				String img = table.getString(4);
				System.out.println(id2);
				System.out.println(name);
				System.out.println(price);
				System.out.println(img);
				product = new Product(id2, name, price, img);
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
		return product;

	}

	/* update product */
	public String updateProduct(Product product) {
		String message = "";
		try {

			Connection con = getConnection();
			String query = "UPDATE product SET name=?, price=?,img_path=? where _id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, product.getName());
			pst.setInt(2, product.getPrice());
			pst.setString(3, product.getImg_path());
			pst.setInt(4, product.getId());

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

	/* delete product */
	public String deleteProduct(int id) {
		String message = "";
		try {
			Connection con = getConnection();
			String query = "DELETE FROM product WHERE _id=?";
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
