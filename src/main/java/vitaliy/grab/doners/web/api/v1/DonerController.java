package vitaliy.grab.doners.web.api.v1;

import vitaliy.grab.doners.model.Doner;
import vitaliy.grab.doners.repository.DonerRepository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/doners", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
public class DonerController {

    private static final int PAGE_NUMBER = 0;
    private static final int PAGE_SIZE = 12;
    private static final String CREATED_AT = "createdAt";
    private final DonerRepository repository;

    @GetMapping(params = "recent")
    public Iterable<Doner> recentDoners() {
        PageRequest page = PageRequest.of(PAGE_NUMBER, PAGE_SIZE, Sort.by(CREATED_AT).descending());
        return repository.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doner> donerById(@PathVariable("id") Long id) {
        Optional<Doner> optionalDoner = repository.findById(id);
        return optionalDoner.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
