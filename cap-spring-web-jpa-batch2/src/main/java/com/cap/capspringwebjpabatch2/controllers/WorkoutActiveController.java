package com.cap.capspringwebjpabatch2.controllers;

import java.time.LocalDateTime;
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

import com.cap.capspringwebjpabatch2.entities.Usert;
import com.cap.capspringwebjpabatch2.entities.WorkoutActive;
import com.cap.capspringwebjpabatch2.repos.WorkoutActiveRepository;

@RestController
public class WorkoutActiveController {
	
	@Autowired
	WorkoutActiveRepository workoutActiveRepository;
	
	@RequestMapping(value="/workoutactive",method=RequestMethod.POST)
	public ResponseEntity<Void> addWorkoutActive(@RequestBody WorkoutActive w)
	{
		
		ResponseEntity<Void> re=null;
		
		workoutActiveRepository.save(w);
			re=new ResponseEntity<>(HttpStatus.CREATED);
		
		return re;
	}
	
	@GetMapping("/workoutactive")
	public ResponseEntity<List<WorkoutActive>> findAllWorkoutActive(){
		ResponseEntity<List<WorkoutActive>> re=null;
		List<WorkoutActive>workout=workoutActiveRepository.findAll();
		System.out.println(workout);
		if(workout.isEmpty()) {
			return re=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return re=new ResponseEntity<>(workout,HttpStatus.OK);
	}
	
	@GetMapping("/workoutactive/{title}")
	public ResponseEntity<WorkoutActive> findWorkoutActiveByTitle(@PathVariable("title") String title) {
		ResponseEntity<WorkoutActive> re=null;
		WorkoutActive w=workoutActiveRepository.findByTitle(title);
		if(w==null) {
			return re=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re=new ResponseEntity<>(w,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/workoutactive/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		Optional<WorkoutActive> workout = workoutActiveRepository.findById(id);
		WorkoutActive w = null;
		w=workout.get();
		if(w!=null) {	
			workoutActiveRepository.delete(w);
		}
}
	@RequestMapping(value="/workoutactivestart",method=RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> startTimeWorkout(@RequestBody WorkoutActive w) {
		ResponseEntity<Void>  re;
		
		WorkoutActive wa = workoutActiveRepository.findByTitle(w.getTitle());
		wa.setStartTime(LocalDateTime.now());
		re = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return re;
	}
	@RequestMapping(value="/workoutactiveend",method=RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> endTimeWorkout(@RequestBody WorkoutActive w) {
		ResponseEntity<Void>  re;
		
		WorkoutActive wa = workoutActiveRepository.findByTitle(w.getTitle());
		wa.setEndTime(LocalDateTime.now());
		re = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return re;
	}
}
