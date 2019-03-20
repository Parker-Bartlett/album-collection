package org.wecancodeit.albumcollection.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String tagName;
	@ManyToMany(mappedBy="tags")
	@JsonIgnore
	private Collection<Song> songs;
	
	public Tag() {}
		
	public Tag(String tagName) {
		this.tagName = tagName;
	}
	
	public Long getId() {
		return id;
	}
	public String getTagName() {
		return tagName;
	}
	public Collection<Song> getSongs() {
		return songs;
	}
	
//	public void addSongToSongs(Song songToAdd) {
//		songs.add(songToAdd);
//	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + ", songs=" + songs + "]";
	}
}