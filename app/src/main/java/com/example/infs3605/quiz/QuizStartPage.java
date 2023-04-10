package com.example.infs3605.quiz;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.infs3634.R;


public class QuizStartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton=(Button) findViewById(R.id.button);
        final TextView nameText=(TextView) findViewById(R.id.textView);
        final EditText nametext=(EditText)findViewById(R.id.editName);

        startButton.setOnClickListener(new View.OnClickListener() {
               @Override
            public void onClick(View view) {
                   String name=nametext.getText().toString();
                   Intent intent=new Intent(getApplicationContext(), QuizActivity.class);
                   intent.putExtra("myname",name);
                startActivity(intent);

            }
            });

    }
}
