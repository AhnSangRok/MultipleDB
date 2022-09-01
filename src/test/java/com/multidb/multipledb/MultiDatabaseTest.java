package com.multidb.multipledb;

import com.multidb.multipledb.Entity.test1;
import com.multidb.multipledb.replica.ReplicaRepository;
import com.multidb.multipledb.source.SourceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MultiDatabaseTest {
    @Autowired
    SourceRepository sourceRepository;

    @Autowired
    ReplicaRepository replicaRepository;

    @Test
    public void insertTest(){
        test1 test = new test1();
        test.setId(12);
        test.setName("king");

        sourceRepository.save(test);
    }
    @Test
    public void insertReplica(){
        test1 test = new test1();
        test.setId(12);
        test.setName("king");
        replicaRepository.save(test);
    }
}
