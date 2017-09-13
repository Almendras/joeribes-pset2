package com.example.joeribes.joeribes_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SelectStoryActivity extends AppCompatActivity {

    Story story;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_story);

        story = (Story) getIntent().getSerializableExtra("story");
    }

    private void initializeStory(String madlibStory) {
        try {
            InputStream is = getAssets().open(madlibStory);
            story = new Story(is);

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // Selects the proper story and and goes to InputActivity
    public void goToStory(View view) {
        switch(view.getId()) {
            case R.id.madlib0:
                initializeStory("madlib0_simple.txt");
                break;

            case R.id.madlib1:
                initializeStory("madlib1_tarzan.txt");
                break;
            case R.id.madlib2:
                initializeStory("madlib2_university.txt");
                break;
            case R.id.madlib3:
                initializeStory("madlib3_clothes.txt");
                break;
            case R.id.madlib4:
                initializeStory("madlib4_dance.txt");
                break;
            case R.id.randomLib:
                pickRandomLib();
                break;

        }

        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra("story", story);

        startActivity(intent);
        finish();
    }

    // Picks a random Mad Lib Story
    public void pickRandomLib() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);

        switch (randomNumber) {
            case 0:
                initializeStory("madlib0_simple.txt");
                break;
            case 1:
                initializeStory("madlib1_tarzan.txt");
                break;
            case 2:
                initializeStory("madlib2_university.txt");
                break;
            case 3:
                initializeStory("madlib3_clothes.txt");
                break;
            case 4:
                initializeStory("madlib4_dance.txt");
                break;
        }
    }
}
