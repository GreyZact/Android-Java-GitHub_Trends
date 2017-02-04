package in.madalinski.githubtrends.libs;

import java.util.List;

import in.madalinski.githubtrends.model.GitHubRepo;

/**
 * Created by ishas on 04.02.2017.
 */

public interface GitHubTrendsCollectionListener {
    void onDownloaded(List<GitHubRepo> gitHubRepoList);
}
