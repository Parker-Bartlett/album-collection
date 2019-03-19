package org.wecancodeit.albumcollection;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	SongRepository songRepo;
	
	@Resource
	AlbumRepository albumRepo;
	
	@Resource
	ArtistRepository artistRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Artist artist1 = artistRepo.save(new Artist("Pink Floyd", "imageUrl"));
		Artist artist2 = artistRepo.save(new Artist("Elton John", "imageUrl"));
		Artist artist3 = artistRepo.save(new Artist("Backstreet Boys", "imageURL"));
		
		Album album1 = albumRepo.save(new Album("Animals", "imageURL", "label1", artist1));
		Album album2 = albumRepo.save(new Album("Yellow Brick Road", "imageURL", "label2", artist2));
		Album album3 = albumRepo.save(new Album("Backstreet's Back", "imageURL", "label3", artist3));
		
		Song song1 = songRepo.save(new Song("Dogs", "1:11", "songLink1", album1));
		Song song2 = songRepo.save(new Song("Yellow Brick Road", "2:22", "songLink2", album2));
		Song song3 = songRepo.save(new Song("Backstreet's Back", "3:33", "songLink3", album3));
		
	}

	
}
