package com.example.gitclient;

import org.eclipse.egit.github.core.CommitStatus;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitClientApplicationTests {

    @Autowired
    private ContentsService contentsService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private GitHubApiService gitHubApiService;

    @Autowired
    private CommitService commitService;

    @Test
    public void contextLoads() throws IOException {
        List<RepositoryContents> rcList = contentsService.getContents(repositoryService.getRepository("bbzhanshi999", "config-repo"), null);
        for(RepositoryContents repositoryContents:rcList){
            System.out.println(repositoryContents.getName());
        }
    }


    @Test
    public void getContents() throws IOException {
        List<RepositoryContents> rcList = gitHubApiService.getFileContents("bbzhanshi999","config-repo");
        for(RepositoryContents repositoryContents:rcList){
            System.out.println(repositoryContents.getName());
        }
    }

    @Test
    public void getCommits() throws IOException {
        List<RepositoryCommit> commits = commitService.getCommits(repositoryService.getRepository("bbzhanshi999", "ssmhr"));
        for(RepositoryCommit commit:commits){

        }
    }
}

