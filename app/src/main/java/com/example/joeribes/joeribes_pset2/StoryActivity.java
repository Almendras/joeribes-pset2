package com.example.joeribes.joeribes_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.io.Serializable;

public class StoryActivity extends AppCompatActivity {

    Story story;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, SelectStoryActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        story = (Story) getIntent().getSerializableExtra("story");

        TextView madLib = (TextView) findViewById(R.id.textLib);
        madLib.setText(story.toString());
    }
}
