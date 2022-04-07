package ru.ars2014.testretrofit.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.ars2014.testretrofit.api.model.Post;

public interface PostService {
    @GET("/posts")
    Call<List<Post>> getAllPosts();
}
