package vitaliy.grab.doners.repository;


import vitaliy.grab.doners.model.Doner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DonerRepository extends CrudRepository<Doner, Long> {

    Page<Doner> findAll(Pageable pageable);
}
