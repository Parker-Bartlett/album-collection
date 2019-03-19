package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Song song;
	private String commentContent;
	
	public Comment() {}
	
	public Comment(Song song, String commentContent) {
		this.song = song;
		this.commentContent = commentContent;
	}
	
	public Comment(String commentContent) {
		this.commentContent = commentContent;
	}

	public Long getId() {
		return id;
	}

	public Song getSong() {
		return song;
	}

	public String getCommentContent() {
		return commentContent;
	}

	
}

