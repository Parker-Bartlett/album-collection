package org.wecancodeit.albumcollection;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.models.Comment;
import org.wecancodeit.albumcollection.models.Genre;
import org.wecancodeit.albumcollection.models.Rating;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.GenreRepository;
import org.wecancodeit.albumcollection.repositories.RatingRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	SongRepository songRepo;
	
	@Resource
	AlbumRepository albumRepo;
	
	@Resource
	ArtistRepository artistRepo;
	
	@Resource
	RatingRepository ratingRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Artist artist1 = artistRepo.save(new Artist("Pink Floyd", ".images/pinkFloyd.jpg"));
		Artist artist2 = artistRepo.save(new Artist("Elton John", ".images/EltonJohn.jpg"));
		Artist artist3 = artistRepo.save(new Artist("Backstreet Boys", ".images/backstreetBoys.jpg"));
		
		Album album1 = albumRepo.save(new Album("Animals", ".images/animals.jpg", "label1", artist1));
		Album album2 = albumRepo.save(new Album("Yellow Brick Road", ".images/yellowBrickRoad.jpg", "label2", artist2));
		Album album3 = albumRepo.save(new Album("Backstreet's Back", ".images/backstreetsBack.jpg", "label3", artist3));
		
		Song song1 = songRepo.save(new Song("Dogs", "17:10", "https://www.youtube.com/watch?v=PMmu9KiTo30", album1));
		Song song2 = songRepo.save(new Song("Pigs On The Wing", "3:24", "https://www.youtube.com/watch?v=KGSPUOaHYn4", album1));
		Song song3 = songRepo.save(new Song("Benny and Jets", "5:24", "https://www.youtube.com/watch?v=_8ch87hRnwQ", album2));
		Song song4 = songRepo.save(new Song("Yellow Brick Road", "3:14", "https://www.youtube.com/watch?v=DDOL7iY8kfo", album2));
		Song song5 = songRepo.save(new Song("Backstreet's Back", "6:00", "https://www.youtube.com/watch?v=6M6samPEMpM", album3));
		Song song6 = songRepo.save(new Song("Hey Mr. DJ", "4:24", "https://www.youtube.com/watch?v=wk067r43xtY", album3));
		
		Genre genre1 = genreRepo.save(new Genre("Rock"));
		Genre genre2 = genreRepo.save(new Genre("Classic"));
		Genre genre3 = genreRepo.save(new Genre("Polka"));
		
		genreRepo.save(genre1);
		genreRepo.save(genre2);
		genreRepo.save(genre3);
		
		artist1.addGenreToGenres(genre1);
		artist2.addGenreToGenres(genre2);
		artist3.addGenreToGenres(genre3);
		
		artistRepo.save(artist1);
		artistRepo.save(artist2);
		artistRepo.save(artist3);

		Comment comment1 = new Comment("Cool stuff");
		Comment comment2 = new Comment("Awful stuff");
		Comment comment3 = new Comment("Decent stuff");
		
		song1.addComment(comment1);
		song1.addComment(comment2);
		song2.addComment(comment3);
		
		songRepo.save(song1);
		
		Rating rating1 = new Rating(album1, 5);
		Rating rating2 = new Rating(album1, 4);
		Rating rating3 = new Rating(album1, 3);
		
		ratingRepo.save(rating1);
		ratingRepo.save(rating2);
		ratingRepo.save(rating3);
	}

}
