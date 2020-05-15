package edu.illinois.cs465.fweestuff.ui.myEvents;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;
import androidx.lifecycle.ViewModelProviders;
import androidx.fragment.app.FragmentStatePagerAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import edu.illinois.cs465.fweestuff.R;
import edu.illinois.cs465.fweestuff.ViewPagerAdapter;

public class MyEvents extends Fragment {

    private MyEventsViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(MyEventsViewModel.class);

        //inflate view
        View view = inflater.inflate(R.layout.my_events_fragment, container, false);

        //grab references to the tab layouts and view pager
        final ViewPager viewPager = view.findViewById(R.id.myEventsViewPager);
        final TabLayout tabLayout = view.findViewById(R.id.myEventsTabLayout);

        //create adapter and add tab information
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new SavedEvents(), "Saved");
        adapter.addFragment(new CreatedEvents(), "Created");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
