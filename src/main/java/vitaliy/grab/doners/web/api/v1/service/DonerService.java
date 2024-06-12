package vitaliy.grab.doners.web.api.v1.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.Doner;
import vitaliy.grab.doners.repository.DonerRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DonerService {

    private final DonerRepository donerRepository;

    public Page<Doner> findAll(Pageable pageable) {
        return donerRepository.findAll(pageable);
    }

    public Optional<Doner> findById(long id) {
        return donerRepository.findById(id);
    }

    public void save(Doner doner) {
        donerRepository.save(doner);
    }

}
