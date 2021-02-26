package com.cap.capspringwebjpabatch2.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capspringwebjpabatch2.entities.Workout;



@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer>{
public Workout findByTitle(String title);
}
