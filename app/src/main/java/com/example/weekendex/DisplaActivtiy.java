package com.example.weekendex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplaActivtiy extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displa_activtiy);
        imageView = findViewById(R.id.ssrIV);
        textView = findViewById(R.id.ssrTV);

        imageView.setImageResource(getIntent().getIntExtra("image_id",00));
        textView.setText(getIntent().getStringExtra("flower12"));
    }
}
