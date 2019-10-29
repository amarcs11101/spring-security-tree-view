package com.abhishek.amar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.amar.repository.Country;
import com.abhishek.amar.repository.StateRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/relation")
public class ParentChildRelationController {
	@Autowired
	private Country country;
	@Autowired
	private StateRepo stateRepo;

	@GetMapping
	public ResponseEntity<Object> showRelation() {
		List<com.abhishek.amar.entity.Country> listCountry = country.findAll();
		return new ResponseEntity<>(listCountry, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getState(@PathVariable("id") Integer id) {
		List<com.abhishek.amar.entity.State> listStates = new ArrayList<>();
		List<Object[]> stateList = stateRepo.findByCountryId(id);
		for (Object[] objects : stateList) {
			com.abhishek.amar.entity.State state = new com.abhishek.amar.entity.State();
			state.setId(Integer.parseInt(objects[0].toString()));
			state.setStateName(objects[2].toString());
			listStates.add(state);
		}
		System.out.println("+++++++++++++ "+ listStates.size());
		return new ResponseEntity<>(listStates, HttpStatus.OK);
	}
}
