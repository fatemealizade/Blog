package com.example.blog.data;

import com.example.blog.models.Post;
import com.example.blog.networking.ApiClient;
import com.google.gson.Gson;

public class DataHandler {

    public Post[] getAllPosts() {
        ApiClient apiClient = new ApiClient();
        String responseStr = apiClient.getAllPosts();

        Gson gson = new Gson();
        return gson.fromJson(responseStr, Post[].class);
    }

}
