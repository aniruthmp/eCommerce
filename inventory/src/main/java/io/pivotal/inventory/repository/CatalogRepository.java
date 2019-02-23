package io.pivotal.inventory.repository;

import io.pivotal.inventory.domain.Catalog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CatalogRepository extends PagingAndSortingRepository<Catalog, Long> {
}
