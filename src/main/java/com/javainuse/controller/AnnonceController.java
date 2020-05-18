package com.javainuse.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.HashMap;



import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PagedResourcesAssembler;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Annonce;
import com.javainuse.model.DAOUser;
import com.javainuse.repository.AnnonceRepository;
import com.javainuse.dao.UserDao;
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")

@RestController
public class AnnonceController {
	
	
	@Autowired
    private AnnonceRepository annonceRepository;
	/*@Autowired
	private UserDao rep;
    private DAOUser annonceur;*/
	
	@Autowired
	public AnnonceController(AnnonceRepository annonceRepository) {
		super();
		this.annonceRepository = annonceRepository;
	}
	
	@RequestMapping(value = "/annonces", method = RequestMethod.POST)
    public Annonce createAnnonce(@RequestBody Annonce annonce) {
		annonce.setAnnonceur(annonce.getAnnonceur());
		annonce.setCapacite(annonce.getCapacite());
		annonce.setDescription(annonce.getDescription());
		annonce.setGenre(annonce.getGenre());
		annonce.setNomEcole(annonce.getNomEcole());
		annonce.setType(annonce.getType());
		annonce.setPrix(annonce.getPrix());
		annonce.setImage_url(annonce.getImage_url());
  	
		
         return annonceRepository.save(annonce);
    }
	

   /* @Autowired
    public AnnonceController(PagedResourcesAssembler<Annonce> pagedAssembler) {
        this.pagedAssembler = pagedAssembler;
    }

    private Page<Annonce> getAccounts(Pageable pageRequest){
        int totalAccounts= 50;
        List<Annonce> accountList = IntStream.rangeClosed(1, totalAccounts)
                                             .boxed()
                                             .map( value -> new Annonce(value.toString(),value.toString(),value.toString(),value.toString(),value.toString(),value.toString(),value.toString(),value.toString(),value.toString()))
                                             .skip(pageRequest.getOffset())
                                             .limit(pageRequest.getPageSize())
                                             .collect(Collectors.toList());
        return new PageImpl(accountList, pageRequest, totalAccounts);
    }

    @RequestMapping(method= RequestMethod.GET, path="/annonces", produces = "application/hal+json")
    public ResponseEntity<Page<Annonce>> getAccountsHal(Pageable pageRequest, PersistentEntityResourceAssembler assembler){
        return new ResponseEntity(pagedAssembler.toResource(getAccounts(pageRequest)), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/annonces/{id}", method = RequestMethod.GET)
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable(value = "id") Integer Id)
        throws ResourceNotFoundException {
    	Annonce annonce = annonceRepository.findById(Id)
          .orElseThrow(() -> new ResourceNotFoundException("Add not found for this id :: " + Id));
        return ResponseEntity.ok().body(annonce);
    }
    
   
    
    
    @RequestMapping(value = "/annonces/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable(value = "id") Integer annonceId,
         @Valid @RequestBody Annonce details) throws ResourceNotFoundException {
    	Annonce annonce = annonceRepository.findById(annonceId)
        .orElseThrow(() -> new ResourceNotFoundException("	Add not found for this id :: " + annonceId));

    	annonce.setAvailable(annonce.getAvailable());
    	annonce.setImage_url(annonce.getImage_url());
    	annonce.setPrix(annonce.getPrix());
    	annonce.setType(annonce.getType());
    	annonce.setGenre(annonce.getGenre());
    	annonce.setDateAjout(annonce.getDateAjout());
        annonce.setDescription(annonce.getDescription());
    	final Annonce updatedStudent = annonceRepository.save(annonce);
        return ResponseEntity.ok(updatedStudent);
    }
    @RequestMapping(value = "/annonces/{id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteAnnonce(@PathVariable(value = "id") Integer Id)
         throws ResourceNotFoundException {
    	Annonce annonce = annonceRepository.findById(Id)
       .orElseThrow(() -> new ResourceNotFoundException("Add not found for this id :: " +Id));

        annonceRepository.delete(annonce);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/
    
    
    
   
}
