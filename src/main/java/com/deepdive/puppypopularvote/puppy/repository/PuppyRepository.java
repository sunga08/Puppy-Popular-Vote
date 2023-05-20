package com.deepdive.puppypopularvote.puppy.repository;

import com.deepdive.puppypopularvote.puppy.entity.Puppy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PuppyRepository extends JpaRepository<Puppy, Long> {
    List<Puppy> findByName(@Param("name") String name);
}
