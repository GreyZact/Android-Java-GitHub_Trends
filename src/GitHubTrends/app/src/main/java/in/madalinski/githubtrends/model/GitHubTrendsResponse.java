package in.madalinski.githubtrends.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ishas on 03.02.2017.
 */

public class GitHubTrendsResponse {
    private Integer total_count;
    private Boolean incomplete_results;
    @SerializedName("items")
    private List<GitHubRepo> repoList;

    public Integer getTotal_count() {
        return total_count;
    }

    public Boolean getIncomplete_results() {
        return incomplete_results;
    }

    public List<GitHubRepo> getRepoList() {
        return repoList;
    }
}
