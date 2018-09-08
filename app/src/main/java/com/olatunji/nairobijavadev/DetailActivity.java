package com.olatunji.nairobijavadev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView usernameTextView;
    TextView userGitUrlTextView;
    ImageView userImageView;
    String username, userGitUrl;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_detail);
        usernameTextView = findViewById(R.id.tv_username);
        userGitUrlTextView = findViewById(R.id.tv_giturl);
        userImageView = findViewById(R.id.iv_profile_image);
        viewDevDetail();
        getSupportActionBar().setTitle("Developer Details");
    }

    private void viewDevDetail() {
        intent = this.getIntent();
        String username = intent.getStringExtra("USERNAME");
        String userGitHub = intent.getStringExtra("GITHUB");

        usernameTextView.setText(username);
        userGitUrlTextView.setText(userGitHub);

    }
}
