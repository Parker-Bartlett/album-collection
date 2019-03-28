package org.wecancodeit.albumcollection.controllerTests;
import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.albumcollection.models.Song;
import org.wecancodeit.albumcollection.repositories.AlbumRepository;
import org.wecancodeit.albumcollection.repositories.ArtistRepository;
import org.wecancodeit.albumcollection.repositories.SongRepository;
@RunWith(SpringRunner.class)
	
	public class SongMVCTest<Portfolio> {
	
	@Resource
    private MockMvc mvc;
    @MockBean
    private SongRepository songRepo;
    @MockBean
    private ArtistRepository artistRepo;
    @MockBean
    private AlbumRepository albumRepo;
    
    @Mock
    
    private Song song;
    
    
}
