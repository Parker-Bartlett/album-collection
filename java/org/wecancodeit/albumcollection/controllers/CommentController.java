package org.wecancodeit.albumcollection.controllers;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Comment;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.SongRepository;

@RestController
public class CommentController {
	
	@Resource
	SongRepository songRepo;
	
	@PostMapping("/comments/add/{id}")
	public Song addComment(@PathVariable Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
	    String commentContent = json.getString("commentContent");
	    Comment commentToAdd = new Comment(commentContent);
	    Song song = songRepo.findById(id).get();
	    song.addComment(commentToAdd); 
	    //song = songRepo.save(song);
	    return songRepo.save(song);
	    
	}

}
