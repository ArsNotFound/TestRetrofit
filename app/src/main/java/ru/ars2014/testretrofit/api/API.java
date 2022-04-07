package ru.ars2014.testretrofit.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    private API() {
    }

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final PostService postService = retrofit.create(PostService.class);
}
