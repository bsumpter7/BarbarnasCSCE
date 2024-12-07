/*
 * Barbarnas Sumpter
 */
package a;
import java.util.ArrayList;
import java.util.Scanner;

public class DresserOrganizer {
    public static void main(String[] args) {
        // Initialize the dresser drawers
        ArrayList<String>[] dresser = new ArrayList[5];
        for (int i = 0; i < dresser.length; i++) {
            dresser[i] = new ArrayList<>();
        }

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the dresser!");
        do {
            System.out.println("\nEnter 1: to add an item");
            System.out.println("Enter 2: to remove an item");
            System.out.println("Enter 3: to print out the dresser contents");
            System.out.println("Enter 9: to quit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add an item
                    System.out.println("Enter the type\nIt may be undergarment, socks, stockings, top, bottom, or cape");
                    String type = scanner.nextLine();
                    System.out.println("Enter a color\nIt may be brown, pink, orange, green, blue, purple, or grey");
                    String color = scanner.nextLine();

                    String item = type + " " + color;

                    // Find an appropriate drawer
                    boolean added = false;
                    for (int i = 0; i < dresser.length; i++) {
                        if (dresser[i].size() < 2) { // Limit items in one drawer
                            dresser[i].add(item);
                            added = true;
                            break;
                        }
                    }
                    if (added) {
                        System.out.println(item + " added successfully!");
                    } else {
                        System.out.println("No space left in the dresser!");
                    }
                    break;

                case 2:
                    // Remove an item
                    System.out.println("Enter the type\nIt may be undergarment, socks, stockings, top, bottom, or cape");
                    String removeType = scanner.nextLine();
                    System.out.println("Enter a color\nIt may be brown, pink, orange, green, blue, purple, or grey");
                    String removeColor = scanner.nextLine();

                    String removeItem = removeType + " " + removeColor;
                    boolean removed = false;

                    for (int i = 0; i < dresser.length; i++) {
                        if (dresser[i].remove(removeItem)) {
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println(removeItem + " removed successfully!");
                    } else {
                        System.out.println(removeItem + " not found in the dresser.");
                    }
                    break;

                case 3:
                    // Print dresser contents
                    System.out.println("\nDresser Contents:");
                    for (int i = 0; i < dresser.length; i++) {
                        System.out.println("Drawer " + i + ": " + dresser[i]);
                    }
                    break;

                case 9:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
