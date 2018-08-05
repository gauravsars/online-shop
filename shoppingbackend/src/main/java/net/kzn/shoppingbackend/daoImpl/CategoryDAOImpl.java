package net.kzn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		//adding first category 
		category.setId(1);
		category.setDescription("This is some description for Television");
		category.setActive(false);
		category.setImageURL("CAT1_1.png");
		category.setName("Television");
		
		categories.add(category);
		
		category = new Category();
		//adding first category 
		category.setId(2);
		category.setDescription("This is some description for Mobile");
		category.setActive(true);
		category.setImageURL("CAT1_2.png");
		category.setName("Mobile");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setDescription("This is some description for Laptop");
		category.setActive(false);
		category.setImageURL("CAT1_3.png");
		category.setName("Laptop");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
	
		return categories;
	}
	
}
