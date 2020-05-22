package com.javainuse.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.javainuse.model.DAOUser;

@Repository
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface UserDao extends JpaRepository<DAOUser, Integer> {
	DAOUser findByEmail(String email);
	Optional<DAOUser> findById(Integer id);
	DAOUser findByUsername(String username);
	
   
	
}