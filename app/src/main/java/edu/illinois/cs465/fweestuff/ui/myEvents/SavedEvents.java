package edu.illinois.cs465.fweestuff.ui.myEvents;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.illinois.cs465.fweestuff.R;
import edu.illinois.cs465.fweestuff.data.Event;
import edu.illinois.cs465.fweestuff.ui.search.VerticalSpaceItemDecorator;

public class SavedEvents extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_events, container, false);

        //get reference to the recycler view
        recyclerView = view.findViewById(R.id.savedEventCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new VerticalSpaceItemDecorator(25));

        //get data for saved and created events
        List<Event> data = Event.getSavedEvents();
        adapter = new MyEventsAdapter(data, true);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
