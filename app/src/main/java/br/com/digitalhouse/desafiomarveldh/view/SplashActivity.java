package br.com.digitalhouse.desafiomarveldh.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.digitalhouse.desafiomarveldh.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView splashMarvel;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashMarvel = findViewById(R.id.splashMarvel);
        splashMarvel.setOnClickListener(view -> jump());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 3000);
    }

    private void jump() {
        timer.cancel();
        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}

