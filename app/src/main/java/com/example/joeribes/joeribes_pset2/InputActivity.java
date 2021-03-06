package com.example.joeribes.joeribes_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class InputActivity extends AppCompatActivity {

    Story story;
    String hint;
    int wordCount;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, SelectStoryActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        story = (Story) getIntent().getSerializableExtra("story");
        wordCounter();
        setHintWord();

    }

    // Loads the hint
    public void setHintWord() {
        hint = story.getNextPlaceholder();
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setHint(hint);

        TextView hintTextPhrase = (TextView) findViewById(R.id.hintTextView);
        hintTextPhrase.setHint(" please type a/an " + hint);
    }

    // Fills the word in the editText and loads the new hints
    public void fillInWord(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String word = editText.getText().toString();
        story.fillInPlaceholder(word);
        editText.setText("");
        wordCounter();
        setHintWord();

        if (story.isFilledIn()) {
            Intent intent = new Intent(this, StoryActivity.class);
            intent.putExtra("story", story);

            startActivity(intent);
            finish();
        }
    }

    // Displays the amount of word(s) which still need to be typed
    public void wordCounter() {
        wordCount = story.getPlaceholderRemainingCount();
        TextView madLib = (TextView) findViewById(R.id.wordCounterView);
        madLib.setHint(String.valueOf(wordCount) + " word(s) left");
    }
}
