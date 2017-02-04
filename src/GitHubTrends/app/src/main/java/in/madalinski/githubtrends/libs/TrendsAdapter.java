package in.madalinski.githubtrends.libs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.madalinski.githubtrends.R;
import in.madalinski.githubtrends.model.GitHubRepo;
import in.madalinski.githubtrends.viewHolder.TrendsViewHolder;

/**
 * Created by ishas on 04.02.2017.
 */

public class TrendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<GitHubRepo> gitHubRepoList;
    private LayoutInflater layoutInflater;

    public TrendsAdapter(Context context, List<GitHubRepo> gitHubRepoList) {
        this.context = context;
        this.gitHubRepoList = gitHubRepoList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.e("viewType = ", String.valueOf(viewType));
        View view = layoutInflater.inflate(R.layout.view_holder_trends, parent, false);
        return new TrendsViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Integer viewType = getItemViewType(position);

        TrendsViewHolder trendsViewHolder = (TrendsViewHolder) holder;
        GitHubRepo repo = (GitHubRepo) gitHubRepoList.get(position);

        trendsViewHolder.setTextViewTitle(repo.getName());
        trendsViewHolder.setTextViewAutor(repo.getOwner().getLogin());
        trendsViewHolder.setUser(repo.getOwner().getLogin());
        trendsViewHolder.setRepoName(repo.getName());
        trendsViewHolder.setTextViewWachers("Wachers: " + repo.getWatchers());
    }

    @Override
    public int getItemCount() {
        return gitHubRepoList.size();
    }
}
