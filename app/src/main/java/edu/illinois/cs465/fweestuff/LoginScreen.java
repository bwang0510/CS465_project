package edu.illinois.cs465.fweestuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void onForgotPassword(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Forgot Password?");
        builder.setMessage("Input your email below and we'll send you a password reset link.");

        final EditText input = new EditText(this);
        input.setScaleX((float)0.95);
        input.setHint("Email");
        FrameLayout container = new FrameLayout(this);
        FrameLayout.LayoutParams params = new  FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
        params.rightMargin = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
        input.setLayoutParams(params);
        container.addView(input);

        builder.setView(container);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                (new Handler()).postDelayed(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Email sent!", Toast.LENGTH_LONG).show();
                    }
                }, 700);
            }
        });

        builder.show();
    }

    public void onCreateAccount(View view) {
        Intent myIntent = new Intent(LoginScreen.this, SignUpScreen.class);
        LoginScreen.this.startActivity(myIntent);
    }

    public void onLogIn(View view) {
        Intent nextScreen = new Intent(LoginScreen.this, MainActivity.class);
        nextScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(nextScreen);
        ActivityCompat.finishAffinity(LoginScreen.this);
    }
}
