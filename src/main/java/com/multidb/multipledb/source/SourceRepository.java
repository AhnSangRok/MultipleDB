package com.multidb.multipledb.source;

import com.multidb.multipledb.Entity.test1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<test1, Integer> {
}
