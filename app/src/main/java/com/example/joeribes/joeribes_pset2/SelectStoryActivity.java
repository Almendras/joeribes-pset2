package com.example.joeribes.joeribes_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;

public class SelectStoryActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_story);

        story = (Story) getIntent().getSerializableExtra("story");


    }

    private void initializeStory() {
        try {
            InputStream is = getAssets().open("madlib0_simple.txt");
            story = new Story(is);

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void goToStory(View view) {
        initializeStory();
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra("story", story);

        startActivity(intent);
        finish();
    }
}
