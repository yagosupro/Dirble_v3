package com.example.bob_book.dirble_v3;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static Api Api;
    RecyclerView recyclerView;
    List<Model> posts;
    public List<Stream> streamList;
    final String token = "stations?token=5241cfa04a1afdd1a1248076de";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("testGit");

        Api = Controller.getApi();
        posts = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        PostsAdapter adapter = new PostsAdapter(posts);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(this);


        Api.getData(1, 20).enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }

        });
        startRadioService();



    }
    //public void startPlayerService(){
    //    Intent serviceIntent = new Intent(MainActivity.this, NotificationService.class);
//
  //      startService(serviceIntent);
    //}
    public void startRadioService(){
        Intent serviceIntent= new Intent(MainActivity.this,RadioService.class);
        startService(serviceIntent);
    }
    @Override
    public void onClick(View v) {
        //Intent intent = new Intent(this, Player.class);
        //startActivity(intent);
    }
}
