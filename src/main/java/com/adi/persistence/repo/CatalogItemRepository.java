package com.adi.persistence.repo;

import com.adi.persistence.model.CatalogItem;
import org.springframework.data.repository.CrudRepository;

public interface CatalogItemRepository extends CrudRepository<CatalogItem, Long> {
}
