package com.tweetApp.comp2;

import com.tweetApp.comp2.Repository.UserRepo;
import com.tweetApp.comp2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.logging.Logger;

public class runner implements CommandLineRunner {

    private static final Logger LOG = Logger.getLogger(runner.class.getName());
    @Autowired
    private UserRepo u_repo;

    @Override
    public void run(String... args) throws Exception {

        u_repo.deleteAll();

        u_repo.save(new User(0,"hapi@gmail.com","hari","piya",07-05-1999,"female","password","password",0));
        u_repo.save(new User(1,"hapi@gmail.com","hari","piya",07-05-1999,"female","password","password",0));

        u_repo.findAll().forEach((country) -> {
            LOG.info("{}"+ country);
        });
    }
}
