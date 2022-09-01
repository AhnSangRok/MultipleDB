package com.multidb.multipledb.repository;

import com.multidb.multipledb.Entity.test1;
import com.multidb.multipledb.replica.ReplicaRepository;
import com.multidb.multipledb.source.SourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestRepository {

    private final ReplicaRepository replicaRepository;
    private final SourceRepository sourceRepository;

    public List<test1> findAll(){
        return replicaRepository.findAll();
    }

    public test1 test1Save(test1 test1){
        return sourceRepository.save(test1);
    }
}
