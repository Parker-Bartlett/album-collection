package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.albumcollection.models.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {

}
