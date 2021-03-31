package com.example.rws.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "YourWord")
    public String YourWord;
}
