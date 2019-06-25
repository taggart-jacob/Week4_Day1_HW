package com.example.week4_day1_hw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week4_day1_hw.model.gitprofile.RepoObject;

import java.util.ArrayList;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<RepoObject> repoObjectArrayList;

    public RecyclerViewAdapter(ArrayList<RepoObject> repoObjectArrayList) {
        this.repoObjectArrayList = repoObjectArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repo_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        RepoObject repoObject = repoObjectArrayList.get(position);

        if (repoObject != null) {
            String repoName = repoObject.getName();
            String repoUserName = repoObject.getOwner().getLogin();
            String repoLanguage = repoObject.getLanguage();

            holder.setItemRepo(repoObject);

            holder.tvRepoName.setText(repoName);
            holder.tvRepoUser.setText(repoUserName);
            holder.tvRepoLanguage.setText(repoLanguage);
        }
    }

    public void addRepoObject(RepoObject repoObject){
        repoObjectArrayList.add(repoObject);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return repoObjectArrayList != null ? repoObjectArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRepoName;
        TextView tvRepoUser;
        TextView tvRepoLanguage;
        RepoObject itemRepo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRepoName = itemView.findViewById(R.id.tvRepoName);
            tvRepoUser = itemView.findViewById(R.id.tvRepoUser);
            tvRepoLanguage = itemView.findViewById(R.id.tvRepoLanguage);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Toast.makeText(v.getContext(), itemRepo.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setItemRepo(RepoObject itemRepo) {
            this.itemRepo = itemRepo;
        }
    }

}
