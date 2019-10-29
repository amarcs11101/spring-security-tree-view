package com.abhishek.amar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Country extends JpaRepository< com.abhishek.amar.entity.Country,Integer>{

}
