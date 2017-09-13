package com.example.joeribes.joeribes_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;


public class InputActivity extends AppCompatActivity {

    Story story;
    String hint;
    int wordCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        story = (Story) getIntent().getSerializableExtra("story");
        wordCounter();
        setHintWord();

    }

    public void setHintWord() {
        hint = story.getNextPlaceholder();
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setHint(hint);

        TextView hintTextPhrase = (TextView) findViewById(R.id.hintTextView);
        hintTextPhrase.setHint(" please type a/an " + hint);

    }




    public void fillInWord(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String word = editText.getText().toString();
        story.fillInPlaceholder(word);
        editText.setText("");
        wordCounter();
        setHintWord();

    }

    public void wordCounter() {
        wordCount = story.getPlaceholderRemainingCount();

        TextView madLib = (TextView) findViewById(R.id.wordCounterView);
        madLib.setHint(String.valueOf(wordCount) + " word(s) left");
    }



    public void goToStory(View view) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("story", story);

        startActivity(intent);
        finish();
    }








}
