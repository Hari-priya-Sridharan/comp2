package com.tweetApp.comp2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "customSequences")
@Setter
@Getter
public class SequenceGenerator {
    @Id
    private String id;
    private int seq;
}
