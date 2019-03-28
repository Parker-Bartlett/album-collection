package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rating {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JsonIgnore
	private Album album;
	private double albumRating;
	
	public Rating() {}

	public Rating(Album album, double albumRating) {
		this.album = album;
		this.albumRating = albumRating;
	}
	
	public Long getId() {
		return id;
	}

	public Album getAlbum() {
		return album;
	}

	public double getAlbumRating() {
		return albumRating;
	}
	
}
