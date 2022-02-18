package com.example.Assignment_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    Context c;
    String[] myNames;
    String[] myAddress;
    String[] myFaculty;
    String[] mySemester;


    public CustomAdapter(HomeActivity m, String[] names,String[] address,String[] faculty,String[] semester) {
        c = m;
        myNames = names;
        myAddress = address;
        myFaculty = faculty;
        mySemester = semester;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(c).inflate(R.layout.single_item,null);
        MyViewHolder viewHolder = new MyViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //dataset
        holder.tv.setText(myNames[position]+"       "+myAddress[position]+
                "     "+myFaculty[position]+"         "+mySemester[position]);
    }

    @Override
    public int getItemCount() {
        return myNames.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View convertView) {
            super(convertView);
            tv=convertView.findViewById(R.id.tv);
        }
    }
}
