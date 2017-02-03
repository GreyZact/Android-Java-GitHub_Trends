package in.madalinski.githubtrends.libs;

import java.util.List;

import in.madalinski.githubtrends.model.GitHubRepo;

/**
 * Created by ishas on 03.02.2017.
 */

public interface GitHubRepoCollectionListener {
    public void onDownload(List<GitHubRepo> gitHubRepos);
}
