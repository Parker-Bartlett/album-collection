package org.wecancodeit.albumcollection.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;

@RestController
public class SongController {

	@Resource
	SongRepository songRepo;
	
	@Resource
	AlbumRepository albumRepo;
	
	@GetMapping("/songs")
	public Collection<Song> getSongs() {
		return (Collection<Song>) songRepo.findAll();
	}
	
	@GetMapping("/songs/{id}")
	public Song viewSingleSong(@PathVariable Long id) {
		return songRepo.findById(id).get();
	}
	
	@PostMapping("/songs/add/{id}")
	public Album addSong(@PathVariable Long id, @RequestBody String body) throws JSONException{
     JSONObject json = new JSONObject(body);
     String songTitle = json.getString("songTitle");
     String duration = json.getString("duration");
     String link = json.getString("link");
     Album albumToAdd = albumRepo.findById(id).get();
     songRepo.save(new Song(songTitle, duration, link, albumToAdd));
     albumToAdd = albumRepo.findById(id).get();
     return albumToAdd;
	}
}
