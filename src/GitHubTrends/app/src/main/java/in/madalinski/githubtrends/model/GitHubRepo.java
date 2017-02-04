package in.madalinski.githubtrends.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ishas on 03.02.2017.
 */

public class GitHubRepo {
    private Long id;
    private String name;
    private GitHubRepoOwner owner;
    @SerializedName("html_url")
    private String htmlUrl;
    private String description;
    private String language;
    @SerializedName("has_issues")
    private Boolean hasIssues;
    private Long watchers;
    private Long forks;
    @SerializedName("open_issues")
    private Long openIssues;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GitHubRepoOwner getOwner() {
        return owner;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getHasIssues() {
        return hasIssues;
    }

    public Long getWatchers() {
        return watchers;
    }

    public Long getForks() {
        return forks;
    }

    public Long getOpenIssues() {
        return openIssues;
    }
}
