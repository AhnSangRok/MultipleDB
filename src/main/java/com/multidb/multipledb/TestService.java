package com.multidb.multipledb;

import com.multidb.multipledb.Entity.test1;
import com.multidb.multipledb.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository repository;
    public void postName(String name) {
        test1 test = new test1(name);
        repository.test1Save(test);

    }

    public void postNameR(String name) {
        test1 test = new test1(name);
        repository.test1Save(test);

    }
}
