/**
 * 
 */
package com.abhishek.amar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.amar.entity.DBEntity;

/**
 * @author Abhishek Amar
 *
 */
@Repository
public interface DbRepository extends JpaRepository<DBEntity,Integer>{
	
}
