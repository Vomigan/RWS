package com.example.rws.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordsDao {
    @Query("SELECT * FROM word")
    List<Word> getAllWords();
    @Insert
    void insertWords(Word... words);
    @Delete
    void delete(Word word);

}
