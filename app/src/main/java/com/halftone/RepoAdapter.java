package com.halftone;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.halftone.movie.R;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<Repo> repoList;
    private Context context;

    public RepoAdapter(List<Repo> repos, Context context) {
        this.repoList = repos;
        this.context = context;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_single_item, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, final int position) {
        holder.repoName.setText(repoList.get(position).name);
        holder.repoName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProjectDetailActivity.class);
                intent.putExtra("repo", repoList.get(position));
                context.startActivity(intent);
            }
        });
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
