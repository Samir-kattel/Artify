package com.model;


public class Orders {
	private int id;
	private String name;
	private int price;
	private String img_path;
	private int orderId;

	public Orders(int id, String name, int price, String img_path, int orderId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img_path = img_path;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}

	public void setCartId(int orderId) {
		this.orderId = orderId;
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
