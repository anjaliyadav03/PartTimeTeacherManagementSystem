import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;

        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Add teaching requirement");
                    break;
                case "2":
                    System.out.println("Register teacher");
                    break;
                case "3":
                    System.out.println("Find suitable teachers");
                    break;
                case "4":
                    System.out.println("Schedule training");
                    break;
                case "5":
                    System.out.println("View all requirements");
                    break;
                case "6":
                    System.out.println("View all teachers");
                    break;
                case "7":
                    System.out.println("View all training sessions");
                    break;
                case "0":
                    System.out.println("Saving and exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n=== Part-Time Teacher Management System ===");
        System.out.println("1. Add teaching requirement");
        System.out.println("2. Register teacher");
        System.out.println("3. Find suitable teachers");
        System.out.println("4. Schedule training");
        System.out.println("5. View all requirements");
        System.out.println("6. View all teachers");
        System.out.println("7. View all training sessions");
        System.out.println("0. Save and Exit");
        System.out.print("Enter your choice: ");
    }
}
