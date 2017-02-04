package in.madalinski.githubtrends.libs;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import in.madalinski.githubtrends.model.GitHubRepo;
import in.madalinski.githubtrends.model.GitHubTrendsResponse;
import in.madalinski.githubtrends.retrofit.GitHubApiClient;
import in.madalinski.githubtrends.retrofit.GitHubApiClientFactory;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by ishas on 04.02.2017.
 */

public class AsyncTaskGitHubTrends extends AsyncTask<Void, Void, List<GitHubRepo>> {
    private GitHubApiClient gitHubApiClient;
    private GitHubTrendsCollectionListener gitHubTrendsCollectionListener;

    public AsyncTaskGitHubTrends(GitHubTrendsCollectionListener gitHubTrendsCollectionListener) {
        this.gitHubTrendsCollectionListener = gitHubTrendsCollectionListener;
        GitHubApiClientFactory gitHubApiClientFactory = new GitHubApiClientFactory();
        this.gitHubApiClient = gitHubApiClientFactory.create();
    }

    @Override
    protected List<GitHubRepo> doInBackground(Void... voids) {
        return getTrendsList();
    }

    @Override
    protected void onPostExecute(List<GitHubRepo> gitHubRepos) {
//        super.onPostExecute(gitHubRepos);
        gitHubTrendsCollectionListener.onDownloaded(gitHubRepos);
    }

    private List<GitHubRepo> getTrendsList() {
        Call<GitHubTrendsResponse> call = gitHubApiClient.getTrendsMonthly();
        Response<GitHubTrendsResponse> response;

        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if (response.isSuccessful()) {
            GitHubTrendsResponse gitHubTrendsResponse = response.body();
            return gitHubTrendsResponse.getRepoList();
        }

        return null;
    }
}
