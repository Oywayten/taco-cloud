package vitaliy.grab.doners.service;

import vitaliy.grab.doners.model.Doner;
import vitaliy.grab.doners.repository.DonerRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DonerService {

    private final DonerRepository donerRepository;

    public void save(Doner doner) {
        donerRepository.save(doner);
    }

}
