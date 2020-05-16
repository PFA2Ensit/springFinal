package com.javainuse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.javainuse.model.Etudiant;
@Repository
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface EtudiantRepository extends JpaRepository <Etudiant, Integer>{

	 Etudiant findEtudiantByEmail(String email);
	 Etudiant findByUsername(String userName);
}
