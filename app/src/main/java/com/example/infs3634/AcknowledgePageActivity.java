package com.example.infs3634;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3634.MainActivity;
import com.example.infs3634.R;

import java.util.Timer;
import java.util.TimerTask;

public class AcknowledgePageActivity extends AppCompatActivity {
//this is ack page
    public static String INTENT_MESSAGE;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acknowledge_page);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(AcknowledgePageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
