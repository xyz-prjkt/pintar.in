package id.xyzprjkt.pintarin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.kieronquinn.monetcompat.app.MonetCompatActivity;

import java.util.Objects;

import id.xyzprjkt.pintarin.Activity.DashboardActivity;
import id.xyzprjkt.pintarin.Activity.LoginActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends MonetCompatActivity {

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_splash);

        fAuth = FirebaseAuth.getInstance();
        int delay = 2000;
        new Handler().postDelayed(() -> {

            if(fAuth.getCurrentUser() != null){
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                finish();
            } else {
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }
        }, delay);
    }
}