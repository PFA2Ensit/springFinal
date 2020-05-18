package com.javainuse.model;

import java.util.Date

;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="annonce")
public class Annonce {
	
	
	

	public Annonce(String nom_ecole, float prix, String description, int nb_place, String type, String image_url,
			Boolean available, String genre, DAOUser annonceur) {
		super();
		this.nomEcole = nom_ecole;
		this.prix = prix;
		this.description = description;
		this.capacite = nb_place;
		this.type = type;
		this.image_url = image_url;
		this.available = available;
		this.genre = genre;
		this.annonceur = annonceur;
	}



	public Annonce(Integer value, String string) {
		// TODO Auto-generated constructor stub
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_annonce")
	private Integer Id ;
	
	@Column(name="nom_ecole")
	private String nomEcole ;
	
	@Column(name="prix")
	private Float prix; 
	
	@Column(name="description")
	private String description ;
	
	@Column(name="nb_place")
	private Integer capacite;
	
	@Column(name="type")
	private String type;
	
	
	@Column(name="image_url")
	private String image_url;
	
	@Column(name="date_ajout")
	private Date dateAjout = new Date();
	
	@Column(name="available")
	private Boolean available =true;
	
	@Column(name="genre")
	private String genre;
	
	 @ManyToOne
	 @JoinColumn(name = "id_annonceur",insertable =true)
	private DAOUser annonceur;
	 
	 

	
	



	
	
	

	 
	
}
