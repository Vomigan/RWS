package com.example.rws;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View.OnClickListener;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import com.example.rws.database.Word;
import com.example.rws.database.WordsDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private WordsListAdapter wordsListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(this);
        initRecyclerView();
       // loadWordsList();
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddWordsActivity.class);
        startActivityForResult( intent, 1);
    }
    private void initRecyclerView(){
        RecyclerView recyclerView =findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        wordsListAdapter = new WordsListAdapter(this);
        recyclerView.setAdapter(wordsListAdapter);
    }
    private void loadWordsList(){
        WordsDatabase db = WordsDatabase.getDbInstance(this.getApplicationContext());
        List<Word> wordList = db.wordsDao().getAllWords();
        wordsListAdapter.setUserList(wordList);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            loadWordsList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}