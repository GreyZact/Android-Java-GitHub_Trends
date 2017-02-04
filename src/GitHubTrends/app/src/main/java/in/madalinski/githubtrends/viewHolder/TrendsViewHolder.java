package in.madalinski.githubtrends.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.madalinski.githubtrends.R;
import in.madalinski.githubtrends.RepoDetailActivity;

public class TrendsViewHolder extends RecyclerView.ViewHolder {
    //     private to public ???
    private TextView textViewTitle;
    private TextView textViewAutor;
    private TextView textViewWachers;
    private String user;
    private String repoName;
    private Context context;

    public TrendsViewHolder(View view, Context context) {
        super(view);
        textViewTitle = (TextView) view.findViewById(R.id.textViewTrendsRepoTitle);
        textViewAutor = (TextView) view.findViewById(R.id.textViewTrendsRepoAutor);
        textViewWachers = (TextView) view.findViewById(R.id.textViewTrendsWachers);
        this.context = context;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDetails();
            }
        });
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public void setTextViewTitle(String textViewTitle) {
        this.textViewTitle.setText(textViewTitle);
    }

    public void setTextViewAutor(String textViewAutor) {
        this.textViewAutor.setText(textViewAutor);
    }

    public void setTextViewWachers(String textViewWachers) {
        this.textViewWachers.setText(textViewWachers);
    }

    public void showDetails() {
        Intent intent = new Intent(context, RepoDetailActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("repo", repoName);
        context.startActivity(intent);
    }
}
