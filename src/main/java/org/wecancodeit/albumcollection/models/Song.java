package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
	@OneToMany(mappedBy="song")
	private Collection<Rating> ratings;
	@OneToMany(mappedBy="song")
	private Collection<Comment> comments;
	@ManyToMany
	private Collection<Tag> tags;
	
	public Song() {}
	
	public Song(String songTitle, String duration, String link, Album album) {
		this.songTitle = songTitle;
		this.duration = duration;
		this.link = link;
		this.album = album;
		this.tags = new ArrayList<Tag>();
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
	
	public void addTagtoTags(Tag tagToAdd) {
		tags.add(tagToAdd);
	}

	@Override
	public String toString() {
		return "Song [songTitle=" + songTitle + ", duration=" + duration + ", link=" + link + ", album=" + album + "]";
	}

	
}
