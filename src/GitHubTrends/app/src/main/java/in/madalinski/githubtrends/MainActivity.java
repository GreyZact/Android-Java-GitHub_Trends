package in.madalinski.githubtrends;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.madalinski.githubtrends.libs.AsyncTaskGitHubTrends;
import in.madalinski.githubtrends.libs.GitHubTrendsCollectionListener;
import in.madalinski.githubtrends.libs.TrendsAdapter;
import in.madalinski.githubtrends.model.GitHubRepo;

public class MainActivity extends AppCompatActivity implements GitHubTrendsCollectionListener, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGitHubRepoList);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        onRefresh();
    }

    @Override
    public void onDownloaded(List<GitHubRepo> gitHubRepoList) {
        if (gitHubRepoList == null) {
            Toast.makeText(this, "Connection error.", Toast.LENGTH_SHORT).show();
            return;
        }

        TrendsAdapter trendsAdapter = new TrendsAdapter(this, gitHubRepoList);

        recyclerView.setAdapter(trendsAdapter);
//        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void onRefresh() {
        new AsyncTaskGitHubTrends(this).execute();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void showDetails(GitHubRepo repo) {
        Intent intent = new Intent(this, RepoDetailActivity.class);
        intent.putExtra("user", repo.getOwner().getLogin());
        intent.putExtra("repo", repo.getName());
        startActivity(intent);
    }

}
