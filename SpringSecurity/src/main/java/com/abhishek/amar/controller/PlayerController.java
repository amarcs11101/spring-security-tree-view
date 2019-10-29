package com.abhishek.amar.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.amar.entity.PlayerEntity;
import com.abhishek.amar.enums.ProjectModule;
import com.abhishek.amar.exceptionhandler.PlayerNotFoundException;
import com.abhishek.amar.response.ApiResponse;
import com.abhishek.amar.service.PlayerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/player")
public class PlayerController {
	private Logger logger = LogManager.getLogger(PlayerController.class);
	@Autowired
	private PlayerService playerServices;
	
	@Value("${id.not.found}")
	private String idNotFound;

	@Value("${player.id.notpresent}")
	private String idNotPresent;

	@Value("${player.deleted}")
	private String playerDeleted;

	@Value("${player.deleted.error.msg}")
	private String deletedErrorMsg;

	@Value("${player.not.found}")
	private String playerNotFound;

	@Value("${player.not.saved}")
	private String playerNotSaved;

	@Value("${api.token}")
	private String token;

	@Value("${player.saved}")
	private String playerSaved;

	@Value("${player.updated}")
	private String playerUpdated;

	@PostMapping
	public ResponseEntity<Object> savePlayerDetails(@RequestBody PlayerEntity playerEntity) {
		ApiResponse response = null;
		try {
			logger.info(":: /api/player :: savePlayerDetails controller called ::" + playerEntity);
			playerServices.save(playerEntity);
			response = new ApiResponse(HttpStatus.OK, playerSaved, playerEntity, token);
			logger.info(":: /api :: inside savePlayerDetails :: details saved ::");
		} catch (Exception e) {
			logger.error(":: /api :: inside savePlayerDetails :: exception ::", e);
			throw new PlayerNotFoundException(playerNotSaved);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Object> getAllPlayerDetails() {
		ApiResponse response = null;
		List<PlayerEntity> playerList = playerServices.getAllPlayerDetails();
		if (playerList.isEmpty() && playerList == null) {
			logger.error(":: /api/player :: inside getAllPlayerDetails :: exceptions ::");
			throw new PlayerNotFoundException(playerNotFound);
		} else {
			logger.info(":: /api/player :: inside getAllPlayerDetails ::");
			response = new ApiResponse(HttpStatus.OK, null, playerList, token);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getPlayerById(@PathVariable("id") Integer id) {
		ApiResponse response = null;
		PlayerEntity playerEntity = playerServices.getPlayerById(id);
		if (playerEntity != null) {
			logger.info(":: /api/player/{id} :: inside getPlayerById ::" + id);
			response = new ApiResponse(HttpStatus.OK, null, playerEntity, token);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			logger.error("::/api/player/{id}:: inside getPlayerById :: exceptions ::");
			throw new PlayerNotFoundException(idNotFound + id);
		}
	}

	// @DeleteMapping("/{delete_id}")
	@DeleteMapping("/{delete_id}")
	public ResponseEntity<Object> deletePlayerById(@PathVariable("delete_id") Integer deleteId) {
		ApiResponse response = null;
		try {
			logger.info(":: /api/player/{delete_id} :: inside deletePlayerById ::" + deleteId);
			playerServices.deletePlayer(deleteId);
			response = new ApiResponse(HttpStatus.OK, playerDeleted, null, token);
		} catch (Exception e) {
			logger.error(":: /api/player/{delete_id} :: inside deletePlayerById :: exceptions ::");
			throw new PlayerNotFoundException(deletedErrorMsg);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Object> updatePlayersDetailsById(@RequestBody PlayerEntity playerEntity) {
		ApiResponse response = null;
		try {
			logger.info(":: /api/player :: inside updatePlayerDetailsById :: " + playerEntity);
			playerEntity = playerServices.updatePlauyerById(playerEntity);
			response = new ApiResponse(HttpStatus.OK, playerUpdated, playerEntity, token);
		} catch (Exception e) {
			logger.error(":: /api/player :: inside updatePlayerDetailsById :: exceptions ::", e);
			throw new PlayerNotFoundException(idNotPresent);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/page")
	public ResponseEntity<Object> getAllPlayerDetailsWithPagination(
			@RequestParam(value = "limit", defaultValue = "6") Integer limit,
			@RequestParam(value = "offSet", defaultValue = "0") Integer offSet) {
		ApiResponse response = null;
		List<PlayerEntity> playerList = playerServices.getAllPlayerDetails(offSet * limit, limit);
		if (playerList.isEmpty() && playerList == null) {
			logger.error(":: /api/player :: inside getAllPlayerDetailsWithPagination :: exceptions ::");
			throw new PlayerNotFoundException(playerNotFound);
		} else {
			logger.info(":: /api/player :: inside getAllPlayerDetailsWithPagination ::offset " + offSet + " and limit "
					+ limit);
			response = new ApiResponse(HttpStatus.OK, null, playerList, token);
			response.setLimit(limit);
			response.setOffSet(offSet);
			response.setModuleAccess(ProjectModule.values());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
}
