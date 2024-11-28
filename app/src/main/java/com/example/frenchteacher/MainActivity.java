package com.example.frenchteacher;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button blackBtn, yellowBtn, redBtn, purpleBtn, greenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        blackBtn = findViewById(R.id.blackBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        redBtn = findViewById(R.id.redBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        greenBtn = findViewById(R.id.greenBtn);

        blackBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Find the button by ID and play the correct sound

        int clickedBtnId = v.getId();

        if (clickedBtnId == R.id.blackBtn) {
            PlaySounds(R.raw.black);
        } else if (clickedBtnId == R.id.yellowBtn) {
            PlaySounds(R.raw.yellow);
        }
        else if (clickedBtnId == R.id.redBtn) {
            PlaySounds(R.raw.red);
        }
        else if (clickedBtnId == R.id.purpleBtn) {
            PlaySounds(R.raw.purple);
        }else if (clickedBtnId == R.id.greenBtn) {
            PlaySounds(R.raw.green);
        }
    }

    public void PlaySounds(int id){
        // Launch media player with the correct id
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), id);
        mediaPlayer.start();
    }
}