package in.madalinski.githubtrends.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ishas on 03.02.2017.
 */

public class RetrofitApiClientFactory {
    public RetrofitApiClient create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RetrofitApiClient.class);
    }
}
