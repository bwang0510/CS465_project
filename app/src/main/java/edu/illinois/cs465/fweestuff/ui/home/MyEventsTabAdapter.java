package edu.illinois.cs465.fweestuff.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.List;
import java.util.Random;

import edu.illinois.cs465.fweestuff.R;
import edu.illinois.cs465.fweestuff.data.Event;

public class MyEventsTabAdapter extends RecyclerView.Adapter<MyEventsTabAdapter.ViewHolder> {

    private List<Event> data;

    public MyEventsTabAdapter(List<Event> data) {
        this.data = data;
    }

    @Override
    public MyEventsTabAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card_with_save_button, null);

        MyEventsTabAdapter.ViewHolder viewHolder = new MyEventsTabAdapter.ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyEventsTabAdapter.ViewHolder viewHolder, int position) {
        Random number = new Random();
        int randomLikesNum = number.nextInt(100);

        viewHolder.eventName.setText(data.get(position).getEventName());
        viewHolder.eventDate.setText(data.get(position).getEventDate());
        viewHolder.eventStartTime.setText(data.get(position).getEventStartTime());
        viewHolder.saveCount.setText(Integer.toString(randomLikesNum));

        viewHolder.itemView.findViewById(R.id.heartIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer count = Integer.parseInt(viewHolder.saveCount.getText().toString());

                if(!viewHolder.savesButton.isChecked()){
                    viewHolder.savesButton.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                    viewHolder.saveCount.setText(Integer.toString(count + 1));
                } else {
                    viewHolder.savesButton.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp);
                    viewHolder.saveCount.setText(Integer.toString(count - 1));
                }
            }
        });

        //open dialog box for more information
        viewHolder.itemView.findViewById(R.id.viewInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                int position = viewHolder.getAdapterPosition();
                    Dialog moreInfoDialog = new Dialog(context);
                    moreInfoDialog.setTitle("Title");
                    moreInfoDialog.setContentView(R.layout.event_info_dialog);

                    //set data for view more info
                    TextView dialogEventTitle = moreInfoDialog.findViewById(R.id.eventName);
                    dialogEventTitle.setText(data.get(position).getEventName());

                    TextView dialogEventDate = moreInfoDialog.findViewById(R.id.eventDate);
                    dialogEventDate.setText(data.get(position).getEventDate());

                    TextView dialogEventTime = moreInfoDialog.findViewById(R.id.eventStartTime);
                    dialogEventTime.setText(data.get(position).getEventStartTime());

                    Chip dialogEventType = moreInfoDialog.findViewById(R.id.eventTypeChip);
                    dialogEventType.setText(data.get(position).getEventType());

                    Chip dialogGiveawayType = moreInfoDialog.findViewById(R.id.giveawayTypeChip);
                    dialogGiveawayType.setText(data.get(position).getEventGiveawayType());

                    TextView dialogDescription = moreInfoDialog.findViewById(R.id.description);
                    dialogDescription.setText(data.get(position).getEventDescription());

                    moreInfoDialog.show();
            }
        });
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView eventName;
        public TextView eventDate;
        public TextView eventStartTime;
        public ToggleButton savesButton;
        public TextView saveCount;

        public ViewHolder(View view) {
            super(view);
            eventName = view.findViewById(R.id.eventName);
            eventDate = view.findViewById(R.id.eventDate);
            eventStartTime = view.findViewById(R.id.eventTime);
            saveCount = view.findViewById(R.id.savedCount);
            savesButton = view.findViewById(R.id.heartIcon);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
