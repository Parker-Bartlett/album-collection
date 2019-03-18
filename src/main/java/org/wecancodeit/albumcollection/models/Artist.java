package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue
	private Long id;
	private String artistName;
	private String image;
	private String albums; //this will be a collection of albums
	
	public Artist() {}
	
	public Artist(String artistName, String image, String albums) {
		this.artistName = artistName;
		this.image = image;
		this.albums = albums;
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
	public String getAlbums() {
		return albums;
	}
	@Override
	public String toString() {
		return "Artist [id=" + id + ", artistName=" + artistName + ", image=" + image + ", Albums=" + albums + "]";
	}
	
	
	

}
