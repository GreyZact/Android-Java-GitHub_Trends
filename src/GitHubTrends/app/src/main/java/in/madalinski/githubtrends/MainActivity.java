package in.madalinski.githubtrends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.madalinski.githubtrends.libs.GitHubRepoCollectionListener;
import in.madalinski.githubtrends.libs.GitHubTrendsAsyncTask;
import in.madalinski.githubtrends.model.GitHubRepo;

public class MainActivity extends AppCompatActivity implements GitHubRepoCollectionListener {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        reloadData();
    }

    @Override
    public void onDownload(List<GitHubRepo> gitHubRepos) {
        if(gitHubRepos == null){
            Toast.makeText(this, "Connection error.", Toast.LENGTH_LONG).show();
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (GitHubRepo repo : gitHubRepos){
            stringBuilder.append(repo.getName()).append(repo.getDescription()).append(System.lineSeparator());
        }

        textView.setText(stringBuilder.toString());
    }

    private void reloadData() {
        new GitHubTrendsAsyncTask(this).execute();
    }
}
