package com.example.uasakbif410120145;

/**
 * NIM : 10120145
 * Nama : Dimas Muhamad Bhakti
 * Kelas : IF-4
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uasakbif410120145.R;
import com.example.uasakbif410120145.Note;

import java.util.ArrayList;

public class NoteAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Note> noteList = new ArrayList<>();


    public void setNoteList(ArrayList<Note> noteList) {
        this.noteList = noteList;
    }
    public NoteAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int i) {
        return noteList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if(itemView ==null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_note, viewGroup,false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Note note = (Note) getItem(i);
        viewHolder.bind(note);
        return itemView;
    }

    private class ViewHolder {
        private TextView tvDate,tvTitle,tvCategory,tvContent;

        ViewHolder(View view) {
            tvDate = view.findViewById(R.id.textViewDate);
            tvTitle = view.findViewById(R.id.textViewTitle);
            tvCategory = view.findViewById(R.id.textViewCategory);
            tvContent = view.findViewById(R.id.textViewContent);
        }

        void bind(Note note) {
            tvDate.setText(note.getDate());
            tvTitle.setText(note.getTitle());
            tvCategory.setText(note.getCategory());
            tvContent.setText(note.getContent());
        }
    }
}