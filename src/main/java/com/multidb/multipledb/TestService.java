package com.multidb.multipledb;

import com.multidb.multipledb.Entity.test1;
import com.multidb.multipledb.replica.ReplicaRepository;
import com.multidb.multipledb.source.SourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final SourceRepository sourceRepository;
    private final ReplicaRepository replicaRepository;
    public void postName(String name) {

        test1 test = new test1(name);
        sourceRepository.save(test);

    }

    public void postNameR(String name) {
        test1 test = new test1(name);
        replicaRepository.save(test);

    }
}
