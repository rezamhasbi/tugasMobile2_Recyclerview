package com.example.tugasmobile2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();
    CardViewHeroAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);
        list.addAll(HeroesData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CardViewHeroAdapter(list);
        rvHeroes.setAdapter(adapter);
        adapter.setOnItemClickCallback(new CardViewHeroAdapter.OnItemClickCallback(){

            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }
    private  void showSelectedHero(Hero hero){
        Intent intent = new Intent(MainActivity.this,Detail.class);
        intent.putExtra("nama",hero.getName());
        intent.putExtra("detail",hero.getDetail());
        intent.putExtra("foto",hero.getPhoto());
        startActivity(intent);
    }


}
