package org.wecancodeit.albumcollection.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.SongRepository;

@RestController
public class SongController {

	@Resource
	SongRepository songRepo;
	
	@GetMapping("/songs")
	public Collection<Song> getSongs() {
		return (Collection<Song>) songRepo.findAll();
	
	}
}
