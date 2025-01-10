package com.praktikum.projectmanajer.View;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//import com.praktikum.projectmanajer.Adapter.CustomUnderlineSpan;
import com.praktikum.projectmanajer.R;
import com.praktikum.projectmanajer.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setContentWidthLine();


        String title = getIntent().getStringExtra("title");
        binding.titleProject.setText(title);



    }

    private void setContentWidthLine() {
        TextView titleProject = binding.titleProject;
        SpannableString content = new SpannableString("Food App");
        View lineView = binding.line;

        Paint paint = new Paint();
        paint.setTextSize(titleProject.getTextSize());
        float textWidth = paint.measureText(content.toString());

        ViewGroup.LayoutParams params = lineView.getLayoutParams();
        params.width = (int) textWidth + 80;
        lineView.setLayoutParams(params);
        binding.titleProject.setText(content);
    }
}