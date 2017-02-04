package in.madalinski.githubtrends.libs;

import in.madalinski.githubtrends.model.GitHubRepo;

/**
 * Created by ishas on 04.02.2017.
 */

public interface GitHubRepoDownloadedListener {
    void onDownloaded(GitHubRepo gitHubRepo);
}
