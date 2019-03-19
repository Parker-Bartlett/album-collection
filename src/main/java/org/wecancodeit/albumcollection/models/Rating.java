package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Song song;
	private double songRating;
	
	public Rating() {}

	public Rating(Song song, double songRating) {
		this.song = song;
		this.songRating = songRating;
	}
	
	public Long getId() {
		return id;
	}

	public Song getSong() {
		return song;
	}

	public double getSongRating() {
		return songRating;
	}

	public void setSongRating(double songRating) {
		this.songRating = songRating;
	}
	

}
