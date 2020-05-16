package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_annonceur")
	private Integer Id ;
	
	@Column(name="username")
	private String username ;
	@Column(name="password")
	private String password; 	
	
	@Column(name="email")
	private String email ;
	@Column(name="phone")
	private String phone;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="annonceur")
    private Set<Annonce> annonce;

	@Override
	public String toString() {
		return "Annonceur [Id=" + Id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", annonce=" + annonce + "]";
	}
	 
	
	
	 /*public String toString(){
		 String info = "";
	        JSONObject jsonInfo = new JSONObject();
	        if(this.annonce != null){
	            this.annonce.forEach(annonce->{
	                JSONObject subJson = new JSONObject();
	                subJson.put("image", annonce.getImage_url());
	                jsonInfo.put("descripion",annonce.getDescription());
	    	        jsonInfo.put("price",annonce.getPrix());
	    	        


	            });
	        }
	        
	       
	        info = jsonInfo.toString();
	        return info;
	    }*/

}