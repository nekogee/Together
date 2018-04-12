package com.nekogee.Together;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class NewsActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    private ImageButton ButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Log.d("qqqq","click news");
        initMsgs();
        Log.d("qqqq","initial news");
        inputText = (EditText) findViewById(R.id.input_text);
        Log.d("qqqq","c1");
        send = (Button) findViewById(R.id.send);
        ButtonBack = (ImageButton)findViewById(R.id.title_back);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        Log.d("qqqq","c2");
        msgRecyclerView.setLayoutManager(layoutManager);
        Log.d("qqqq","c3");
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    inputText.setText("");
                }
            }
        });
    }

    public static  void actionStart(Context context, String peopleName, String peopleNews)
    {
        Intent intent = new Intent(context,NewsActivity.class);
        intent.putExtra("people_name",peopleName);
        intent.putExtra("people_news",peopleNews);
        context.startActivity(intent);

    }

    private  void initMsgs(){
        Msg msg1 = new Msg("hello guy",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("hello,guy!",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("emmm",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
        Log.d("qqqq","in initial");
    }
}
