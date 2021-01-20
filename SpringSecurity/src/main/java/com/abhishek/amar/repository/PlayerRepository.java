/**
 * 
 */
package com.abhishek.amar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhishek.amar.entity.PlayerEntity;

/**
 * @author Abhishek Amar
 *
 */
@Repository 
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
	PlayerEntity findPlayerById(Integer id);

	List<PlayerEntity> findAll();

	void deletePlayerById(Integer id);
	
	
	@Query(value="select * from players p  order by p.id desc offset ?1 limit ?2 ",nativeQuery = true)
	List<PlayerEntity> findAllByLimitAndOffSet(Integer offSet,Integer limit);
	 
	//List<PlayerEntity> findAllByLimitAndOffSet(Integer limit,Integer offset);
}
