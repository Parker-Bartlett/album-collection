package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	private String songTitle;
	private String duration;
	private String link; 
	
	public Song() {}
	
	public Song(String songTitle, String duration, String link) {
		
		this.songTitle = songTitle;
		this.duration = duration;
		this.link = link;
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

	@Override
	public String toString() {
		return "Song [id=" + id + ", songTitle=" + songTitle + ", duration=" + duration + ", link=" + link + "]";
	}

	
	
	
}
