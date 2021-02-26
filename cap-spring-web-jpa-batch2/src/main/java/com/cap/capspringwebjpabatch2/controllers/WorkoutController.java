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
import com.cap.capspringwebjpabatch2.entities.Workout;
import com.cap.capspringwebjpabatch2.repos.CategoryRepository;
import com.cap.capspringwebjpabatch2.repos.WorkoutRepository;

@RestController
public class WorkoutController {
	@Autowired
	WorkoutRepository workoutRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CategoryController categoryController;
	@RequestMapping(value="/workout",method=RequestMethod.POST)
	public ResponseEntity<Void> addWorkout(@RequestBody Workout w)
	{
		
		ResponseEntity<Void> re=null;
		
		workoutRepository.save(w);
		
		
			re=new ResponseEntity<>(HttpStatus.CREATED);
		
		return re;
	}
	
	@RequestMapping(value="/workout",method=RequestMethod.GET)
	public ResponseEntity<List<Workout>> findAllWorkout(){
		ResponseEntity<List<Workout>> re=null;
		List<Workout>workout=workoutRepository.findAll();
		if(workout.isEmpty()) {
			return re=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return re=new ResponseEntity<>(workout,HttpStatus.OK);
	}
	
	@GetMapping("/workout/{title}")
	public ResponseEntity<Workout> findWorkoutByTitle(@PathVariable("title") String title) {
		ResponseEntity<Workout> re=null;
		Workout w=workoutRepository.findByTitle(title);
		if(w==null) {
			return re=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re=new ResponseEntity<>(w,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/workout/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		Optional<Workout> workout = workoutRepository.findById(id);
		Workout w = null;
		w=workout.get();
		if(w!=null) {	
			workoutRepository.delete(w);
		}
}
	
}
