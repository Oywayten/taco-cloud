package vitaliy.grab.doners.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.Doner;
import vitaliy.grab.doners.repository.DonerRepository;

@Service
@AllArgsConstructor
public class DonerService {

    private final DonerRepository donerRepository;

    public void save(Doner doner) {
        donerRepository.save(doner);
    }

}
