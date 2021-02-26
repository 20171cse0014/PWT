package com.cap.capspringwebjpabatch2.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capspringwebjpabatch2.entities.WorkoutActive;

@Repository
public interface WorkoutActiveRepository extends JpaRepository<WorkoutActive, Integer>{
	public WorkoutActive findByTitle(String title);
}
