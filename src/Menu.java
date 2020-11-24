import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        printHeader();
        printMenu();
        getUserInput();
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 5) {
            try {
                System.out.println("Please select your service. ");
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
    }

}
