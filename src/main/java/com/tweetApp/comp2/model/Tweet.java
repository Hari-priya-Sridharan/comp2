package com.tweetApp.comp2.model;

import com.tweetApp.comp2.DTO.Comment;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Tweet {

    @Id
    @GeneratedValue
    private String tweetId;
    private String username;
    private String tweetText;
    private String tweetDateTime;
    private List<String> likes = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

}