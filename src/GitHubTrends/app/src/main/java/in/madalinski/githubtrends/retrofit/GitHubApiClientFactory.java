package in.madalinski.githubtrends.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ishas on 04.02.2017.
 */

public class GitHubApiClientFactory {
    //    return Client Interface NOT ClientFactory Class
    public GitHubApiClient create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(GitHubApiClient.class);
    }
}
