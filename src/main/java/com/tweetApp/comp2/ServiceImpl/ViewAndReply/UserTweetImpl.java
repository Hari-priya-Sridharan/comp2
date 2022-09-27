package com.tweetApp.comp2.ServiceImpl.ViewAndReply;

import com.tweetApp.comp2.Controller.RegisterAndLogin.regController;
import com.tweetApp.comp2.DTO.Comment;
import com.tweetApp.comp2.Exceptions.ErrorOccurred;
import com.tweetApp.comp2.Exceptions.UserNotFoundException;
import com.tweetApp.comp2.Repository.TweetRepo;
import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.Tweet;
import com.tweetApp.comp2.service.ViewAndReply.UserTweetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserTweetImpl implements UserTweetService {
    @Autowired
    TweetRepo tRepo;
    @Autowired
    UserRepo uRepo;
    private static final Logger LOG = LogManager.getLogger(regController.class.getName());
    @Override
    public ResponseEntity<?> getUserTweets(String username) {
        try{
            LOG.info("Fetching all user tweets");
            if( uRepo.findByEmail(username)==null) {
                throw new UserNotFoundException("Username not found");
            }
            List<Tweet> tweets= tRepo.findAllByUsername(username);
            if(tweets.size()>0){
                LOG.info("Fetched User Tweets :",tweets);
                return new ResponseEntity<>(tweets, HttpStatus.OK);
            }
            else{
                LOG.info("Fetched list of tweets is null");
                return new ResponseEntity<>( HttpStatus.OK);
            }
        }
        catch(UserNotFoundException e){
            throw e;
        }
        catch (Exception e){
            throw new ErrorOccurred("fetching all the Users\n"+e);
        }
    }

    @Override
    public ResponseEntity<String> postTweet(Tweet tweet) {
        try {
            String username = tweet.getUsername();
            if( uRepo.findByEmail(username)==null) {
                throw new UserNotFoundException("Username not found");
            }
            LOG.info("Posting the tweet as {}", username);
            tRepo.save(tweet);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }
        catch(UserNotFoundException e){
            throw e;
        }
        catch (ErrorOccurred e){
            throw e;
        }
        catch (Exception e) {
            LOG.error("Posting the tweet failed", tweet.getUsername());
            throw new ErrorOccurred(" posting the tweet.");
        }
    }

    @Override
    public ResponseEntity<String> updateTweet(Tweet tweet) {
       try{
           if( uRepo.findByEmail(tweet.getUsername())==null) {
               throw new UserNotFoundException("Username not found");
           }
           Tweet t=tRepo.findByTweetId(tweet.getTweetId());
           if(t==null){
               throw new ErrorOccurred("fetching the tweet from DB");
           }
           t.setTweetText(tweet.getTweetText());
           tRepo.save(t);
           LOG.info("Tweet updated");
           return new ResponseEntity<>( HttpStatus.OK);
       }
       catch(UserNotFoundException e){
           throw e;
       }
       catch (ErrorOccurred e){
           throw e;
       }
       catch(Exception e){
           LOG.error("Updating the tweet failed", tweet.getUsername());
           throw new ErrorOccurred(" updating the tweet.");
       }
    }

    @Override
    public ResponseEntity<String> deleteTweet(String username,int tweetId) {
        try{
            if( uRepo.findByEmail(username)==null) {
                throw new UserNotFoundException("Username not found");
            }
            Tweet t=tRepo.findByTweetId(tweetId);
            if(t==null){
                throw new ErrorOccurred("fetching the tweet from DB");
            }
            tRepo.deleteByTweetId(tweetId);
            LOG.info("Tweet Deleted");
            return new ResponseEntity<>( HttpStatus.OK);
        }
        catch(UserNotFoundException e){
            throw e;
        }
        catch (ErrorOccurred e){
            throw e;
        }
        catch (Exception e){
            LOG.error("Deleting the tweet failed");
            throw new ErrorOccurred(" deleting the tweet");
        }

    }

    @Override
    public ResponseEntity<String> replyTweet(String username, int tweetId, Comment reply) {
        try{
            if( uRepo.findByEmail(username)==null) {
                throw new UserNotFoundException("Username not found");
            }
            Tweet t=tRepo.findByTweetId(tweetId);
            if(t==null){
                throw new ErrorOccurred("fetching the tweet from DB");
            }
            List<Comment> comments=t.getComments();
            comments.add(reply);
            LOG.info("{} commented on {}'s tweet",username,t.getUsername());
            t.setComments(comments);
            tRepo.save(t);
            LOG.info("Comment recorded successfully");
            return new ResponseEntity<>( HttpStatus.OK);
        }
        catch (ErrorOccurred e){
            throw e;
        }
        catch (Exception e){
            LOG.error("Commenting on the tweet failed");
            throw new ErrorOccurred(" commenting on the tweet");
        }
    }

    @Override
    public ResponseEntity<?> fetchTweets(int tweetID) {
        try{
            Tweet tweet=tRepo.findByTweetId(tweetID);

            return new ResponseEntity<>( tweet,HttpStatus.OK);
        }
        catch(Exception e){
            LOG.error("Fetching tweet failed");
            throw new ErrorOccurred(" fetching the tweet.");
        }
    }

    @Override
    public ResponseEntity<String> likeTweet(String username, int tweetId) {
        try{
            if( uRepo.findByEmail(username)==null) {
                throw new UserNotFoundException("Username not found");
            }
            Tweet t=tRepo.findByTweetId(tweetId);
            if(t==null){
                throw new ErrorOccurred("fetching the tweet from DB");
            }
            Set<String> likes=t.getLikes();
            likes.add(username);
            LOG.info("{} liked {}'s tweet",username,t.getUsername());
            t.setLikes(likes);
            tRepo.save(t);
            LOG.info("Like recorded successfully");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (ErrorOccurred e){
            throw e;
        }
        catch (Exception e){
            LOG.error("Liking the tweet failed");
            throw new ErrorOccurred(" liking the tweet");
        }
    }
}
