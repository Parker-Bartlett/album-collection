package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String tagName;
	@ManyToOne
	private Song song;
	
	public Tag() {}
		
	public Tag(String tagName, Song song) {
		this.tagName = tagName;
		this.song = song;
	}
	
	public Long getId() {
		return id;
	}
	public String getTagName() {
		return tagName;
	}
	public Song getSong() {
		return song;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + ", song=" + song + "]";
	}
}