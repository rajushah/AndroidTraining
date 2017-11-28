package com.halftone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.halftone.movie.R;

public class ProjectDetailActivity extends AppCompatActivity {
    TextView mTvProjectDescription;
    Repo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        mTvProjectDescription = findViewById(R.id.project_details_tv_description);

        repo = (Repo) getIntent().getExtras().getSerializable("repo");
        mTvProjectDescription.setText(repo.description);

        Toast.makeText(this, "we reached here", Toast.LENGTH_LONG).show();
    }
}
