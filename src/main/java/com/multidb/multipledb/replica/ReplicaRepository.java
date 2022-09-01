package com.multidb.multipledb.replica;

import com.multidb.multipledb.Entity.test1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplicaRepository extends JpaRepository<test1, Integer> {
}
