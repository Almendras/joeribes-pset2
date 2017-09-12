package com.example.joeribes.joeribes_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;


public class InputActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        story = (Story) getIntent().getSerializableExtra("story");

    }

    public void fillInWord(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String word = editText.getText().toString();

        story.fillInPlaceholder(word);

    }



    public void goToStory(View view) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("story", story);

        startActivity(intent);
        finish();
    }








}
