package org.wecancodeit.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.albumcollection.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long>{

}
