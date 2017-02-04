package in.madalinski.githubtrends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.markdown4j.Markdown4jProcessor;

import java.io.IOException;
import java.util.List;

import in.madalinski.githubtrends.libs.AsyncTaskGitHubRepo;
import in.madalinski.githubtrends.libs.GitHubRepoDownloadedListener;
import in.madalinski.githubtrends.libs.GitHubTrendsCollectionListener;
import in.madalinski.githubtrends.model.GitHubRepo;

public class RepoDetailActivity extends AppCompatActivity implements GitHubRepoDownloadedListener {
    private TextView textViewRepoDetailTitle;
    private TextView textViewRepoDetailDescription;
    private ImageView imageViewRepoDetail;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_detail);

        textViewRepoDetailTitle = (TextView) findViewById(R.id.textViewRepoDetailTitle);
        textViewRepoDetailDescription = (TextView) findViewById(R.id.textViewRepoDetailDescription);
        imageViewRepoDetail = (ImageView) findViewById(R.id.imageViewRepoDetail);

        intent = getIntent();

        try {
            onLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDownloaded(GitHubRepo gitHubRepo) {
        if (gitHubRepo == null) {
            Toast.makeText(this, "Connection error.", Toast.LENGTH_SHORT).show();
            return;
        }

        textViewRepoDetailTitle.setText(gitHubRepo.getName());

        textViewRepoDetailDescription.setText(Html.fromHtml(
                markdownProcessor(gitHubRepo.getDescription())
        ));

        Picasso.with(getApplicationContext()).load(gitHubRepo.getOwner().getAvatarUrl()).into(imageViewRepoDetail);
    }

    private void onLoad() {
        new AsyncTaskGitHubRepo(this, intent.getStringExtra("user"), intent.getStringExtra("repo")).execute();
    }

    private String markdownProcessor(String input) {
        try {
            return new Markdown4jProcessor().process(input);
        } catch (Exception e) {
            e.printStackTrace();
            return input;
        }
    }
}
