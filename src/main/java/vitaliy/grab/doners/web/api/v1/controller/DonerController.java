package vitaliy.grab.doners.web.api.v1.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitaliy.grab.doners.model.Doner;
import vitaliy.grab.doners.web.api.v1.service.DonerService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/doners", produces = "application/json")
@AllArgsConstructor
public class DonerController {

    private static final int PAGE_NUMBER = 0;
    private static final int PAGE_SIZE = 12;
    private static final String CREATED_AT = "createdAt";
    private final DonerService donerService;

    @GetMapping(params = "recent")
    public Iterable<Doner> findRecentDoners() {
        PageRequest page = PageRequest.of(PAGE_NUMBER, PAGE_SIZE, Sort.by(CREATED_AT).descending());
        return donerService.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doner> findDonerById(@PathVariable("id") long id) {
        Optional<Doner> optionalDoner = donerService.findById(id);
        return optionalDoner.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Doner postDoner(@RequestBody Doner doner) {
        return donerService.save(doner);
    }
}
