package com.model;

public class Cart {
	private int id;
	private String name;
	private int price;
	private String img_path;
	private int cartId;

	public Cart(int id, String name, int price, String img_path, int cartId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img_path = img_path;
		this.cartId = cartId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getcartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

}
