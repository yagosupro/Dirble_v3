package com.example.bob_book.dirble_v3;

import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by bob-book on 07.09.2017.
 */

public interface Api {
    @GET("stations?token=5241cfa04a1afdd1a1248076de")

    Call<List<Model>> getData(@Query("page") int number_page, @Query("per_page") int count_per_page);

    @GET("stations?token=5241cfa04a1afdd1a1248076de")

    Call<List<Stream>> getHueData();


}
