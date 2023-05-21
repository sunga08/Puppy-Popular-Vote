package com.deepdive.puppypopularvote.puppy.service;

import com.deepdive.puppypopularvote.global.error.CustomException;
import com.deepdive.puppypopularvote.global.error.ErrorCode;
import com.deepdive.puppypopularvote.puppy.dto.PuppyDetailDto;
import com.deepdive.puppypopularvote.puppy.dto.PuppyListDto;
import com.deepdive.puppypopularvote.puppy.entity.Puppy;
import com.deepdive.puppypopularvote.puppy.repository.PuppyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PuppyService {

    @Autowired
    private PuppyRepository puppyRepository;

    public List<PuppyListDto> findAllPuppy() {
        List<Puppy> puppies = puppyRepository.findAllBy().orElseThrow(
                () -> new CustomException(ErrorCode.INTERNAL_SERVER_ERROR));

        List<PuppyListDto> puppyList = puppies.stream()
                .map(o -> new PuppyListDto(o))
                .collect(Collectors.toList());

        return puppyList;
    }

    public PuppyDetailDto findPuppy(Long id){
        Puppy puppy = puppyRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.BAD_CREDENTIALS)
        );
        PuppyDetailDto puppyDetail = new PuppyDetailDto(puppy);
        return puppyDetail;
    }


}
