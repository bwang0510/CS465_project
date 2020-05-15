package edu.illinois.cs465.fweestuff.ui.myEvents;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.List;

import edu.illinois.cs465.fweestuff.CreateEvent;
import edu.illinois.cs465.fweestuff.EditEvent;
import edu.illinois.cs465.fweestuff.R;
import edu.illinois.cs465.fweestuff.data.Event;
import edu.illinois.cs465.fweestuff.ui.myEvents.MyEventsAdapter;

public class MyEventsAdapter extends RecyclerView.Adapter<MyEventsAdapter.ViewHolder> {

    private List<Event> data;
    private boolean isSavedTab;

    public MyEventsAdapter(List<Event> data, boolean isSavedTab){
        this.data = data;
        this.isSavedTab = isSavedTab;
    }

    @Override
    public MyEventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemLayoutView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card_dual_buttons, null);

        MyEventsAdapter.ViewHolder viewHolder = new MyEventsAdapter.ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyEventsAdapter.ViewHolder viewHolder, int position){
        viewHolder.eventName.setText(data.get(position).getEventName());
        viewHolder.eventDate.setText(data.get(position).getEventDate());
        viewHolder.eventStartTime.setText(data.get(position).getEventStartTime());
        viewHolder.eventLocation.setText(data.get(position).getEventLocation());

        if(isSavedTab == true) {
            viewHolder.firstActionButton.setText("View Info");
            viewHolder.secondActionButton.setText("Delete");
        } else {
            viewHolder.firstActionButton.setText("Edit Info");
            viewHolder.secondActionButton.setText("Delete");
        }

        //toggle action buttons
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                LinearLayout buttonBar = view.findViewById(R.id.buttonBar);
                if(buttonBar.getVisibility() == View.GONE) {
                    buttonBar.setVisibility(View.VISIBLE);
                } else {
                    buttonBar.setVisibility(View.GONE);
                }
            }
        });

        //open dialog box for more information
        viewHolder.itemView.findViewById(R.id.firstActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button actionType = view.findViewById(R.id.firstActionButton);
                Context context = view.getContext();
                int position = viewHolder.getAdapterPosition();
                if(actionType.getText() == "View Info") {
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
                } else {

                    //create a bundle for the event
                    Bundle event = new Bundle();
                    event.putString("eventName", data.get(position).getEventName());
                    event.putString("eventDate", data.get(position).getEventDate());
                    event.putString("eventLocation", data.get(position).getEventLocation());
                    event.putString("eventStartTime", data.get(position).getEventStartTime());
                    event.putString("eventEndTime", data.get(position).getEventEndTime());
                    event.putString("eventType", data.get(position).getEventType());
                    event.putString("giveawayType", data.get(position).getEventGiveawayType());
                    event.putString("description", data.get(position).getEventDescription());

                    //create an intent
                    Intent intent = new Intent(context, EditEvent.class);
                    intent.putExtras(event);
                    context.startActivity(intent);

                }
            }
        });
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView eventName;
        public TextView eventDate;
        public TextView eventStartTime;
        public TextView eventLocation;
        public Button firstActionButton;
        public Button secondActionButton;

        public ViewHolder(View view) {
            super(view);
            eventName = view.findViewById(R.id.eventName);
            eventDate = view.findViewById(R.id.eventDate);
            eventStartTime = view.findViewById(R.id.eventTime);
            eventLocation = view.findViewById(R.id.eventLocation);
            firstActionButton = view.findViewById(R.id.firstActionButton);
            secondActionButton = view.findViewById(R.id.secondActionButton);
        }
    }

    @Override
    public int getItemCount(){
        return data.size();
    }
}
