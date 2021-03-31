package com.example.rws;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rws.database.Word;

import java.util.List;

public class WordsListAdapter extends RecyclerView.Adapter<WordsListAdapter.MyViewHolder> {
    private Context context;
    private List<Word> wordList;
    public  WordsListAdapter(Context context){
        this.context = context;
    }

    public void setUserList(List<Word> wordList){
        this.wordList = wordList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WordsListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsListAdapter.MyViewHolder holder, int position) {
        holder.textViewWord.setText(this.wordList.get(position).YourWord);

    }

    @Override
    public int getItemCount() {
      ///  if(wordList==null) return 0;
        return this.wordList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewWord;
        public MyViewHolder(View view){
            super(view);
            textViewWord = view.findViewById(R.id.textViewWord);
        }
    }
}
