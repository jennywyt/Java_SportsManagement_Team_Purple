
import java.util.*;

import java.text.SimpleDateFormat;


public class Event {
    private double prizePool;
    private String name;
    private String status;
    private Date eventDate;

//  private SimpleDateFormat eventDate = new SimpleDateFormat("dd/MM/yyyy");

    private EventCategories eventCategory;
    private ArrayList<User> participants;
    private ArrayList<Integer> ratings;
    private int maximalParticipants;
//  private int ticketPrice;
//  private ArrayList<User> ticketBuyers;   VISITORS

    public Event(double prizePool, String name, String status, Date eventDate, int maximalParticipants, EventCategories eventCategory) {
        this.prizePool = prizePool;
        this.name = name;
        this.status = status;
        this.eventCategory = eventCategory;
        this.eventDate = eventDate;
        this.participants = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.maximalParticipants = maximalParticipants;
    }


    public void addParticipant (User participant){
        if (participants.size()>=maximalParticipants) {
            System.out.println("Max participants reached");
        }
        else{
            participants.add(participant);
        }
    }

    public EventCategories getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategories eventCategory) {
        this.eventCategory = eventCategory;
    }

    public double getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(double prizePool) {
        this.prizePool = prizePool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<User> participants) {
        this.participants = participants;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public int getMaximalParticipants() {
        return maximalParticipants;
    }

    public void setMaximalParticipants(int maximalParticipants) {
        this.maximalParticipants = maximalParticipants;
    }

    @Override
    public String toString() {
        return "Event{" +
                "prizePool=" + prizePool +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", eventDate=" + eventDate +
                ", eventCategory=" + eventCategory +
                ", maximalParticipants=" + maximalParticipants +
                '}';
    }
}
