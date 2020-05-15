package edu.illinois.cs465.fweestuff;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.content.Intent;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_my_events, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
    public void onToggleClicked(View view) {
        TextView likes = findViewById(R.id.likeNum4);
        Toast toast = Toast.makeText(getApplicationContext(), likes.getText(), Toast.LENGTH_SHORT);
        toast.show();
        if(((ToggleButton) view).isChecked()) {
            likes.setText(Integer.toString(Integer.parseInt(likes.getText().toString())+1));
        } else {
            likes.setText(Integer.toString(Integer.parseInt(likes.getText().toString())-1));
        }
    }

    public void selectProfileImage(View view) {
        
    }
}
