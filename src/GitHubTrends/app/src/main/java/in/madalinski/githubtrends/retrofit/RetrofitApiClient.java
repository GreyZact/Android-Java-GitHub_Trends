package in.madalinski.githubtrends.retrofit;

import in.madalinski.githubtrends.model.GitHubTrendsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by ishas on 03.02.2017.
 */

public interface RetrofitApiClient {
    @GET("/repositories?q=since:daily&sort=stars&order=desc")
    Call<GitHubTrendsResponse> getTrendsDaily();

//    @GET("/repositories?q=since:weekly&sort=stars&order=desc")
//    Call<GitHubTrendsResponse> getTrendsWeekly();
//
//    @GET("/repositories?q=since:monthly&sort=stars&order=desc")
//    Call<GitHubTrendsResponse> getTrendsMonthly();
}
