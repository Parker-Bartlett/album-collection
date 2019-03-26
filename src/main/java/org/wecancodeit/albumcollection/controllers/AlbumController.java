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
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;

@RestController
public class AlbumController {
	
	@Resource
	ArtistRepository artistRepo;
	
	@Resource
	AlbumRepository albumRepo;

	@GetMapping("/albums")
	public Collection<Album> getAlbums() {
		return (Collection<Album>) albumRepo.findAll();

	}

	@PostMapping("/albums/add/{id}")
	public Artist addAlbumToArtist(@PathVariable Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String albumTitle = json.getString("albumTitle");
		String image = json.getString("image");
		Artist artistToAdd = artistRepo.findById(id).get();
		albumRepo.save(new Album(albumTitle, image, "recordLabel", artistToAdd));
		artistToAdd = artistRepo.findById(id).get();
		return artistToAdd;
		
	}

	@GetMapping("/albums/{id}")
	public Album viewSingleAlbum(@PathVariable Long id) {
		return albumRepo.findById(id).get();
	}

}
