package com.deepdive.puppypopularvote.puppy.repository;

import com.deepdive.puppypopularvote.puppy.entity.Puppy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PuppyRepository extends JpaRepository<Puppy, Long> {

    Optional<List<Puppy>> findAllBy();
    Optional<Puppy> findByName(@Param("name") String name);
}
