package com.cesarmando.website.adapter.restapi.GitHub;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

import java.io.IOException;
import java.util.List;

/**
 * Created by jarma on 4/11/2017.
 */
public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
