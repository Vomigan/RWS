package com.example.rws;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rws.database.Word;
import com.example.rws.database.WordsDatabase;

public class AddWordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_words);
        final  EditText TextWord = findViewById(R.id.TVWord);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewWord(TextWord.getText().toString());
            }
        });
    }
    private void addNewWord(String YourWord){
        WordsDatabase db = WordsDatabase.getDbInstance(this.getApplicationContext());
        Word word = new Word();
        word.YourWord = YourWord;

        db.wordsDao().insertWords(word);
        finish();
    }
}