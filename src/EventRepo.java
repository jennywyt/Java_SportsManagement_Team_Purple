import java.util.*;

public class EventRepo {

    ArrayList<Event> listOfEvent;

    public EventRepo(){

        listOfEvent=new ArrayList<>();
    }

    ArrayList<Event> getAll(){
        return listOfEvent;
    }
    ArrayList<Event> getBookedOutEvents(){
        return listOfEvent;
    }

    public void saveEvent(Event event){
        listOfEvent.add(event);
    }

    ArrayList<Event> getFiveTopRatedEvents(){
        return listOfEvent;
    }


    ArrayList<Event> getPastEvents(){
        return listOfEvent;
    }

    ArrayList<Event> getUpcomingEvents(){
        return listOfEvent;
    }

    ArrayList<Event> getEventsWithOpenSpots(){
        return listOfEvent;
    }

}