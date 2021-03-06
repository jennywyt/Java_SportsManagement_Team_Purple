import java.util.ArrayList;
import java.util.Date;

public class EventRepo {

    ArrayList<Event> listOfEvent;

    public EventRepo() {
        listOfEvent = new ArrayList<>();
    }

    ArrayList<Event> getAll() {
        return listOfEvent;
    }

    ArrayList<Event> getBookedOutEvents() {
        return listOfEvent;
    }

    public void saveEvent(Event event) {
        listOfEvent.add(event);
    }

    ArrayList<Event> getFiveTopRatedEvents() {
        return listOfEvent;
    }


    ArrayList<Event> getPastEvents() {
        Date now = new Date();

        ArrayList<Event> pastEvents = new ArrayList<>();
        // Put events into the new list if they are in the past
        for (Event event : getAll()) {
            if (event.getEventDate().compareTo(now) < 0) {
                pastEvents.add(event);
            }
        }

        return pastEvents;
    }

    ArrayList<Event> getUpcomingEvents() {
        Date now = new Date();

        ArrayList<Event> upcomingEvents = new ArrayList<>();
        for (Event event : getAll()) {
            if (event.getEventDate().compareTo(now) > 0) {
                upcomingEvents.add(event);
            }
        }

        return upcomingEvents;
    }

    ArrayList<Event> getEventsWithOpenSpots() {
        ArrayList<Event> eventsWithOpenSpots = new ArrayList<>();
        for (Event event : getAll()) {
            if (event.hasOpenSpots()) {
                eventsWithOpenSpots.add(event);
            }
        }

        return eventsWithOpenSpots;
    }

}