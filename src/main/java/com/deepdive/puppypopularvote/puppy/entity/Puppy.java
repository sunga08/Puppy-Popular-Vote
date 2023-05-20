package com.deepdive.puppypopularvote.puppy.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Puppy extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "puppy_id")
    private Long id;
    private String name;
    private String imageUrl;
    private String simpleDescription;
    private String description;
    private int voteNum;

    public Puppy(String name, String imageUrl, String simpleDescription, String description, int voteNum) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.simpleDescription = simpleDescription;
        this.description = description;
        this.voteNum = voteNum;
    }
}
