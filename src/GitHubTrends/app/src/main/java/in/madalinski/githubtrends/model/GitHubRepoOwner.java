package in.madalinski.githubtrends.model;

/**
 * Created by ishas on 03.02.2017.
 */

public class GitHubRepoOwner {
    private String login;
    private Integer id;
    private String avatar_url;
    private String gravatar_id;
    private String html_url;

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getHtml_url() {
        return html_url;
    }
}
