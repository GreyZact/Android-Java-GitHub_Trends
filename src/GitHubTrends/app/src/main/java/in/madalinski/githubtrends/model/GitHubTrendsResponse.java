package in.madalinski.githubtrends.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ishas on 03.02.2017.
 */

public class GitHubTrendsResponse {
    @SerializedName("total_count")
    private Long totalCount;
    @SerializedName("incomplete_results")
    private Boolean incompleteResults;
    @SerializedName("items")
    private List<GitHubRepo> repoList;

    public Long getTotalCount() {
        return totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public List<GitHubRepo> getRepoList() {
        return repoList;
    }
}
