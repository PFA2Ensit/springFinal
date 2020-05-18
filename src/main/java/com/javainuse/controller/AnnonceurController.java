package com.javainuse.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Annonce;
import com.javainuse.model.DAOUser;
import com.javainuse.dao.UserDao;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")

@RestController
public class AnnonceurController  {
	
	@Autowired
	private UserDao rep;
	@Autowired
    private UserDao annonceRepository;
	//@RequestMapping(value = "/dAOUsers/{id}/annonce", method = RequestMethod.GET)
	//@GetMapping("/annonceurs/{id}/annonce")
	/*List<Annonce> findAll(){
		return  rep.findAll();
		
	}*/
	
	

}
