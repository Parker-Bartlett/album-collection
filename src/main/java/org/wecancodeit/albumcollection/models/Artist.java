package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue
	private Long id;
	private String artistName;
	@Lob
	private String image;
	@OneToMany(mappedBy="artist")
	private Collection<Album> albums; 
	@ManyToMany
	private Collection<Genre> genres;
	
	public Artist() {}
	
	public Artist(String artistName, String image) {
		this.artistName = artistName;
		this.image = image;
		this.genres = new ArrayList<Genre>();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getArtistName() {
		return artistName;
	}
	
	public String getImage() {
		return image;
	}
	
	public Collection<Album> getAlbums() {
		return albums;
	}
	
	public Collection<Genre> getGenres() {
		return genres;
	}
	
	public void addGenreToGenres(Genre genreToAdd) {
		genres.add(genreToAdd);
	}	

}
