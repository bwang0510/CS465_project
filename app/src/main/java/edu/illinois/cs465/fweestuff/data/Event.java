package edu.illinois.cs465.fweestuff.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {

    @NonNull
    private String eventName;

    @NonNull
    private String eventLocation;

    @NonNull
    private String eventDate;

    @NonNull
    private String eventStartTime;

    @NonNull
    private String eventEndTime;

    @NonNull
    private String eventType;

    @Nullable
    private String eventGiveawayType;

    @Nullable
    private String eventDescription;

    @Nullable
    private byte[] eventImage;

    //constructor
    public Event(@NonNull String eventName, @NonNull String eventLocation, @NonNull String eventDate,
                 @NonNull String eventStartTime, @NonNull String eventEndTime,
                 @NonNull String eventType,
                 @Nullable String eventGiveawayType, @Nullable String eventDescription,
                 @Nullable byte[] eventImage){
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventType = eventType;
        this.eventGiveawayType = eventGiveawayType;
        this.eventDescription = eventDescription;
        this.eventImage = eventImage;
    }

    //creates random events using pre-defined mock data
    public static Event[] populateData(int numOfEntries){
        MockData dataGenerator = new MockData();
        Event[] events = new Event[numOfEntries];

        //generate array of events
        for (int i = 0; i < numOfEntries; i++) {

            //get mock data
            String name = dataGenerator.getEventName();
            String location = dataGenerator.getLocation();
            String date = dataGenerator.getDate();
            String[] times = dataGenerator.getTimes();
            String start = times[0];
            String end = times[1];
            String type = dataGenerator.getType();
            String giveaway = dataGenerator.getGiveaway();

            //create event
            Event sample = new Event(name, location, date, start, end, type, giveaway,
                    dataGenerator.getDescription(), null);

            //add event to list
            events[i] = sample;
        }

        return events;
    }

    //generate events for saved events
    private static List<Event> savedEvents = Arrays.asList(new Event("Grainger Engineering Career" +
                    " " +
                    "Fair", "ARC Room 1234",
                    "Mar. 31", "6:00 p.m.", "9:00 p.m.", "Professional", "Unique Items", "Are " +
                    "interested in engineering internships? Come to the Grainger Engineering Career " +
                    "Fair to learn about summer internship opportunities,meet with different " +
                    "companies and schedule interviews. Light refreshments will be provided.", null),
            new Event("Krannert Uncorked with Nfinite Soul", "Krannert " +
                    "Center, Stage 5", "Dec. 25th", "5:00 p.m.", "7:00 p.m.", "Campus-wide",
                    "Food", "At Krannert Uncorked, Stage 5 is the crossroads to gather, make " +
                    "connections, and try a new wine. Enjoy Nfinite Soul for an evening of " +
                    "rhythm and blues, neo-soul, jazz, and reggae.", null), new Event("Doctors with Borders Info Session", "Lincoln " +
                    "Hall, Room 3456", "Jan. 9", "3:30 p.m", "5:00 p.m", "RSO", "Information", "Learn" +
                    " mroe about our summer service trip to Wyoming.", null));

    //saved events getter and setter
    public static List<Event> getSavedEvents(){
        return savedEvents;
    }

    public void addSavedEvent(Event event){
        this.savedEvents.add(event);
    }

    //generate events for created events
    private static List<Event> createdEvents = Arrays.asList(new Event("Grainger Engineering " +
                                                                                  "Career Fair", "ARC Room 1234",
                    "Mar. 31", "6:00 p.m.", "9:00 p.m.", "Professional", "Unique Items", "Are " +
                    "interested in engineering internships? Come to the Grainger Engineering Career " +
                    "Fair to learn about summer internship opportunities,meet with different " +
                    "companies and schedule interviews. Light refreshments will be provided.",
            null));

    public static List<Event> getCreatedEvents(){
        return createdEvents;
    }

    public void addCreatedEvents(Event event){
        this.createdEvents.add(event);
    }

    private static List<Event> fullEventList;

    public static List<Event> getEventList(int numOfEvents) {
        fullEventList = Arrays.asList(populateData(numOfEvents));
        return fullEventList;
    }

    public static void addEventToList(Event event){
        fullEventList.add(event);
    }

    //getters

    @NonNull
    public String getEventName() {
        return eventName;
    }

    @NonNull
    public String getEventLocation() {
        return eventLocation;
    }

    @NonNull
    public String getEventDate() {
        return eventDate;
    }

    @NonNull
    public String getEventStartTime() {
        return eventStartTime;
    }

    @NonNull
    public String getEventEndTime() {
        return eventEndTime;
    }

    @NonNull
    public String getEventType() {
        return eventType;
    }

    @Nullable
    public String getEventGiveawayType() {
        return eventGiveawayType;
    }

    @Nullable
    public String getEventDescription() {
        return eventDescription;
    }

    @Nullable
    public byte[] getEventImage() {
        return eventImage;
    }

    //setters

    public void setEventName(@NonNull String eventName) {
        this.eventName = eventName;
    }

    public void setEventLocation(@NonNull String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setEventDate(@NonNull String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventStartTime(@NonNull String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public void setEventEndTime(@NonNull String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public void setEventType(@NonNull String eventType) {
        this.eventType = eventType;
    }

    public void setEventGiveawayType(@Nullable String eventGiveawayType) {
        this.eventGiveawayType = eventGiveawayType;
    }

    public void setEventDescription(@Nullable String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventImage(@Nullable byte[] eventImage) {
        this.eventImage = eventImage;
    }
}

