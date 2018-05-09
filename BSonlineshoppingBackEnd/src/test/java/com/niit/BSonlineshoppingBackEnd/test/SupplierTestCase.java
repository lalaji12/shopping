package com.niit.BSonlineshoppingBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BSonlineshoppingBackEnd.dao.SupplierDAO;
import com.niit.BSonlineshoppingBackEnd.dto.Supplier;

public class SupplierTestCase {
private static AnnotationConfigApplicationContext context;
	
	private static SupplierDAO supplierDAO;
	private Supplier supplier;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.BSonlineshoppingBackEnd");
		context.refresh();
		supplierDAO =  (SupplierDAO)context.getBean("supplierDAO");
	}
	
	  
	@Test
	public void testCRUDSupplier() {
		//add operation
		supplier = new Supplier();
		
		supplier.setSupplierName("krishna");
		supplier.setStoreName("TigeRetail");
		supplier.setEmail("TigeRetail@gmail.com");
		supplier.setContactnumber("7896541234");
		supplier.setPassword("tiger");
		
		assertEquals("Successfully added the supplier inside the table!",true,supplierDAO.add(supplier));  
	
		supplier = new Supplier();
		
		supplier.setSupplierName("Radha");
		supplier.setStoreName("IndiaRetail");
		supplier.setEmail("IndiaRetail@gmail.com");
		supplier.setContactnumber("7999541234");
		supplier.setPassword("india");
		
		assertEquals("Successfully added the supplier inside the table!",true,supplierDAO.add(supplier));  
		}
}
