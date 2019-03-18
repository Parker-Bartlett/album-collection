package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.albumcollection.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{

}
