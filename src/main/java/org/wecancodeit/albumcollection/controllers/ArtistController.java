package org.wecancodeit.albumcollection.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
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
}
