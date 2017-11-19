package com.halftone;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.halftone.movie.R;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<Repo> repoList;

    public RepoAdapter(List<Repo> repos) {
        this.repoList = repos;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_single_item, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.repoName.setText(repoList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView repoName;

        public RepoViewHolder(View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.tv_repo_name);
        }
    }
}
