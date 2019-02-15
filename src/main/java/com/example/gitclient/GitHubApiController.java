package com.example.gitclient;

import org.eclipse.egit.github.core.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GitHubApiController {
    @Autowired
    GitHubApiService gitHubApiService;

    @GetMapping("/info/{user}/{repo}")
    public Repository info(@PathVariable("user") String user, @PathVariable("repo") String repoName) throws IOException {
        return gitHubApiService.getRepository(user, repoName);
    }

}
