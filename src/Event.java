import java.util.ArrayList;
import java.util.Date;

public class Event {

    private String name;
    private String status;
    private double pricePool;
    private Date eventDate;
    private ArrayList<User> participants;
    private ArrayList<Integer> ratings;
    private int maximalParticipants;

    public Event( String name, String status,double pricePool, Date eventDate, int maximalParticipants) {

        this.name = name;
        this.status = status;
        this.pricePool = pricePool;
        this.eventDate = eventDate;
        this.participants = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.maximalParticipants = maximalParticipants;
    }


    public void addParticipant (User participant){
        if (participants.size()>=maximalParticipants) {
            System.out.println("Max participants ");
        }
        else{
            participants.add(participant);
        }
    }


    public double getPrizePool() {
        return pricePool;
    }

    public void setPricePool(double pricePool) {
        this.pricePool = pricePool;
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
        return "Event :" +
                "|name'" + name + '\'' +
                "| status='" + status + '\'' +
                "| pricePool=" + pricePool +
                "| eventDate=" + eventDate +
                "|participants=" + participants +
                "|ratings=" + ratings +
                "|maximalParticipants=" + maximalParticipants
                ;
    }
}