package com.example.joeribes.joeribes_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Go to SelectStoryActivity
    public void goToSelectStory(View view) {
        Intent intent = new Intent(this, SelectStoryActivity.class);
        startActivity(intent);
        finish();


    }
}
