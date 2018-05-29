package com.sid.jpahiber.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sid.jpahiber.vo.Cart;
import com.sid.jpahiber.vo.CartItems;
import com.sid.jpahiber.vo.Product;
import com.sid.jpahiber.vo.User;

@Repository
@Transactional
public class ProductDao {
	
	@Autowired
	private EntityManager em;
	
	public void addOrder(int productId,int quantity,int userid) {
		Product prod = em.find(Product.class, productId);
		User user = em.find(User.class,userid);
		
		CartItems cartItems = new CartItems();
	
		cartItems.setQuantiry(quantity);
		double sum = quantity * prod.getProductPrice();
		cartItems.setTotalPrice(String.valueOf(sum));
		cartItems.setProduct(prod);
		
		Cart cart = new Cart();
		cart.setUser(user);
		if(user.getCart()==null) {
			cart.setGrandTotal(sum);
		}else {
			cart.setGrandTotal(sum + user.getCart().getGrandTotal());
		}
		cartItems.setCart(cart);
		em.persist(cart);
		em.flush();
		em.persist(cartItems);
		
	}

}
