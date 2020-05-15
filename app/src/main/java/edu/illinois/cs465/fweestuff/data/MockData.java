package edu.illinois.cs465.fweestuff.data;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class MockData {

    private String[] location = new String[]{"Lincoln Hall", "Siebel Center", "Digital Computer " +
            "Laboratory", "Coordinated Science Laboratory", "Illini Union", "Grainger Engineering" +
            " Library", "Gregory Hall", "State Farm Center", "North Quad", "Main Quad", "South " +
            "Quad"};

    private String[] type = new String[] {"Company", "RSO", "Campus-wide"};

    private String[] giveaway = new String[] {"Food", "T-shirts", "General Swag", "Unique Items",
            "Information", "Stickers"};

    private String[] times = new String[] {
            "12:00 am", "1:00 am", "2:00 am", "3:00 am", "4:00 am", "5:00 am", "6:00 am", "7:00 " +
            "am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 " +
            "pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm", "8:00 pm", "9:00 " +
            "pm", "10:00 pm", "11:00 pm"
    };

    private String[] event = new String[] {"Pizza Night", "General Meeting", "Info Session",
            "Game Night", "Career Fair", "Booth", "Academic Talk"};

    private String[] organization = new String[] {"Engineering", "Computer Science", "UIUC Dance"
            , "Student Council", "Class of 2021", "Study Abroad"};

    private String[] months = new String[] {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.",
            "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};

    private String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Suspendisse venenatis bibendum libero, eu pellentesque elit facilisis ut. Lorem " +
            "ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse venenatis bibendum libero, eu pellentesque elit facilisis ut.";

    Random generator = new Random();

    public String getDescription() {
        return description;
    }

    public String getEventName() {
        int eventIndex = generator.nextInt(event.length);
        int orgIndex = generator.nextInt(organization.length);
        return organization[orgIndex] + " " + event[eventIndex];
    }

    public String getLocation(){
        int locationIndex = generator.nextInt(location.length);
        return location[locationIndex];
    }

    public String getType(){
        int typeIndex = generator.nextInt(type.length);
        return type[typeIndex];
    }

    public String getGiveaway() {
        int giveawayIndex = generator.nextInt(giveaway.length);
        return giveaway[giveawayIndex];
    }

    public String getDate() {
        int day = generator.nextInt(29);
        int monthIndex = generator.nextInt(months.length);
        return months[monthIndex] + " " + day;
    }

    public String[] getTimes() {
        int startTimeIndex = generator.nextInt(times.length);
        int endTimeIndex;
        if(startTimeIndex != times.length - 1) {
            endTimeIndex = generator.nextInt(startTimeIndex + 1) + 1;
        } else {
            endTimeIndex = 0;
        }

        return new String[]{times[startTimeIndex], times[endTimeIndex]};
    }
}
