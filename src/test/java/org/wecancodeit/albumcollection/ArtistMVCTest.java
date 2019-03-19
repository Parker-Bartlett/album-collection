package org.wecancodeit.albumcollection;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.albumcollection.controllers.ArtistController;
import org.wecancodeit.albumcollection.models.Artist;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ArtistController.class)
public class ArtistMVCTest<Portfolio> {
	
	@Resource
	private MockMvc mvc;

	@MockBean
	ArtistRepository artistRepo;
	
	@Mock
	private Artist artist;
	
	@Test
	public void shouldRouteToIndiviualArtistView() throws Exception {
		Long artistId = 1L;
		when(artistRepo.findById(artistId)).thenReturn(Optional.of(artist));
		mvc.perform(get("artist/1")).andExpect(view().name(is("singleartist")));
		
	}


}
