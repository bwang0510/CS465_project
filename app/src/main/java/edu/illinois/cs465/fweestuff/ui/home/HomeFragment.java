package edu.illinois.cs465.fweestuff.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import edu.illinois.cs465.fweestuff.R;
import edu.illinois.cs465.fweestuff.ViewPagerAdapter;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final TabLayout tabLayout = view.findViewById(R.id.tabs);
        final ViewPager viewPager = view.findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new EventsTab(), "Events");
        adapter.addFragment(new FeedTab(), "Feed");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter  adapter = new ViewPagerAdapter (getChildFragmentManager());
        adapter.addFragment(new FeedTab(), "Feed");
        adapter.addFragment(new EventsTab(), "Events");
        viewPager.setAdapter(adapter);
    }
}
