package org.wecancodeit.albumcollection.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Genre {

	@Id
	@GeneratedValue
	private Long id;
	private String genreName;
	@ManyToMany(mappedBy="genres")
	@JsonIgnore
	private Collection<Artist> artists;
	
	public Genre() {}
		
	public Genre(String genreName) {
		this.genreName = genreName;
	}
	
	public Long getId() {
		return id;
	}
	public String getGenreName() {
		return genreName;
	}
	public Collection<Artist> getArtists() {
		return artists;
	}

}