package vitaliy.grab.doners.service;

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

    public Optional<Doner> findById(long donerId) {
        return donerRepository.findById(donerId);
    }

    public Doner save(Doner doner) {
        return donerRepository.save(doner);
    }

}
