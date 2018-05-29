package com.sid.jpahiber.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CartItems {
	
	@Id
	@GeneratedValue
	private int cartItemId;
	private int quantiry;
	private String totalPrice;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cart cart;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantiry() {
		return quantiry;
	}

	public void setQuantiry(int quantiry) {
		this.quantiry = quantiry;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	

}
