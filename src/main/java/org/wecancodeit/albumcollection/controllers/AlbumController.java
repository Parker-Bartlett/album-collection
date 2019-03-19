package org.wecancodeit.albumcollection.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;


	
	
	@RestController
	public class AlbumController {

		@Resource
		AlbumRepository albumRepo;

		@GetMapping("/albums")
		public Collection<Album> getAlbums() {
			return (Collection<Album>) albumRepo.findAll();

		}
}
