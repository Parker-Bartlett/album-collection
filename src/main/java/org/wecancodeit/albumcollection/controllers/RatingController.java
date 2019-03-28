package org.wecancodeit.albumcollection.controllers;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Rating;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.RatingRepository;

@RestController
public class RatingController {

	@Resource
	RatingRepository ratings;
	@Resource
	AlbumRepository albums;
	
	@PostMapping("/ratings/add/{id}")
    public Album addRatingToAlbum(@PathVariable Long id, @RequestBody String body) throws JSONException {
        JSONObject json = new JSONObject(body);
        System.out.println(json);
        double rating = json.getDouble("rating"); 
        Album album = albums.findById(id).get();
        ratings.save(new Rating(album, rating));
        album = albums.findById(id).get();
        return album;
    }
	
}
