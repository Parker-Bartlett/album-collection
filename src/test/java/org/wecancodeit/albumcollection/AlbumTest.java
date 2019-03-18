package org.wecancodeit.albumcollection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.albumcollection.models.Album;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AlbumTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	AlbumRepository albumRepo;
	
	@Test
	public void shouldAddAndGetAlbum() {
	Album album = albumRepo.save(new Album("albumName", null, null, null));
	
	entityManager.persist(album);
	entityManager.flush();
	entityManager.clear();
	
	Long idToFind = 1L;
	Album albumFromDB = albumRepo.findById(idToFind).get();
	
	assertThat(albumFromDB.getAlbumTitle(), is("albumName"));
}}
