package edu.illinois.cs465.fweestuff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.fweestuff.data.Event;

public class EditEvent extends FragmentActivity {

    //private Spinner spinner1, spinner2, spinner3;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_event);

        //addItemsOnSpinners();
        //addListenerOnButton();
        //addListenerOnSpinnerItemSelection();
    }


   /* public void addListenerOnSpinnerItemSelection() {
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }*/

   /* public void addListenerOnButton() {

        spinner1 = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(EditEvent.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ spinner1.getSelectedItem() +
                                "\nSpinner 2 : "+ spinner2.getSelectedItem() +
                                "\nSpinner 3 : "+ spinner3.getSelectedItem(),
                        Toast.LENGTH_SHORT).show();
            }

        });
        Button next_page = (Button)findViewById(R.id.button);

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditEvent.this, EventPage.class));
            }
        });
    }*/

}
