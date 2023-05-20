package com.deepdive.puppypopularvote.puppy.api;

import com.deepdive.puppypopularvote.puppy.dto.PuppyDetailDto;
import com.deepdive.puppypopularvote.puppy.dto.PuppyListDto;
import com.deepdive.puppypopularvote.puppy.entity.Puppy;
import com.deepdive.puppypopularvote.puppy.repository.PuppyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PuppyController {

    private final PuppyRepository puppyRepository;

    @GetMapping("/puppy")
    public List<PuppyListDto> findAllPuppy(){
        List<Puppy> puppies = puppyRepository.findAll();
        List<PuppyListDto> puppyList = puppies.stream()
                .map(o -> new PuppyListDto(o))
                .collect(Collectors.toList());
        return puppyList;
    }

    @GetMapping("/puppy/{id}")
    public PuppyDetailDto findPuppy(@PathVariable("id") Long id){
        Puppy puppy = puppyRepository.findById(id).get();
        PuppyDetailDto puppyDetail = new PuppyDetailDto(puppy);
        return puppyDetail;
    }
}
