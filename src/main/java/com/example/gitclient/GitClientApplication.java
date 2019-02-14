package com.example.gitclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GitClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitClientApplication.class, args);
    }


    @GetMapping("/info/{user}/{repo}")
    public String info(@PathVariable("user") String user, @PathVariable("repo") String repo){
        return null;

    }
}

