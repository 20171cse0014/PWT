package com.cap.capspringwebjpabatch2.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertable")
public class Usert {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String email;
	String password;
	
	public Usert() {
		
	}
	public Usert(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	
	
	public Usert(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	

}