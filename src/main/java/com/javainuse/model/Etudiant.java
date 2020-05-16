package com.javainuse.model;

import javax.persistence.GeneratedValue;


import javax.persistence.GenerationType;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="etudiant")
public class Etudiant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_e")
	private Integer Id ;
	@Column(name="username")
	private String username ;

	@Column(name="password")
	private String password; 	

	
	@Column(name="email")
	private String email ;
	@Column(name="phone")
	private String phone;
	 
	

}
