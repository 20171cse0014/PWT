package com.cap.capspringwebjpabatch2.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capspringwebjpabatch2.entities.Usert;


@Repository
public interface UserRepository extends JpaRepository<Usert, Integer> {

	public Usert findByEmail(String email);
}
