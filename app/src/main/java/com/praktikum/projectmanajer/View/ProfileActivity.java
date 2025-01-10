package com.praktikum.projectmanajer.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.praktikum.projectmanajer.Adapter.ArchiveAdapter;
import com.praktikum.projectmanajer.Adapter.MyTeamAdapter;
import com.praktikum.projectmanajer.Model.TeamModel;
import com.praktikum.projectmanajer.R;
import com.praktikum.projectmanajer.databinding.ActivityProfileBinding;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;
    private RecyclerView.Adapter adapterArchive;
    private RecyclerView.Adapter adapterTeam;
    private String intentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerViewArchive();
        initRecyclerViewMyTeam();
        initName();

    }

    private void initName() {
        Intent intent = getIntent();
        intentName = intent.getStringExtra("name");
        binding.name.setText(intentName);
    }

    private void initRecyclerViewMyTeam() {
        ArrayList<TeamModel> items = new ArrayList<>();
        items.add(new TeamModel("Food App Application", "Project in Progress"));
        items.add(new TeamModel("AI Python", "Completed"));
        items.add(new TeamModel("Weather App Backend", "Project in Progress"));
        items.add(new TeamModel("Kotlin developers", "Completed"));
        binding.viewTeam.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterTeam = new MyTeamAdapter(items);
        binding.viewTeam.setAdapter(adapterTeam);
    }

    private void initRecyclerViewArchive() {
        ArrayList<String> items=new ArrayList<>();
        items.add("UI/UX ScreenShot");
        items.add("Kotlin Source Code");
        items.add("Source Codes");
        binding.viewArchive.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterArchive=new ArchiveAdapter(items);
        binding.viewArchive.setAdapter(adapterArchive);
    }
}