/**
 * 
 */
package com.abhishek.amar.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.abhishek.amar.entity.PlayerEntity;

/**
 * @author Abhishek Amar
 *
 */
public interface PlayerService {
	void save(PlayerEntity player);

	/* @Cacheable(value = "cacheManager", key = "#id") */
	PlayerEntity getPlayerById(Integer id);

	/* @Cacheable(value = "cacheManager", key = "#allPlayerDetails") */
	List<PlayerEntity> getAllPlayerDetails();

	/* @CacheEvict(value = "cacheManager", key = "#id") */
	void deletePlayer(Integer id);

	/* @CachePut(value = "cacheManager", key = "#player") */
	PlayerEntity updatePlauyerById(PlayerEntity player);

	/* @Cacheable(value = "cacheManager", key = "#allPlayerDetailsLimit") */
	List<PlayerEntity> getAllPlayerDetails(Integer limit, Integer offSet);
}
