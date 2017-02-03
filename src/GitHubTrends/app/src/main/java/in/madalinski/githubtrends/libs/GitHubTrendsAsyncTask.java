package in.madalinski.githubtrends.libs;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import in.madalinski.githubtrends.model.GitHubRepo;
import in.madalinski.githubtrends.model.GitHubTrendsResponse;
import in.madalinski.githubtrends.retrofit.RetrofitApiClient;
import in.madalinski.githubtrends.retrofit.RetrofitApiClientFactory;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by ishas on 03.02.2017.
 */

public class GitHubTrendsAsyncTask extends AsyncTask<Void, Void, List<GitHubRepo>> {
    private RetrofitApiClient retrofitApiClient;
    private GitHubRepoCollectionListener gitHubRepoCollectionListener;

    public GitHubTrendsAsyncTask(GitHubRepoCollectionListener gitHubRepoCollectionListener) {
        this.gitHubRepoCollectionListener = gitHubRepoCollectionListener;
        this.retrofitApiClient = new RetrofitApiClientFactory().create();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<GitHubRepo> doInBackground(Void... params) {
        try {
            return getTrendsListDaily();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<GitHubRepo> gitHubRepos) {
        gitHubRepoCollectionListener.onDownload(gitHubRepos);
    }

    private List<GitHubRepo> getTrendsListDaily() throws IOException {
        Call<GitHubTrendsResponse> call = retrofitApiClient.getTrendsDaily();
        Response<GitHubTrendsResponse> response = call.execute();
        if(response.isSuccessful()){
            GitHubTrendsResponse gitHubTrendsResponse = response.body();
            return gitHubTrendsResponse.getRepoList();
        }
        return null;
    }
}
