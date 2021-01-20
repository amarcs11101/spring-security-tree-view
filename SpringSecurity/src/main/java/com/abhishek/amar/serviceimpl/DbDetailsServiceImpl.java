/**
 * 
 */
package com.abhishek.amar.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.amar.entity.DBEntity;
import com.abhishek.amar.repository.DbRepository;
import com.abhishek.amar.service.DbDetailsService;

/**
 * @author Abhishek Amar
 *
 */
@Service
public class DbDetailsServiceImpl implements DbDetailsService {
	@Autowired
	private DbRepository dbRepo;

	@Override
	public List<DBEntity> getAllDB() {
		return dbRepo.findAll();
	}

}
