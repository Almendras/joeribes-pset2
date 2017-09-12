package com.example.joeribes.joeribes_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class StoryActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        Serializable story = (Story) intent.getSerializableExtra("story");

        TextView texView = (TextView) findViewById(R.id.textLib);
        texView.setText(story.toString());
    }
}
