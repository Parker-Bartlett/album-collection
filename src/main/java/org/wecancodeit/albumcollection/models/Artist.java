package org.wecancodeit.albumcollection.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue
	private Long id;
	private String artistName;
	private String image;
	@OneToMany(mappedBy="artist")
	private Collection<Album> albums; 
	
	public Artist() {}
	
	public Artist(String artistName, String image) {
		this.artistName = artistName;
		this.image = image;
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

	@Override
	public String toString() {
		return "Artist [artistName=" + artistName + ", image=" + image + ", albums=" + albums + "]";
	}
	

}
