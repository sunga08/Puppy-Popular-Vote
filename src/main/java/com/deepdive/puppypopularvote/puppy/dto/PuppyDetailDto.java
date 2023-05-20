package com.deepdive.puppypopularvote.puppy.dto;

import com.deepdive.puppypopularvote.puppy.entity.Puppy;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PuppyDetailDto {
    private Long id;
    private String name;
    private String imageUrl;
    private String simpleDescription;
    private String description;
    private int voteNum;

    public PuppyDetailDto(Puppy puppy){
        id = puppy.getId();
        name = puppy.getName();
        imageUrl = puppy.getImageUrl();
        simpleDescription = puppy.getSimpleDescription();
        description = puppy.getDescription();
        voteNum = puppy.getVoteNum();
    }
}
