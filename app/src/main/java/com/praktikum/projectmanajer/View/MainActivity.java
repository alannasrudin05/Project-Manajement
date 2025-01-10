package com.praktikum.projectmanajer.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.praktikum.projectmanajer.Adapter.OngoingAdapter;
import com.praktikum.projectmanajer.Model.OngoingModel;
import com.praktikum.projectmanajer.R;
import com.praktikum.projectmanajer.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView.Adapter adapterOngoing;
    private String intentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();
        bottomNavigationInit();
        initName();


        
    }

    private void initName() {
        Intent intent = getIntent();
        intentName = intent.getStringExtra("name");
        binding.nama.setText("Hi, "+intentName);
    }


    private void bottomNavigationInit() {

        binding.profileBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ProfileActivity.class);
            i.putExtra("name", intentName);
            startActivity(i);
        });
    }


    private void initRecyclerView() {
        ArrayList<OngoingModel> items=new ArrayList<>();
        items.add(new OngoingModel("Food App", "January 10, 2025", 50, "ongoing1"));
        items.add(new OngoingModel("AI Recoding", "February 5, 2025", 60, "ongoing2"));
        items.add(new OngoingModel("Weather App", "March 12, 2025", 25, "ongoing3"));
        items.add(new OngoingModel("E-Book App", "April 20, 2025", 80, "ongoing4"));
        items.add(new OngoingModel("Fitness Tracker", "May 15, 2025", 45, "ongoing1"));
        items.add(new OngoingModel("Travel Planner", "June 1, 2025", 20, "ongoing2"));
        items.add(new OngoingModel("Online Marketplace", "July 8, 2025", 75, "ongoing3"));
        items.add(new OngoingModel("Chat Application", "August 18, 2025", 90, "ongoing4"));
        items.add(new OngoingModel("Recipe Finder", "September 25, 2025", 35, "ongoing1"));
        items.add(new OngoingModel("Expense Manager", "October 30, 2025", 55, "ongoing2"));
        binding.viewOngoing.setLayoutManager(new GridLayoutManager( this,  2));
//        adapterOngoing=new OngoingAdapter(items);
        adapterOngoing = new OngoingAdapter(items, ongoingModel -> {
            // Arahkan ke DetailActivity dengan membawa data
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("title", ongoingModel.getTitle());
//            intent.putExtra("status", ongoingModel.getStatus());
            startActivity(intent);
        });
        binding.viewOngoing.setAdapter(adapterOngoing);
    }
}