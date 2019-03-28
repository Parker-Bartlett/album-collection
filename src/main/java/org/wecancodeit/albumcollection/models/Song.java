package org.wecancodeit.albumcollection.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	private String songTitle;
	private String duration;
	@Lob
	private String link;
	@ManyToOne
	@JsonIgnore
	private Album album;
	@ElementCollection
	@CollectionTable
	private Collection<Comment> comments;
	
	public Song() {}
	
	public Song(String songTitle, String duration, String link, Album album) {
		this.songTitle = songTitle;
		this.duration = duration;
		this.link = link;
		this.album = album;
		this.comments = new ArrayList<Comment>();
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
	
	public Collection<Comment> getComments() {
		return comments;
	}

	public void addComment(Comment commentToAdd) {
		comments.add(commentToAdd);
	}
	
	
}
