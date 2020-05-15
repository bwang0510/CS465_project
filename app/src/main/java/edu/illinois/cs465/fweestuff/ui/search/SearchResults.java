package edu.illinois.cs465.fweestuff.ui.search;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.illinois.cs465.fweestuff.R;
import edu.illinois.cs465.fweestuff.data.Event;

public class SearchResults extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public static SearchResults newInstance() {
        return new SearchResults();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_results_fragment, container, false);
        TextView noResults = view.findViewById(R.id.noResultsMsg);

        //get bundle arguments
        Bundle filters = this.getArguments();

        //get a reference to the recycler view
        recyclerView = view.findViewById(R.id.searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new VerticalSpaceItemDecorator(25));

        //get data for the view
        Random resultGenerator = new Random();
        Event[] eventArr = Event.populateData(resultGenerator.nextInt(5));
        List<Event> eventList = Arrays.asList(eventArr);


        if(filters.isEmpty()) {
            noResults.setVisibility(View.VISIBLE);
            noResults.setText("Please select at least one filter to search for events.");
        } else if (eventList.size() == 0) {
            noResults.setVisibility(View.VISIBLE);
        }
        else {
            noResults.setVisibility(View.INVISIBLE);
            adapter = new SearchResultsAdapater(eventList);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}