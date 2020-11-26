
import java.util.*;

import java.text.SimpleDateFormat;


public class Event {
    private PrizePool prizePool;
    private String name;
    private Status status;
    private Date eventDate;

//  private SimpleDateFormat eventDate = new SimpleDateFormat("dd/MM/yyyy"); ???

    private EventCategories eventCategory;
    private ArrayList<User> participants;
    private ArrayList<Integer> ratings;
    private Participants maximalParticipants;
//  private int ticketPrice;
//  private ArrayList<User> ticketBuyers;   VISITORS, thats bonus task

    public Event(PrizePool prizePool, String name, Status status, Date eventDate, Participants maximalParticipants, EventCategories eventCategory) {
        this.prizePool = prizePool;
        this.name = name;
        this.status= status;
        this.eventCategory = eventCategory;
        this.eventDate = eventDate;
        this.participants = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.maximalParticipants = maximalParticipants;
    }


    public void addParticipant (User participant){
        if (participants.size()>=maximalParticipants.getMaxParticipants()) {
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

    public PrizePool getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(PrizePool prizePool) {
        this.prizePool = prizePool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public Participants getMaximalParticipants() {
        return maximalParticipants;
    }

    public void setMaximalParticipants(Participants maximalParticipants) {
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
