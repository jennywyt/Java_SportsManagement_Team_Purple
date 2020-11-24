import java.util.Date;
import java.util.Scanner;

public class Menu {
    static EventRepo eventRepo = new EventRepo();

    public static void main(String[] args) {
        printHeader();
        printMenu();

        int userInput;

        do {
            userInput = getUserInput(6, "your service");
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
            }
        } while (userInput != 0);
    }

    private static void enterNewEvents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which event you would like to watch?");
        String name = scanner.nextLine();
        System.out.println("How much you would like to put in the price pool?");
        double pricePool = scanner.nextDouble();
        System.out.println("Event Type");
        for (int i = 0; i < EventCategories.values().length; i++) {
            EventCategories currentCategory = EventCategories.values()[i];
            System.out.println((i + 1) + ": " + currentCategory);
        }

        int eventCategoryChoice = getUserInput(EventCategories.values().length, "an event category");
        EventCategories eventCategory = EventCategories.values()[eventCategoryChoice];
        Event event = new Event(name, "New", pricePool, new Date(), 4);
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
            System.out.println("    " + anEvent.getName());
        }
    }

    private static int getUserInput(int maxChoices, String choiceType) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > maxChoices) {
            try {
                System.out.println("Please select " + choiceType + ". ");
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

    }
}