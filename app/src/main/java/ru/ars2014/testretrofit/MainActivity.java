package ru.ars2014.testretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;
import ru.ars2014.testretrofit.adapters.PostAdapter;
import ru.ars2014.testretrofit.api.API;
import ru.ars2014.testretrofit.api.model.Post;

public class MainActivity extends AppCompatActivity {
    RecyclerView postsRV;
    PostAdapter postAdapter;

    @EverythingIsNonNull
    Callback<List<Post>> postsCallback = new Callback<List<Post>>() {
        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            postAdapter.setPosts(response.body());
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {
            Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_LONG).show();
            Log.e("MainActivity", t.getMessage());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsRV = findViewById(R.id.posts_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        postsRV.setLayoutManager(llm);

        postAdapter = new PostAdapter();
        postsRV.setAdapter(postAdapter);

        Call<List<Post>> call = API.postService.getAllPosts();
        call.enqueue(postsCallback);
    }
}