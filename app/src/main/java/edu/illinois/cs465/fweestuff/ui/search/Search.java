package edu.illinois.cs465.fweestuff.ui.search;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.material.chip.*;

import java.util.ArrayList;

import edu.illinois.cs465.fweestuff.R;

import static android.R.*;

public class Search extends Fragment implements View.OnClickListener{
    //declare for form elements
    private EditText searchBar;
    private ChipGroup eventTypeChips;
    private ChipGroup giveawayTypeChips;
    private ChipGroup eventDayChips;
    private Spinner eventStartTime;
    private Spinner eventEndTime;
    private SeekBar distanceLimit;
    private Button searchButton;
    private String[] times = new String[] {
            "12:00 am", "1:00 am", "2:00 am", "3:00 am", "4:00 am", "5:00 am", "6:00 am", "7:00 " +
            "am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 " +
            "pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 " +
            "pm", "10:00 pm", "11:00 pm"
    };
    private String[] DISTANCES = new String[] {
            "< 5 min", "5-10 min", "10-15 min", "15-20 min", "20-25 min", "25-30 min", "> 30 min"
    };
    private TextView distancePopup;

    public static Search newInstance() {
        return new Search();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.search_fragment, container, false);

        //set reference to views
        searchBar = view.findViewById(R.id.searchBar);
        eventTypeChips = view.findViewById(R.id.eventTypeGroup);
        giveawayTypeChips = view.findViewById(R.id.giveawayTypeGroup);
        eventDayChips = view.findViewById(R.id.eventDayGroup);
        eventStartTime = view.findViewById(R.id.eventStartSpinner);
        eventEndTime = view.findViewById(R.id.eventEndSpinner);
        distanceLimit = view.findViewById(R.id.distnaceSlider);
        distancePopup = view.findViewById(R.id.sliderPopup);

        //get search button and add event listener
        searchButton = view.findViewById(R.id.searchSubmit);
        searchButton.setOnClickListener(this);
        setupSeekBar(view);

        Rect thumbRect = distanceLimit.getThumb().getBounds();
        distancePopup.setX(thumbRect.centerX());
        distancePopup.setText(String.format("%s min", String.valueOf(distanceLimit.getProgress())));
        distanceLimit.setProgress(0);

        return view;
    }

    private void setupSeekBar(View view) {
        distanceLimit.incrementProgressBy(5);
        distanceLimit.setMax(30);

        distanceLimit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar distanceLimit, int progress, boolean fromUser) {
                progress = progress / 5;
                progress = progress * 5;
                Rect thumbRect = distanceLimit.getThumb().getBounds();
                distancePopup.setX(thumbRect.centerX());
                distancePopup.setText(DISTANCES[progress / 5]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //add values to spinners
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, times);
        adapter.setDropDownViewResource(layout.simple_spinner_dropdown_item);
        eventStartTime.setAdapter(adapter);
        eventEndTime.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        //get the information
        String searchTerms = searchBar.getText().toString();
        ArrayList<String> eventTypes = getChipSelections(eventTypeChips);
        ArrayList<String> giveawayTypes = getChipSelections(giveawayTypeChips);
        ArrayList<String> eventDay = getChipSelections(eventDayChips);

        //create results fragment with corresponding data
        Bundle filters = new Bundle();

        if(searchTerms.length() != 0 || eventTypes.size() != 0 || giveawayTypes.size() != 0 || eventDay.size() != 0) {
            filters.putString("search_criteria", "added");
        }

        //manage backstack and inflate fragment
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment resultsFragment = SearchResults.newInstance();
        resultsFragment.setArguments(filters);
        transaction.replace(R.id.nav_host_fragment, resultsFragment, null).commit();
    }

    public ArrayList<String> getChipSelections(ChipGroup chipGroup) {
        ArrayList<String> chipValues = new ArrayList<>();
        for(int i = 0; i < chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);
            if(chip.isChecked()) {
                chipValues.add(chip.getText().toString());
            }
        }

        return chipValues;
    }



}