package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.albumcollection.models.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

}
