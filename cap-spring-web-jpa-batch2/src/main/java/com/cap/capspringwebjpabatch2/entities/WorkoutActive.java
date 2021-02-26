package com.cap.capspringwebjpabatch2.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class WorkoutActive {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String title;

	int caloriesBurntPerMinute;
	
	LocalDateTime startTime;
	LocalDateTime endTime;
	
	@ManyToOne(targetEntity = Usert.class,cascade = CascadeType.PERSIST)
	Usert user;
	
	

	public WorkoutActive() {
		
	}
	public WorkoutActive(String title, int caloriesBurntPerMinute, Usert user, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.title = title;
		this.caloriesBurntPerMinute = caloriesBurntPerMinute;
		this.startTime = startTime;
		this.endTime = endTime;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCaloriesBurntPerMinute() {
		return caloriesBurntPerMinute;
	}
	public void setCaloriesBurntPerMinute(int caloriesBurntPerMinute) {
		this.caloriesBurntPerMinute = caloriesBurntPerMinute;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Usert getUser() {
		return user;
	}
	public void setUser(Usert user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "WorkoutActive [id=" + id + ", title=" + title + ", caloriesBurntPerMinute=" + caloriesBurntPerMinute
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", user=" + user + "]";
	}
	
		

}