package com.example.joeribes.joeribes_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;


public class InputActivity extends AppCompatActivity {

    public Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    /*
    public void goToStory() {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("story", story);

        startActivity(intent);
        finish();
    }

    private void initializeStory() {
        try {
            InputStream is = getAssets().open("madlib0_simple.txt");
            story = new Story(is);

        } catch(IOException e){
            e.printStackTrace();
        }



    }
    */





}
