package in.madalinski.githubtrends.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ishas on 03.02.2017.
 */

public class GitHubRepoOwner {
    private String login;
    private Long id;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("gravatar_id")
    private String gravatarId;
    @SerializedName("html_url")
    private String htmlUrl;

    public String getLogin() {
        return login;
    }

    public Long getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
}
