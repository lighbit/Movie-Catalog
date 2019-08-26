package com.example.projectsubmissionpertama;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private HeroesAdapter adapter;
    private ArrayList<Heroes> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new HeroesAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private Heroes addItem() {
        heroes = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Heroes hero = new Heroes();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }

        adapter.setHeroes(heroes);

        Heroes hero = new Heroes();
        hero.getName();
        hero.getDescription();
        hero.getPhoto();
        return hero;
    }

    @Override
    public void onClick(View v) {
        ImageView imgphoto;
        TextView tvname, tvName;
        String name = addItem().getName();
        String desctiption = addItem().getDescription();
        int photo = addItem().getPhoto();

        Heroes hero = new Heroes();
        hero.setName(name);
        hero.setDescription(desctiption);
        hero.setPhoto(photo);

        imgphoto = v.findViewById(R.id.img_photo);
        tvname = v.findViewById(R.id.txt_name);
        tvName = v.findViewById(R.id.txt_description);
        imgphoto.setOnClickListener(this);
        tvname.setOnClickListener(this);
        tvName.setOnClickListener(this);

        switch (v.getId()) {
            case R.id.txt_description:
            case R.id.txt_name:
            case R.id.img_photo:
                Intent mIntent = new Intent(this, DetailFragment.class);
                mIntent.putExtra("key", (Serializable) hero);
                startActivity(mIntent);
                break;
        }
    }
}