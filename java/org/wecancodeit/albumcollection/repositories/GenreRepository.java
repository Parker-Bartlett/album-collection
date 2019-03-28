package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.albumcollection.models.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long>{

}
