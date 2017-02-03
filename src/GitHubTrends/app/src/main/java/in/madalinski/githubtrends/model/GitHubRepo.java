package in.madalinski.githubtrends.model;

/**
 * Created by ishas on 03.02.2017.
 */

public class GitHubRepo {
    private Integer id;
    private String name;
//    private GitHubRepoOwner owner;
    private String html_url;
    private String description;
    private String language;
    private Boolean has_issues;
    private Integer watchers;
    private Integer forks;
    private Integer open_issues;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public GitHubRepoOwner getOwner() {
//        return owner;
//    }

    public String getHtml_url() {
        return html_url;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getHas_issues() {
        return has_issues;
    }

    public Integer getWatchers() {
        return watchers;
    }

    public Integer getForks() {
        return forks;
    }

    public Integer getOpen_issues() {
        return open_issues;
    }
}
