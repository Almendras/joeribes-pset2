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

        story = (Story) getIntent().getSerializableExtra("story");

        TextView madLib = (TextView) findViewById(R.id.textLib);
        madLib.setText(story.toString());


        //Intent intent = getIntent();
       // String receivedText = intent.getStringExtra("ourText");

        //TextView textView = (TextView) findViewById(R.id.textView);
        //textView.setText(receivedText);
    }
}
