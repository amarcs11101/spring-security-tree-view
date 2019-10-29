package com.abhishek.amar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abhishek.amar.entity.State;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {
	@Query(value = "select * from State where country_id=:id", nativeQuery = true)
	List<Object[]> findByCountryId(@Param("id") Integer id);
}
