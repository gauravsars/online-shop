package net.kzn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	private static List<Category> categories = new ArrayList<Category>();
	
	@Autowired
	private SessionFactory sessionFactory;
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
	
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category getCategoryById(int id) {
		for(Category c : categories){	
			if(c.getId()==id){
				return c;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try{
			//add the category to the database.
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	
	}
}
