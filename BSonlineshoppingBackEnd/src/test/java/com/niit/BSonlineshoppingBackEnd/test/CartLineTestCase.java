package com.niit.BSonlineshoppingBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BSonlineshoppingBackEnd.dao.CartLineDAO;
import com.niit.BSonlineshoppingBackEnd.dao.ProductDAO;
import com.niit.BSonlineshoppingBackEnd.dao.UserDAO;
import com.niit.BSonlineshoppingBackEnd.dto.Cart;
import com.niit.BSonlineshoppingBackEnd.dto.CartLine;
import com.niit.BSonlineshoppingBackEnd.dto.Product;
import com.niit.BSonlineshoppingBackEnd.dto.User;

public class CartLineTestCase {

private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.BSonlineshoppingBackEnd");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
				
	
	}
	
	@Test
	public void testAddNewCartLine() {
		
		// 1. get the user
		user = userDAO.getByEmail("sajith@gmail.com");
		
		// 2. fetch the cart
		cart = user.getCart();
		
		// 3. get the product
		product = productDAO.get(5);
		
		// 4. create a new cartline
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());

		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine", true, cartLineDAO.add(cartLine));
		
		// update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));
	}

	
}
