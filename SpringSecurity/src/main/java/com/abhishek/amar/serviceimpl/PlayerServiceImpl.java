/**
 * 
 */
package com.abhishek.amar.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.abhishek.amar.entity.PlayerEntity;
import com.abhishek.amar.repository.PlayerRepository;
import com.abhishek.amar.service.PlayerService;

/**
 * @author Abhishek Amar
 *
 */
@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public void save(PlayerEntity player) {
		player.setCreatedAt(new Date()); 
		playerRepository.save(player);
	}

	@Override
	public PlayerEntity getPlayerById(Integer id) {
		return playerRepository.findPlayerById(id);
	}

	@Override
	public List<PlayerEntity> getAllPlayerDetails() {
		return playerRepository.findAll();
	}

	@Override
	public void deletePlayer(Integer id) {
		//PlayerEntity playerEntity =playerRepository.findPlayerById(id);
		//playerEntity.setDeleted(true);
		//playerRepository.save(playerEntity);
		playerRepository.deleteById(id);
	}

	@Override
	public PlayerEntity updatePlauyerById(PlayerEntity playerEntity) {
		PlayerEntity playerEnt = playerRepository.findPlayerById(playerEntity.getId());
		playerEnt.setCategory(playerEntity.getCategory());
		playerEnt.setImage(playerEntity.getImage());
		playerEnt.setName(playerEntity.getName());
		playerEnt.setUpdatedAt(new Date());
		playerEnt.setCountry(playerEntity.getCountry());
		playerRepository.save(playerEnt);
		return playerEnt;
	}

	@Override
	public List<PlayerEntity> getAllPlayerDetails(Integer offSet,Integer limit) {   
		return playerRepository.findAllByLimitAndOffSet(offSet,limit);
	}

}
