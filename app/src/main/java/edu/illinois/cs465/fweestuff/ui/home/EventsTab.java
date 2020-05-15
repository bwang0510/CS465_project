package edu.illinois.cs465.fweestuff.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Random;

import edu.illinois.cs465.fweestuff.R;
import edu.illinois.cs465.fweestuff.data.Event;
import edu.illinois.cs465.fweestuff.ui.myEvents.MyEventsAdapter;
import edu.illinois.cs465.fweestuff.ui.search.VerticalSpaceItemDecorator;

public class EventsTab extends Fragment {
    Button popUp;
    ToggleButton fav1, fav2;
    TextView fn1, fn2;
    FloatingActionButton createButton;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_tab, container, false);

        //set reference for floating button
        createButton = view.findViewById(R.id.createEvent);

        //get reference to the recycler view
        recyclerView = view.findViewById(R.id.savedEventCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new VerticalSpaceItemDecorator(25));

        //get data for saved and created events
        List<Event> data = Event.getEventList(5);
        adapter = new MyEventsTabAdapter(data);
        recyclerView.setAdapter(adapter);


        /* popUp = view.findViewById(R.id.popUp1);

        fav1 = view.findViewById(R.id.fav1);
        fav2 = view.findViewById(R.id.fav2);

        fn1 = view.findViewById(R.id.favnum1);
        fn2 = view.findViewById(R.id.favnum2);

        createButton = view.findViewById(R.id.createEvent);

        popUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Event Title");
                alertDialog.setMessage("Event Details");
                alertDialog.show();
//                Context context = v.getContext();
//                LayoutInflater inflater = LayoutInflater.from(context);

            }
        });

        fav1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fn1.setText(Integer.toString(Integer.parseInt(fn1.getText().toString())+1));
                    Toast.makeText(getContext(), "Event Saved", Toast.LENGTH_SHORT).show();
                } else {
                    fn1.setText(Integer.toString(Integer.parseInt(fn1.getText().toString())-1));
                }
            }
        });

        fav2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fn2.setText(Integer.toString(Integer.parseInt(fn2.getText().toString())+1));
                } else {
                    fn2.setText(Integer.toString(Integer.parseInt(fn2.getText().toString())-1));
                }
            }
        });*/

        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, CreatePop.class));
            }
        });

        return view;
    }
}
