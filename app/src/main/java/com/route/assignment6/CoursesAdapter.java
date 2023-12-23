package com.route.assignment6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CoursesAdapter
        extends RecyclerView.Adapter<CoursesAdapter.MyViewHolder> {


    ArrayList<Integer> pictureArray;
    ArrayList<String> coursesNameArray;
    ArrayList<String> coursesDetailsArray;
    Context context;

    public CoursesAdapter( Context context , ArrayList<Integer> pictureArray, ArrayList<String> coursesNameArray,ArrayList<String> coursesDetailsArray) {
        this.pictureArray = pictureArray;
        this.coursesNameArray = coursesNameArray;
        this.coursesDetailsArray = coursesDetailsArray;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView coursePic;
        Button courseBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            coursePic = itemView.findViewById(R.id.coursePicture);
            courseBtn = itemView.findViewById(R.id.coureSelectBtn);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.home_screen_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.coursePic.setImageResource(pictureArray.get(position));
        holder.courseBtn.setText(coursesNameArray.get(position));
        holder.courseBtn.setOnClickListener(view->
        {
            Intent intent = new Intent(context , CourseDetailsActivity.class);
            intent.putExtra("picture",pictureArray.get(position));
            intent.putExtra("details",coursesDetailsArray.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pictureArray.size();
    }
}