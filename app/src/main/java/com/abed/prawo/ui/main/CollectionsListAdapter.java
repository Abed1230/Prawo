package com.abed.prawo.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abed.prawo.R;
import com.abed.prawo.data.models.Collection;
import com.abed.prawo.ui.practice.PracticeActivity;
import com.bumptech.glide.Glide;

import java.util.List;

class CollectionsListAdapter extends RecyclerView.Adapter<CollectionsListAdapter.ViewHolder> {
    private Context context;
    private List<Collection> collections;

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imv;
        TextView tv;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.imv);
            tv = itemView.findViewById(R.id.tv);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, PracticeActivity.class);
            intent.putExtra(PracticeActivity.KEY_COLLECTION_ID, collections.get(getAdapterPosition()).getId());
            context.startActivity(intent);
        }
    }

    public CollectionsListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.collections_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(collections.get(position).getImageUrl())
                .into(holder.imv);

        String text = collections.get(position).getName();
        holder.tv.setText(text);
    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    void setData(List<Collection> collections) {
        this.collections = collections;
    }
}