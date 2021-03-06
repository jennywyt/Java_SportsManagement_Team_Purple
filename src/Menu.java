import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    static EventRepo eventRepo = new EventRepo();
    static UserRepo userRepo = new UserRepo();

    public static void main(String[] args) {
        addTestData();
        printHeader();

        int userInput;

        do {
            printMenu();
            userInput = getUserInput(9, "your service");
            switch (userInput) {
                case 1:
                    displayAllEvents();
                    break;
                case 2:
                    display5TopEvents();
                    break;
                case 3:
                    displayAllEventsWithOpeningSpots();
                    break;
                case 4:
                    displayAllUpComingEvents();
                    break;
                case 5:
                    displayAllPastEvents();
                    break;
                case 6:
                    enterNewEvents();
                    break;
                case 7:
                    createANewUser();
                    break;
                case 8:
                    addParticipant();
                    break;

                case 9:
                    showParticipantsOfEvent();
                    break;
            }
        } while (userInput != 0);
    }

    private static void addTestData() {
        userRepo.saveUser(new User("Simon", "Sagen", "email@emai.com"));
        userRepo.saveUser(new User("Uncle", "Roger", "eggfriedrice@gmail.com"));
        eventRepo.saveEvent(new Event(PrizePool.$100, "Tennis game", Status.Upcoming,
                Date.from(ZonedDateTime.of(2020, 11, 27, 8, 0, 0, 0, ZoneId.systemDefault()).toInstant()),
                Participants.fiveOn5, EventCategories.basketball));
    }

    private static void addParticipant() {
        System.out.println("Select User");
        ArrayList<User> allUsers = userRepo.getAll();
        for (int i = 0; i < allUsers.size(); i++) {
            User currentUser = allUsers.get(i);
            System.out.println((i + 1) + ": " + currentUser.getUserFirstname() + " " + currentUser.getUserLastname());
        }
        int userChoice = getUserInput(allUsers.size(), "a user");
        User participant = allUsers.get(userChoice - 1);

        System.out.println("Select Event");
        ArrayList<Event> allEvent = eventRepo.getAll();
        for (int i = 0; i < allEvent.size(); i++) {
            Event currentEvent = allEvent.get(i);
            System.out.println((i + 1) + ": " + currentEvent.getName());
        }
        int eventChoice = getUserInput(allEvent.size(), "a user");
        Event event = allEvent.get(eventChoice - 1);

        event.addParticipant(participant);
    }

    private static void createANewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first name ");
        String name = scanner.nextLine();
        System.out.println("Please enter the last name");
        String lastName = scanner.nextLine();
        System.out.println("Please enter the email address");
        String email = scanner.nextLine();
        System.out.println("New participant registered ");
        User user = new User(name, lastName, email);
        userRepo.saveUser(user);
    }

    private static void enterNewEvents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which event you would like to add?");
        String name = scanner.nextLine();

        System.out.println("Event Status");
        for (int i = 0; i < Status.values().length; i++) {
            Status currentStatus = Status.values()[i];
            System.out.println((i + 1) + ": " + currentStatus);
        }
        int statusChoice = getUserInput(Status.values().length, "an event status");
        Status eventStatus = Status.values()[statusChoice - 1];

        System.out.println("Write the date and time of the event dd-mm-yyyy hh:mm");
        String eventDate = scanner.nextLine();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date;
        try {
            date = simpleDateFormat.parse(eventDate);
        } catch (ParseException e) {
            System.err.println("Invaild Date format!");
            return;
        }

        System.out.println("Prize Pool");
        for (int i = 0; i < PrizePool.values().length; i++) {
            PrizePool currentPrizePool = PrizePool.values()[i];
            System.out.println((i + 1) + ": " + currentPrizePool);
        }
        int PrizePoolChoice = getUserInput(PrizePool.values().length, "a prize pool");
        PrizePool prizePool = PrizePool.values()[PrizePoolChoice - 1];

        System.out.println("Event Type");
        for (int i = 0; i < EventCategories.values().length; i++) {
            EventCategories currentCategory = EventCategories.values()[i];
            System.out.println((i + 1) + ": " + currentCategory);
        }
        int eventCategoryChoice = getUserInput(EventCategories.values().length, "an event category");
        EventCategories eventCategory = EventCategories.values()[eventCategoryChoice - 1];

        System.out.println("Event Max Participant");
        for (int i = 0; i < Participants.values().length; i++) {
            Participants currentParticipants = Participants.values()[i];
            System.out.println((i + 1) + ": " + currentParticipants);
        }
        int ParticipantsChoices = getUserInput(Participants.values().length, "max participants");
        Participants participants = Participants.values()[ParticipantsChoices - 1];

        Event event = new Event(prizePool, name, eventStatus, date, participants, eventCategory);
        eventRepo.saveEvent(event);
        System.out.println("Event was created.");
    }

    private static void displayAllPastEvents() {
        System.out.println("All Past Events");
        for (Event anEvent : eventRepo.getPastEvents()) {
            System.out.println(("    " + anEvent.getName()));
        }
    }


    private static void displayAllUpComingEvents() {
        System.out.println("All upcoming Events");
        for (Event anEvent : eventRepo.getUpcomingEvents()) {

            System.out.println(("    " + anEvent.getName()));
        }
    }

    private static void displayAllEventsWithOpeningSpots() {
        System.out.println("All Events with opening spots");
        for (Event anEvent : eventRepo.getEventsWithOpenSpots()) {
            System.out.println(("    " + anEvent.getName()));
        }
    }

    private static void display5TopEvents() {
        System.out.println("Top 5 events");
        for (Event anEvent : eventRepo.getFiveTopRatedEvents()) {
            System.out.println("    " + anEvent.getName());
        }
    }

    private static void displayAllEvents() {
        System.out.println("All events:");
        for (Event anEvent : eventRepo.getAll()) {
            System.out.println("    " + anEvent.getName() + " | " + anEvent.getEventDate() + " | " + anEvent.getPrizePool() + " | " + anEvent.getMaximalParticipants());
        }
    }

    private static void showParticipantsOfEvent() {
        System.out.println("Select Event");
        ArrayList<Event> allEvent = eventRepo.getAll();
        for (int i = 0; i < allEvent.size(); i++) {
            Event currentEvent = allEvent.get(i);
            System.out.println((i + 1) + ": " + currentEvent.getName());
        }
        int eventChoice = getUserInput(allEvent.size(), "a user");
        Event event = allEvent.get(eventChoice - 1);

        for (User participant : event.getParticipants()) {
            System.out.println(participant.getUserFirstname() + " " + participant.getUserLastname());
        }
    }

    private static int getUserInput(int maxChoices, String choiceType) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > maxChoices) {
            try {
                System.out.println("Please select " + choiceType + ": ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input can only be number. ");
            }
        }
        return choice;
    }

    private static void printHeader() {
        System.out.println("************");
        System.out.println("* Welcome  *");
        System.out.println("*   to     *");
        System.out.println("*  ROXO    *");
        System.out.println("************");
    }

    private static void printMenu() {
        System.out.println("How can I help you with?");
        System.out.println("1: Display all events");
        System.out.println("2: Display 5 Top-rated events");
        System.out.println("3: Display events with opening spot");
        System.out.println("4: Display all upcoming events");
        System.out.println("5: Display all past events");
        System.out.println("6: Enter new event");
        System.out.println("7: User registration");
        System.out.println("8: Add User to event");
        System.out.println("9: Show participants of event");
    }

}