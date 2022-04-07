package ru.ars2014.testretrofit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ru.ars2014.testretrofit.R;
import ru.ars2014.testretrofit.api.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView postIdTV;
        private final TextView userIdTV;
        private final TextView titleTV;
        private final TextView bodyTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postIdTV = itemView.findViewById(R.id.post_id);
            userIdTV = itemView.findViewById(R.id.user_id);
            titleTV = itemView.findViewById(R.id.post_title);
            bodyTV = itemView.findViewById(R.id.post_body);
        }

        public TextView getPostIdTV() {
            return postIdTV;
        }

        public TextView getUserIdTV() {
            return userIdTV;
        }

        public TextView getTitleTV() {
            return titleTV;
        }

        public TextView getBodyTV() {
            return bodyTV;
        }
    }

    private List<Post> posts;

    public PostAdapter() {
        this.posts = new ArrayList<>();
    }

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.getPostIdTV().setText(String.format(Locale.getDefault(), "%d", post.id));
        holder.getUserIdTV().setText(String.format(Locale.getDefault(), "%d", post.userId));
        holder.getTitleTV().setText(post.title);
        holder.getBodyTV().setText(post.body);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
