package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	private String songTitle;
	private String duration;
	private String link;
	@ManyToOne
	@JsonIgnore
	private Album album;
	
	public Song() {}
	
	public Song(String songTitle, String duration, String link, Album album) {
		this.songTitle = songTitle;
		this.duration = duration;
		this.link = link;
		this.album = album;
	}

	public Long getId() {
		return id;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public String getDuration() {
		return duration;
	}

	public String getLink() {
		return link;
	}
	
	public Album getAlbum() {
		return album;
	}

	@Override
	public String toString() {
		return "Song [songTitle=" + songTitle + ", duration=" + duration + ", link=" + link + ", album=" + album + "]";
	}

	
}
