package org.wecancodeit.albumcollection.controllers;

import java.util.Collection;


import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;

@RestController
public class ArtistController {

	@Resource
	ArtistRepository artistRepo;

	@GetMapping("/artists")
	public Collection<Artist> getArtists() {
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	@PostMapping("/artists/add")
	public Collection<Artist> addArtist(@RequestBody String body) throws JSONException{
     JSONObject json = new JSONObject(body);
     String artistName = json.getString("artistName");
     String image = json.getString("image");
     artistRepo.save(new Artist(artistName, image));
     return (Collection<Artist>) artistRepo.findAll();
	}
}
