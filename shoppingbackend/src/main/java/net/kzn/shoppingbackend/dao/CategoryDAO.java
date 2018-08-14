package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	Category getCategoryById(int id);
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

}
