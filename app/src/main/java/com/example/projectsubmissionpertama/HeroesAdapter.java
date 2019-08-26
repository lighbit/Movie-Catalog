package com.example.projectsubmissionpertama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroesAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Heroes> heroes;

    void setHeroes(ArrayList<Heroes> heroes) {
        this.heroes = heroes;
    }

    HeroesAdapter(Context context) {
        this.context = context;
        heroes = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_heroes, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Heroes hero = (Heroes) getItem(i);
        viewHolder.bind(hero);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Heroes hero) {
            txtName.setText(hero.getName());
            txtDescription.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}