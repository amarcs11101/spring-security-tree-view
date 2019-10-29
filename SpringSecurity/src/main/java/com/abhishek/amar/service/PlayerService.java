/**
 * 
 */
package com.abhishek.amar.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.abhishek.amar.entity.PlayerEntity;

/**
 * @author Abhishek Amar
 *
 */
public interface PlayerService {
	void save(PlayerEntity player);

	PlayerEntity getPlayerById(Integer id);

	List<PlayerEntity> getAllPlayerDetails();

	void deletePlayer(Integer id);
	
	PlayerEntity updatePlauyerById(PlayerEntity player);
	
	List<PlayerEntity> getAllPlayerDetails(Integer limit,Integer offSet);
}
