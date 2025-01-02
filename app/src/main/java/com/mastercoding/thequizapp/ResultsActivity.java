package com.mastercoding.thequizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.mastercoding.thequizapp.databinding.ActivityMainBinding;
import com.mastercoding.thequizapp.databinding.ActivityResultsBinding;

public class ResultsActivity extends AppCompatActivity {

    ActivityResultsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_results
        );

        binding.txtAnswer.setText(
                "Your Score is: "+MainActivity.result+"/"+MainActivity.totalQuestions);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
}