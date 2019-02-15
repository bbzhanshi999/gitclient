package com.example.gitclient;

import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GitClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitClientApplication.class, args);
    }

    @Bean
    public RepositoryService repositoryService(){
        return new RepositoryService();
    }

    @Bean
    public ContentsService contentsService(){
        return new ContentsService();
    }

    @Bean
    public CommitService commitService(){
        return new CommitService();
    }
}

