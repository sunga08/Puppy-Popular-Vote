package com.deepdive.puppypopularvote.puppy.dto;

import com.deepdive.puppypopularvote.puppy.entity.Puppy;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PuppyListDto {

    private Long id;
    private String name;
    private String imageUrl;
    private String simpleDescription;
    private int voteNum;

    public PuppyListDto(Puppy puppy) {
        id = puppy.getId();
        name = puppy.getName();
        imageUrl = puppy.getImageUrl();
        simpleDescription = puppy.getSimpleDescription();
        voteNum = puppy.getVoteNum();
    }
}
