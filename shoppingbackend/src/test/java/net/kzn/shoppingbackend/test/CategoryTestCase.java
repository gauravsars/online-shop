package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;


public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
/*	
	@Test
	public void testAddCategory(){
		category = new Category();
		category.setDescription("This is some description for television");
		category.setName("Television");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added a category inside a table!",true,categoryDAO.add(category));
	}
	
	@Test
	public void testGetCategory(){
		category = categoryDAO.getCategoryById(3);
		assertEquals("Successfully fetched a single category from table only when it matches","Television",category.getName());
	}
	
	@Test
	public void testupdateSingleCategory(){
		category = categoryDAO.getCategoryById(3);
		category.setName("Television");
		assertEquals("Successfully updated a single category from table and now it matches",true,categoryDAO.update(category));
	}
	
	@Test
	public void testDeleteCategory(){
		category = categoryDAO.getCategoryById(3);
		assertEquals("Successfully updated a single category from table and now it matches",true,categoryDAO.delete(category));	
	}
	
	@Test
	public void testListCategory(){
		assertEquals("Successfully updated a single category from table and now it matches",3,categoryDAO.list().size());
	}*/
	
	@Test
	 public void testCRUDCategory() {
		//add operation
		category = new Category();
		category.setName("Laptop");
		category.setDescription("ABCD");
		category.setActive(true);
		category.setImageURL("CAT2_PNG");
		assertEquals("Successfully added a category inside a table!",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setActive(true);
		category.setDescription("ABCD");
		category.setImageURL("CAT2_PNG");
		assertEquals("Successfully added a category inside a table!",true,categoryDAO.add(category));
		
		//update
		category = categoryDAO.getCategoryById(2);
		category.setName("TV");
		assertEquals("Successfully updated a single category from table and now it matches",true,categoryDAO.update(category));
		//delete
		category = categoryDAO.getCategoryById(2);
		assertEquals("Successfully updated a single category from table and now it matches",true,categoryDAO.delete(category));	
		
		//fetching the list
		assertEquals("Successfully updated a single category from table and now it matches",1,categoryDAO.list().size());
	
	}
	
}
