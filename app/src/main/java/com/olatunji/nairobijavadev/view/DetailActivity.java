package com.olatunji.nairobijavadev.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.olatunji.nairobijavadev.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView usernameTextView;
    TextView gitUrlTextView;
    ImageView displayPictureImageView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_detail);
        viewDevDetail();
        getSupportActionBar().setTitle("Developer Details");
    }

    private void viewDevDetail() {
        intent = this.getIntent();
        String username = intent.getStringExtra("USERNAME");
        String userGitHub = intent.getStringExtra("GITHUB");
        String imageUrl = intent.getStringExtra("IMAGE_URL");
        usernameTextView = findViewById(R.id.tv_username);
        gitUrlTextView = findViewById(R.id.tv_giturl);
        displayPictureImageView = findViewById(R.id.iv_profile_image);
        usernameTextView.setText(username);
        gitUrlTextView.setText(userGitHub);
        Picasso.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.dev)
                .into(displayPictureImageView);

    }
}
