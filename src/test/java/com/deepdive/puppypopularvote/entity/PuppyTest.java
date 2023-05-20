package com.deepdive.puppypopularvote.entity;

import com.deepdive.puppypopularvote.puppy.entity.Puppy;
import com.deepdive.puppypopularvote.puppy.repository.PuppyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class PuppyTest {

    @Autowired
    PuppyRepository puppyRepository;

    @Test
    public void savePuppy(){
        Puppy puppy1 = new Puppy("뚱이", "image_url", "조용한 성격이에요. 대답을 잘 해요!", "description", 0);
        Puppy puppy2 = new Puppy("코코", "image_url", "깨발랄하고 온순한 성격이에요.", "description", 0);
        Puppy puppy3 = new Puppy("누리", "image_url", "애교가 많은 성격이에요.", "description", 0);
        Puppy puppy4 = new Puppy("사랑이", "image_url", "귀엽고 사랑스러운 성격이에요.", "description", 0);
        Puppy puppy5 = new Puppy("뭉치", "image_url", "사고치는 것을 좋아하는 성격이에요.", "description", 0);

        puppyRepository.save(puppy1);
        puppyRepository.save(puppy2);
        puppyRepository.save(puppy3);
        puppyRepository.save(puppy4);
        puppyRepository.save(puppy5);

        List<Puppy> puppies = puppyRepository.findAll();

        for (Puppy pup : puppies) {
            System.out.println(pup.getName());
        }

    }

    @Test
    public void findPuppy(){
        List<Puppy> list = puppyRepository.findByName("코코");
        Puppy puppy = list.get(0);

        System.out.println(puppy.getName());

    }
}
