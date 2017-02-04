package in.madalinski.githubtrends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.madalinski.githubtrends.libs.AsyncTaskGitHubTrends;
import in.madalinski.githubtrends.libs.GitHubTrendsCollectionListener;
import in.madalinski.githubtrends.model.GitHubRepo;

public class RetrofitTestConnectionActivity extends AppCompatActivity implements GitHubTrendsCollectionListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_test_connection);
        textView = (TextView) findViewById(R.id.textViewRetrofitConnectionTest);

        refreshRepos();
    }

    @Override
    public void onDownloaded(List<GitHubRepo> gitHubRepoList) {
        if (gitHubRepoList == null) {
            Toast.makeText(this, "Connection error.", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder builder = new StringBuilder();

        for (GitHubRepo repo : gitHubRepoList) {
            builder.append(repo.getName()).append(System.lineSeparator());
        }

        textView.setText(builder.toString());
    }

    private void refreshRepos() {
        new AsyncTaskGitHubTrends(this).execute();
    }
}
