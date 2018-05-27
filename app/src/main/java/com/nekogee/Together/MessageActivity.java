package com.nekogee.Together;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Intent intent = getIntent() ;

        int userImage = intent.getIntExtra("extra_userImage" , -1) ;
        String userName = intent.getStringExtra("extra_userName") ;
        String wishDescription = intent.getStringExtra("extra_description") ;
        int wishImage = intent.getIntExtra("extra_descriptionImage" , -1) ;

        ImageView UserImage = (ImageView)findViewById(R.id.message_userImage) ;
        TextView UserName = (TextView)findViewById(R.id.message_userName) ;
        TextView WishDescription = (TextView)findViewById(R.id.message_description) ;
        ImageView WishImage = (ImageView)findViewById(R.id.message_descriptionImage) ;

        UserImage.setImageResource(userImage);
        UserName.setText(userName) ;
        WishDescription.setText(wishDescription) ;
        WishImage.setImageResource(wishImage);

    }
}
