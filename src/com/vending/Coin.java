package com.vending;

public enum Coin {

	
	PENNY(1),NICKEL(5),DIME(10),QURTER(25);
	
	private int price;

	private Coin(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
}
