package org.wecancodeit.albumcollection.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {
	@Id	
	@GeneratedValue
	private Long id;
	private String albumTitle;
	private String image;
	
	
	private String recordLabel;
	@ManyToOne
	@JsonIgnore
	private Artist artist;
	@OneToMany(mappedBy="album")
	private Collection<Song> songs;
	
	public Album() {}
	
	public Album(String title, String image, String recordLabel, Artist artist) {
		this.albumTitle = title;
		this.image = image;
		this.recordLabel = recordLabel;
		this.artist = artist;
	}


	public Long getId() {
		return id;
	}
	
	public String getAlbumTitle() {
		return albumTitle;
	}
	
	public String getImage() {
		return image;
	}
	
	public Collection<Song> getSongs() {
		return songs;
	}
	public String getRecordLabel() {
		return recordLabel;
	}
	
	public Artist getArtist() {
		return artist;
	}

	@Override
	public String toString() {
		return "Album [albumTitle=" + albumTitle + ", image=" + image + ", recordLabel=" + recordLabel + ", artist="
				+ artist + ", songs=" + songs + "]";
	}
	
	
	
}
