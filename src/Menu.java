import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        printHeader();
        printMenu();

        int userInput;

        do {
            userInput = getUserInput(6,"your service");
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
        String pricePool = scanner.nextLine();
        System.out.println("Event Type");
        for (int i = 0; i < EventCategories.values().length; i++) {
            EventCategories currentCategory = EventCategories.values()[i];
            System.out.println((i + 1) + ": " + currentCategory);
        }

        int eventCategoryChoice = getUserInput(EventCategories.values().length, "an event category");
        EventCategories eventCategory = EventCategories.values()[eventCategoryChoice];
        Event event = new Event();
    }

    private static void displayAllPastEvents() {

    }


    private static void displayAllUpComingEvents() {
    }

    private static void displayAllEventsWithOpeningSpots() {
    }

    private static void display5TopEvents() {
    }

    private static void displayAllEvents() {
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