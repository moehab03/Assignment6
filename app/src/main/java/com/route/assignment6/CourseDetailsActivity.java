package com.route.assignment6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CourseDetailsActivity extends AppCompatActivity {

    ImageView coursePicture;
    TextView courseDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        coursePicture = findViewById(R.id.courseDetailsPic);
        courseDetails = findViewById(R.id.courseDetailsTV);

        int picture = getIntent().getIntExtra("picture",R.drawable.background);
        String details = getIntent().getStringExtra("details");

        coursePicture.setImageResource(picture);
        courseDetails.setText(details);

    }
}