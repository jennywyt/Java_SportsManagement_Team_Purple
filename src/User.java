
import java.util.*;
public class User {


    private String username;
    private String lastname;
    private String Email;
    private ArrayList<Event> listOfEvents;

    public User(String username, String lastname, String email) {
        this.username = username;
        this.lastname = lastname;
        Email = email;
        listOfEvents=new ArrayList<>();

    }

    public void addEvent(Event event){
        listOfEvents.add(event);
    }

    public ArrayList<Event> getListOfEvents() {
        return listOfEvents;
    }

    public void setListOfEvents(ArrayList<Event> listOfEvents) {
        this.listOfEvents = listOfEvents;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", lastname='" + lastname + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
