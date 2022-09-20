package com.tweetApp.comp2.model;

import com.tweetApp.comp2.DTO.Comment;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Tweet {

    @Id
    @GeneratedValue
    private int tweetId;
    private String username;
    private String tweetText;
    private String tweetDateTime;
    private Set<String> likes = new LinkedHashSet<>();
    private List<Comment> comments = new ArrayList<>();

}