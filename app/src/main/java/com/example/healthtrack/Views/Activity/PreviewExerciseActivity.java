package com.example.healthtrack.Views.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.healthtrack.Models.SmallExercises;
import com.example.healthtrack.R;
import com.example.healthtrack.Views.Adapters.ContentAdapter;

import java.util.ArrayList;
import java.util.List;

public class PreviewExerciseActivity extends AppCompatActivity {

    private SmallExercises smallExercises;
    private List<String> listContent;
    private TextView title;
    private ImageView imageView, imgGoBack;
    private RecyclerView recyclerView;
    private ContentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_exercise);

        init();
        setupListeners();
    }

    void init() {
        listContent = new ArrayList<>();
        title = findViewById(R.id.Title_Preview);
        imageView = findViewById(R.id.image_preview);
        imgGoBack = findViewById(R.id.toolbar_preview_exercise);
        recyclerView = findViewById(R.id.recyclerview_item);

        Intent intent = getIntent();
        if (intent != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                smallExercises = intent.getSerializableExtra("SmallExercise", SmallExercises.class);
            } else {
                smallExercises = (SmallExercises) intent.getSerializableExtra("SmallExercise");
            }

            if (smallExercises != null) {
                title.setText(smallExercises.getTitleSmall());
                Glide.with(this)
                    .load(smallExercises.getExercisePicture())
                    .placeholder(R.drawable.exercise)
                    .error(R.drawable.exercise)
                    .into(imageView);

                listContent.addAll(smallExercises.getListContent());
                adapter = new ContentAdapter(this, listContent);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);
            }
        }
    }

    private void setupListeners() {
        imgGoBack.setOnClickListener(v -> finish());
    }
}