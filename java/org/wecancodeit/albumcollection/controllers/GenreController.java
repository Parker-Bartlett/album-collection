package org.wecancodeit.albumcollection.controllers;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Genre;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.GenreRepository;

@RestController
public class GenreController {
	
	@Resource
	GenreRepository genreRepo;
	
	@Resource 
	ArtistRepository artistRepo;
	
	@GetMapping("/genres/{id}")
	public Genre viewSingleGenre(@PathVariable Long id) {
		return genreRepo.findById(id).get();
	}
	
	@PostMapping ("/genres/add/{id}")
	public Artist addGenreToArtist(@PathVariable Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String genreName = json.getString("genreName");
		
		Genre genre = genreRepo.save(new Genre(genreName));
		Artist artist = artistRepo.findById(id).get();
		artist.addGenreToGenres(genre);
		
		return artistRepo.save(artist);
	}
}
