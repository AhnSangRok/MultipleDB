package com.multidb.multipledb;

import com.multidb.multipledb.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    private final TestRepository repository;

    @PostMapping("/api/source/{name}")
    public ResponseEntity postSource(@PathVariable String name) {
        testService.postName(name);
        return new ResponseEntity("추가 성공", HttpStatus.OK);
    }
    @PostMapping("/api/replica/{name}")
    public ResponseEntity postReplica(@PathVariable String name) {
        testService.postNameR(name);
        return new ResponseEntity("추가 성공", HttpStatus.OK);
    }

    @GetMapping("/api/source")
    public ResponseEntity getSource() {
        return new ResponseEntity(repository.findAll(),HttpStatus.OK);
    }
    @GetMapping("/api/replica")
    public ResponseEntity getReplica() {
        return new ResponseEntity(repository.findAll(),HttpStatus.OK);
    }

}
