package com.niit.BSonlineshoppingBackEnd.test;

import static org.junit.Assert.assertEquals;



import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BSonlineshoppingBackEnd.dao.UserDAO;
import com.niit.BSonlineshoppingBackEnd.dto.Address;
import com.niit.BSonlineshoppingBackEnd.dto.Cart;
import com.niit.BSonlineshoppingBackEnd.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;  
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.BSonlineshoppingBackEnd");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	/*@Test
	public void testAdd() {

		user = new User();
		user.setFirstName("Balaji");
		user.setLastName("Suji");
		user.setEmail("bala@gmail.com");
		user.setContactnumber("9876534765");
		user.setRole("USER");
		user.setPassword("123456");

		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLineOne("3C redhills road,vianyagapuram");
		address.setAddressLineTwo("Near White Palace");
		address.setCity("Chennai");
		address.setState("TamilNadu");
		address.setCountry("India");
		address.setPostalCode("600019");
		address.setBilling(true);

		// link the user with the address using user id

		address.setUserId(user.getId());

		// add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));

		if (user.getRole().equals("USER")) {

			// create a cart for this user
			cart = new Cart();

			cart.setUser(user);

			// add the address
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));

			// add a shipping address for this user

			address = new Address();
			address.setAddressLineOne("3C redhills road,vianyagapuram");
			address.setAddressLineTwo("Near White Palace");
			address.setCity("Chennai");
			address.setState("TamilNadu");
			address.setCountry("India");
			address.setPostalCode("600019");

			// set shipping to true here

			address.setShipping(true);

			// link it with user  

			address.setUserId(user.getId());

			// add the shipping address
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));

		}

	}*/
	
/*	@Test
	public void testAdd() {

		user = new User();
		user.setFirstName("Balaji");
		user.setLastName("Suji");
		user.setEmail("bala@gmail.com");
		user.setContactnumber("9876534765");
		user.setRole("USER");
		user.setPassword("123456");

		
	
		if (user.getRole().equals("USER")) {

			// create a cart for this user
			cart = new Cart();

			cart.setUser(user);
			
			//attach cart with the user
			user.setCart(cart);

			}
		        // add the user
				assertEquals("Failed to add user!", true, userDAO.addUser(user));

	}*/

/*@Test
public void testUpdateCart() {
	
	//fetch the user by its email
	user=userDAO.getByEmail("bala@gmail.com");
	
	//get the cart of the user
	cart=user.getCart();
	
	cart.setGrandTotal(5555);
	cart.setCartLines(2);
	
	assertEquals("Failed to update the cart!",true,userDAO.updateCart(cart));
}
*/

	/*@Test
	public void testAddAddress() {
		
		//we need to add an user
		
		user = new User();
		user.setFirstName("Balaji");
		user.setLastName("Suji");
		user.setEmail("bala@gmail.com");
		user.setContactnumber("9876534765");
		user.setRole("USER");
		user.setPassword("123456");

		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		
		
		//we are going to add the address

		address = new Address();
		address.setAddressLineOne("3C redhills road,vianyagapuram");
		address.setAddressLineTwo("Near White Palace");
		address.setCity("Chennai");
		address.setState("TamilNadu");
		address.setCountry("India");
		address.setPostalCode("600019");
		address.setBilling(true);
		
		//attached the user to the address
		address.setUser(user);
		
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		//we are also going to add the shipping address
	
		address = new Address();
		address.setAddressLineOne("35B agaram,kolathur");
		address.setAddressLineTwo("Near unisex showroom");
		address.setCity("Chennai");
		address.setState("TamilNadu");
		address.setCountry("India");
		address.setPostalCode("600098");

		// set shipping to true here

		address.setShipping(true);
	
		//attached the user to the address
			
		address.setUser(user);
				
		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
	
	}*/
	
	
	/*@Test
	public void testAddAddress() {
		
		//fetch the user by its email
		user=userDAO.getByEmail("bala@gmail.com");

		//we are also going to add the shipping address
		
			address = new Address();
			address.setAddressLineOne("34A main road,alapuzha");
			address.setAddressLineTwo("Near Ricchi theatre ");
			address.setCity("kochin");
			address.setState("kerala");
			address.setCountry("India");
			address.setPostalCode("600498");

			// set shipping to true here

			address.setShipping(true);
		
			//attached the user to the address
				
			address.setUser(user);
					
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));

	}*/
	
	@Test
	public void testGetAddresses() {
		
		user=userDAO.getByEmail("bala@gmail.com");
		
		assertEquals("Failed to fetch the list of address and size does not match!",2,
				userDAO.listShippingAddresses(user).size());
	

		assertEquals("Failed to fetch the billing address and size does not match!","Chennai",
				userDAO.getBillingAddress(user).getCity());
	

	
	}
		
}
