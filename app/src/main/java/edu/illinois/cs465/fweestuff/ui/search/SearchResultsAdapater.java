package edu.illinois.cs465.fweestuff.ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.illinois.cs465.fweestuff.R;
import edu.illinois.cs465.fweestuff.data.Event;

public class SearchResultsAdapater extends RecyclerView.Adapter<SearchResultsAdapater.ViewHolder> {

    private List<Event> data;

    public SearchResultsAdapater(List<Event> data){
        this.data = data;
    }

    @Override
    public SearchResultsAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemLayoutView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        viewHolder.eventName.setText(data.get(position).getEventName());
        viewHolder.eventDate.setText(data.get(position).getEventDate());
        viewHolder.eventStartTime.setText(data.get(position).getEventStartTime());
        viewHolder.eventLocation.setText(data.get(position).getEventLocation());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView eventName;
        public TextView eventDate;
        public TextView eventStartTime;
        public TextView eventLocation;

        public ViewHolder(View view) {
            super(view);
            eventName = view.findViewById(R.id.eventName);
            eventDate = view.findViewById(R.id.eventDate);
            eventStartTime = view.findViewById(R.id.eventTime);
            eventLocation = view.findViewById(R.id.eventLocation);
        }
    }

    @Override
    public int getItemCount(){
        return data.size();
    }

}
