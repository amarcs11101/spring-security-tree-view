package com.abhishek.amar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 

import com.abhishek.amar.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUsername(String username);

	User findOneByUsername(String username);
}