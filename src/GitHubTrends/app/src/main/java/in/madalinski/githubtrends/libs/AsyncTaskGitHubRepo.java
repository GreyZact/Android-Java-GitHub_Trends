package in.madalinski.githubtrends.libs;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import in.madalinski.githubtrends.model.GitHubRepo;
import in.madalinski.githubtrends.retrofit.GitHubApiClient;
import in.madalinski.githubtrends.retrofit.GitHubApiClientFactory;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by ishas on 04.02.2017.
 */

public class AsyncTaskGitHubRepo extends AsyncTask<Void, Void, GitHubRepo> {
    private GitHubApiClient gitHubApiClient;
    private GitHubRepoDownloadedListener gitHubRepoDownloadedListener;
    private String user;
    private String repoName;

    public AsyncTaskGitHubRepo(GitHubRepoDownloadedListener gitHubRepoDownloadedListener, String user, String repoName) {
        this.gitHubRepoDownloadedListener = gitHubRepoDownloadedListener;
        GitHubApiClientFactory gitHubApiClientFactory = new GitHubApiClientFactory();
        gitHubApiClient = gitHubApiClientFactory.create();
        this.user = user;
        this.repoName = repoName;
    }

    @Override
    protected GitHubRepo doInBackground(Void... voids) {
        return getRepo();
    }

    @Override
    protected void onPostExecute(GitHubRepo gitHubRepo) {
        gitHubRepoDownloadedListener.onDownloaded(gitHubRepo);
    }

    private GitHubRepo getRepo() {
        Call<GitHubRepo> call = gitHubApiClient.getRepo(user, repoName);
        Response<GitHubRepo> response;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if (response.isSuccessful()) {
            GitHubRepo gitHubRepo = response.body();
            return gitHubRepo;
        }

        return null;
    }
}
