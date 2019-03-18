package org.wecancodeit.albumcollection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Album {
	@Id	
	@GeneratedValue
	private Long id;
	private String albumTitle;
	private String image;
	private String songs; //Collection of songs
	private String recordLabel;
	
	public Album() {}
	
	public Album(String title, String image, String songs, String recordLabel) {
		this.albumTitle = title;
		this.image = image;
		this.songs = songs;
		this.recordLabel = recordLabel;
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
	public String getSongs() {
		return songs;
	}
	public String getRecordLabel() {
		return recordLabel;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + albumTitle + ", image=" + image + ", songs=" + songs + ", recordLabel="
				+ recordLabel + "]";
	}
	
}
