package edu.illinois.cs465.fweestuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
    }

    public void goToSignin(View view) {
        Intent myIntent = new Intent(SignUpScreen.this, LoginScreen.class);
        SignUpScreen.this.startActivity(myIntent);
    }

    public void onCreateAccount(View view) {
        Intent nextScreen = new Intent(SignUpScreen.this, MainActivity.class);
        nextScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(nextScreen);
        ActivityCompat.finishAffinity(SignUpScreen.this);
    }
}
