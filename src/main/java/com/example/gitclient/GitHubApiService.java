package com.example.gitclient;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GitHubApiService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ContentsService contentsService;

    /**
     * 根据github账户和repo的名称返回repo对象
     * @param user
     * @param repoName
     * @return
     * @throws IOException
     */
    public Repository getRepository(String user, String repoName) throws IOException {
        return repositoryService.getRepository(user,repoName);
    }

    /**
     * 根据github账户和repo获得当前repo的文件内容信息
     * @param user
     * @param repoName
     */
    public List<RepositoryContents> getFileContents(String user,String repoName) throws IOException {
        Repository repository = getRepository(user, repoName);
        return getFileContents(repository,null);
    }

    /**
     * 递归遍历repo下所有的文件信息
     * @param repository
     * @param path
     * @return
     * @throws IOException
     */
    public List<RepositoryContents> getFileContents(Repository repository,String path) throws IOException {

        List<RepositoryContents> result = new ArrayList<>();
        List<RepositoryContents> target = contentsService.getContents(repository, path);




        for(RepositoryContents content:target){
            if(content.getType().equals("dir")){
                List<RepositoryContents> contents = getFileContents(repository, content.getPath());
                result.addAll(contents);
            }else if(content.getType().equals("file")){
                result.add(content);
            }
        }
        return result;
    }

}
