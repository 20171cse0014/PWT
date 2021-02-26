package com.cap.capspringwebjpabatch2.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.capspringwebjpabatch2.entities.Category;
import com.cap.capspringwebjpabatch2.entities.Usert;
import com.cap.capspringwebjpabatch2.repos.CategoryRepository;



@RestController
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public ResponseEntity<Void> addCategory(@RequestBody Category c)
	{
		ResponseEntity<Void> re=null;
		Category category=categoryRepository.findByName(c.getName());
		if(category==null) {
			categoryRepository.save(c);
			re=new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
			re = new ResponseEntity<>(HttpStatus.CONFLICT);
			throw new CategoryAlreadyExistsException("Category found with name : " +  c.getName());
		}
		return re;
	}
	
	@RequestMapping(value="/category",method=RequestMethod.GET)
	public ResponseEntity<List<Category>> findAllCategory(){
		ResponseEntity<List<Category>> re=null;
		List<Category>category=categoryRepository.findAll();
		if(category.isEmpty()) {
			return re=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return re=new ResponseEntity<>(category,HttpStatus.OK);
	}
	@GetMapping("/category/{category}")
	public ResponseEntity<Category> findCategoryByName(@PathVariable("category") String name) {
		ResponseEntity<Category> re=null;
		Category c=categoryRepository.findByName(name);
		if(c==null) {
			return re=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re=new ResponseEntity<>(c,HttpStatus.FOUND);
	}
	@DeleteMapping("/category/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		Optional<Category> category = categoryRepository.findById(id);
		Category c = null;
		c=category.get();
		if(c!=null) {	
			categoryRepository.delete(c);
		}
}
}