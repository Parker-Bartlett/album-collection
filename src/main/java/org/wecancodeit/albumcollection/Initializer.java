package org.wecancodeit.albumcollection;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Comment;
import org.wecancodeit.albumcollection.models.Rating;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.models.Tag;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.RatingRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;
import org.wecancodeit.albumcollection.repositories.TagRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	SongRepository songRepo;
	
	@Resource
	AlbumRepository albumRepo;
	
	@Resource
	ArtistRepository artistRepo;
	
	@Resource
	TagRepository tagRepo;
	
	@Resource
	RatingRepository ratingRepo;
	
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
		
		Tag tag1 = tagRepo.save(new Tag("Awesome"));
		Tag tag2 = tagRepo.save(new Tag("Sweet"));
		Tag tag3 = tagRepo.save(new Tag("Dude"));
		
		tagRepo.save(tag1);
		tagRepo.save(tag2);
		tagRepo.save(tag3);
		
		song1.addTagtoTags(tag1);
		song2.addTagtoTags(tag2);
		song3.addTagtoTags(tag3);
		
		songRepo.save(song1);
		songRepo.save(song2);
		songRepo.save(song3);

		Comment comment1 = new Comment("Cool stuff");
		Comment comment2 = new Comment("Awful stuff");
		Comment comment3 = new Comment("Decent stuff");
		
		song1.addComment(comment1);
		song1.addComment(comment2);
		
		songRepo.save(song1);
		
		Rating rating1 = new Rating(album1, 5);
		Rating rating2 = new Rating(album1, 4);
		Rating rating3 = new Rating(album1, 3);
		
		ratingRepo.save(rating1);
		ratingRepo.save(rating2);
		ratingRepo.save(rating3);
	}

}
