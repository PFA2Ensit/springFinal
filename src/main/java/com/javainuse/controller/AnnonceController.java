package com.javainuse.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.HashMap;



import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.json.JSONObject;
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
import com.javainuse.serialize.JsonSerializeUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javainuse.dao.UserDao;
import com.javainuse.exception.ResourceExistsException;
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
	
	@RequestMapping(value = "/annonces", method = RequestMethod.GET)
	public String get() throws JsonProcessingException{

		return JsonSerializeUtils.serializeObjectToString(annonceRepository.get());
	}
	
	
	
	@RequestMapping(value = "/annonces", method = RequestMethod.POST)
    public Annonce createAnnonce(@RequestBody Annonce annonce) throws ResourceExistsException {
		annonce.setAnnonceur(annonce.getAnnonceur());
		annonce.setCapacite(annonce.getCapacite());
		annonce.setDescription(annonce.getDescription());
		annonce.setGenre(annonce.getGenre());
		annonce.setNomEcole(annonce.getNomEcole());
		annonce.setType(annonce.getType());
		annonce.setPrix(annonce.getPrix());
		annonce.setImage_url(annonce.getImage_url());
		 Optional < Annonce > productDb = this.annonceRepository.findByDescription(annonce.getDescription());

	        if (productDb.isPresent()) {
	        	throw new ResourceExistsException("Announce already exists " );
	        }else {
	        	
	        	 return annonceRepository.save(annonce);
	        }
	        
		
        
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
	*/
	@RequestMapping(value = "/annonces/{id}", method = RequestMethod.GET)
    public String getAnnonceById(@PathVariable(value = "id") Integer Id)
        throws ResourceNotFoundException {
    	Annonce annonce = annonceRepository.findById(Id)
          .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + Id));
    	String info = "";
	      
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("id",annonce.getId());
        jsonInfo.put("nomEcole",annonce.getNomEcole());	        

        jsonInfo.put("prix",annonce.getPrix());
        jsonInfo.put("description",annonce.getDescription());
        jsonInfo.put("capacite",annonce.getCapacite());
        jsonInfo.put("type",annonce.getType());
        jsonInfo.put("image_url",annonce.getImage_url());
        jsonInfo.put("available",annonce.getAvailable());
        jsonInfo.put("genre",annonce.getGenre());

        

        JSONObject companyObj = new JSONObject();
        companyObj.put("username", annonce.getAnnonceur().getUsername());
        companyObj.put("email", annonce.getAnnonceur().getEmail());
        companyObj.put("password", annonce.getAnnonceur().getPassword());
        companyObj.put("phone", annonce.getAnnonceur().getPhone());



        jsonInfo.put("annonceur", companyObj);
        
        info = jsonInfo.toString();
        return info;
    	
        //return ResponseEntity.ok().body(annonce);
    }
	/*@RequestMapping(value = "/annonces/{id}", method = RequestMethod.GET)
	Annonce getann(@PathVariable(value = "id") Integer Id){
		
		 String info = "";
	      
	        JSONObject jsonInfo = new JSONObject();
	        jsonInfo.put("id",this.Id);
	        jsonInfo.put("nomEcole",this.nomEcole);	        

	        jsonInfo.put("prix",this.prix);
	        jsonInfo.put("description",this.description);
	        jsonInfo.put("capacite",this.capacite);
	        jsonInfo.put("type",this.type);
	        jsonInfo.put("image_url",this.image_url);
	        jsonInfo.put("dateAjout",this.dateAjout);
	        jsonInfo.put("available",this.available);
	        jsonInfo.put("genre",this.genre);

	        

	        JSONObject companyObj = new JSONObject();
	        companyObj.put("username", this.annonceur.getUsername());
	        companyObj.put("email", this.annonceur.getEmail());
	        companyObj.put("password", this.annonceur.getPassword());
	        companyObj.put("phone", this.annonceur.getPhone());



	        jsonInfo.put("company", companyObj);
	        
	        info = jsonInfo.toString();
	        return info;
		return annonceRepository.getann(Id);
		
	}*/
   
    
    
    @RequestMapping(value = "/annonces/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable(value = "id") Integer annonceId,
         @Valid @RequestBody Annonce details) throws ResourceNotFoundException {
    	Annonce annonce = annonceRepository.findById(annonceId)
        .orElseThrow(() -> new ResourceNotFoundException("	Announce not found for this id :: " + annonceId));
    	//annonce.setAnnonceur(details.getAnnonceur());
    	annonce.setNomEcole(details.getNomEcole());
        annonce.setCapacite(details.getCapacite());
    	annonce.setImage_url(details.getImage_url());
    	annonce.setPrix(details.getPrix());
    	annonce.setType(details.getType());
    	annonce.setGenre(details.getGenre());
        annonce.setDescription(details.getDescription());
    	final Annonce updated = annonceRepository.save(annonce);
        return ResponseEntity.ok(updated);
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
    }
    
    
    
   
}
