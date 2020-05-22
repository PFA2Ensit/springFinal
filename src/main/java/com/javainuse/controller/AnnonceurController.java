package com.javainuse.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.DAOUser;
import com.javainuse.dao.UserDao;


@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")

public class AnnonceurController  {
	
	@Autowired
	private UserDao rep;
	//@RequestMapping(value = "/dAOUsers/{id}/annonce", method = RequestMethod.GET)
	//@GetMapping("/annonceurs/{id}/annonce")
	/*List<Annonce> findAll(){
		return  rep.findAll();
		
	}*/
	
	@RequestMapping(value ="/dAOUsers/{id}",method = RequestMethod.GET)
    public ResponseEntity<DAOUser> getById(@PathVariable(value = "id") Integer Id)
        throws ResourceNotFoundException {
		DAOUser user =rep.findById(Id)
          .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + Id));
        return ResponseEntity.ok().body(user);
    }
	
	@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")

	@RequestMapping(value = "/dAOUsers/{id}", method = RequestMethod.PUT)    
	public ResponseEntity<DAOUser> updateUser(@PathVariable(value = "id") Integer Id,
         @Valid @RequestBody DAOUser user) throws ResourceNotFoundException {
		DAOUser usera = rep.findById(Id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + Id));

        usera.setEmail(user.getEmail());
        usera.setPhone(user.getPhone());
        
        final DAOUser updateduser = rep.save(usera);
        return ResponseEntity.ok(updateduser);
    }

}
