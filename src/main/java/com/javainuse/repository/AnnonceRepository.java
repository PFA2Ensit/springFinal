package com.javainuse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javainuse.model.Annonce;
import com.javainuse.model.DAOUser;

@Repository
@RepositoryRestResource(collectionResourceRel = "annonces", path = "annonces")
@CrossOrigin(origins = "http://localhost:4200")
public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
	List<Annonce>findAllByAnnonceur(Integer id);
	
	@RestResource(path="searchBox")
	Page<Annonce> findByNomEcoleAndTypeAndCapaciteGreaterThanEqualAndAvailableTrue(@Param("nom") String nom,@Param("type")String type,@Param("nombre") int nombre,Pageable pagebale);
	@RestResource(path="name")
	Page<Annonce> findByNomEcoleAndAvailableTrue(@Param("nom") String name, Pageable pagebale);
	@RestResource(path="tri")
	Page<Annonce> findFirst6ByAndAvailableTrueOrderByDateAjoutDesc(Pageable pagebale);
	
	@RestResource(path="prixD")
	Page<Annonce> findByNomEcoleAndTypeAndCapaciteGreaterThanEqualAndAvailableTrueOrderByPrixDesc(@Param("nom") String nom,@Param("type")String type,@Param("nombre") int nombre,Pageable pagebale);
	
	@RestResource(path="prixA")
	Page<Annonce> findByNomEcoleAndTypeAndCapaciteGreaterThanEqualAndAvailableTrueOrderByPrixAsc(@Param("nom") String nom,@Param("type")String type,@Param("nombre") int nombre,Pageable pagebale);
	
	Page<Annonce> findByNomEcoleAndTypeAndAvailableTrue(@Param("nom") String nom,@Param("type")String type,Pageable pagebale);
	
	Page<Annonce> findByTypeAndAvailableTrue(@Param("type")String type,Pageable pagebale);
	
	Page<Annonce> findByTypeAndCapaciteGreaterThanEqualAndAvailableTrue(@Param("type")String type,@Param("nombre") int nombre,Pageable pagebale);

	Optional<Annonce> findByDescription(String description);
	@RestResource(path="count")
	@Query(value="SELECT count(*) FROM annonce ",nativeQuery = true)
	 long count();
	
	@Query(value="SELECT * FROM annonce ", nativeQuery = true)
	List<Annonce> get();
	
	@Query(value="SELECT * FROM annonce WHERE id_annonce=?1 ", nativeQuery = true)
	Annonce getann(@PathVariable(value = "id") Integer Id );
	
	
	
	@RestResource(path = "searchbykeyword")
	Page<Annonce> findByNomEcoleContainingAndAnnonceur(@Param("name") String keyword,@RequestBody DAOUser annonceur, Pageable pageable);
	
	@RestResource(path = "getAdd")
	Annonce findByDescriptionAndAnnonceur(@Param("desc") String desc,@RequestBody DAOUser annonceur);
	
	


}

