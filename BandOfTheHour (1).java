package midterm;

import java.util.Scanner;

/**
 * A class to manage the layout and members of a band, allowing adding and removing of musicians.
 */
public class BandOfTheHour {

//----Declare final variables
    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_ROWS = 10;
    private static final int MAX_POSITIONS = 8;
    private static double[][] bandLayout;

    /**
     * The main method that initializes the band layout and processes user commands.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
//----Welcome the user

        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");

        int numberOfRows = getValidNumber("Please enter number of rows: ", 1, MAX_ROWS);
        bandLayout = new double[numberOfRows][];

        for (int i = 0; i < numberOfRows; i++) {
            String rowName = String.valueOf((char) ('A' + i));
            int numberOfPositions = getValidNumber("Please enter number of positions in row "
                    + rowName + ": ", 1, MAX_POSITIONS);
            bandLayout[i] = new double[numberOfPositions];
        }

//----Switch statement for the menu, give user choices
        char userChoice;
        do {
            userChoice = displayMenuAndGetChoice();
            switch (userChoice) {
                case 'A':
                    addMusician();
                    break;
                case 'R':
                    removeMusician();
                    break;
                case 'P':
                    printCurrentAssignment();
                    break;
                case 'X':
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userChoice != 'X');

        scanner.close();
    } // end of the main method

    /**
     * Displays a menu and returns the user's choice.
     *
     * @return A character representing the user's choice.
     */
    private static char displayMenuAndGetChoice() {
        System.out.println("\n(A)dd, (R)emove, (P)rint, e(X)it:");
        System.out.print("Please choose an option: ");
        String input = scanner.nextLine().toUpperCase();

        if (input.length() == 1 && ("ARPX".contains(input))) {
            return input.charAt(0);
        } else {
            System.out.println("Invalid input. Please try again.");
            return '\0';
        }
    } // end of the displayMenuAndGetChoice method

    /**
     * Prompts the user for a number within a specified range and returns it.
     *
     * @param prompt  The prompt to display to the user.
     * @param minimum The minimum allowable number.
     * @param maximum The maximum allowable number.
     * @return The number provided by the user.
     */
    private static int getValidNumber(String prompt, int minimum, int maximum) {
        int number;
//----Get valid number for rows

        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("ERROR: Invalid input, try again.");
                System.out.print(prompt);
                scanner.next();
            }
            number = scanner.nextInt();
            if (number < minimum || number > maximum) {
                System.out.println("ERROR: Out of range, try again.");
            }
        } while (number < minimum || number > maximum);
        scanner.nextLine();
        return number;
    } // end of the getValidNumber method

    /**
     * Handles adding a musician by prompting for and validating the row, position, and weight.
     */
    public static void addMusician() {
//----get row position and weight for new musician

        int row = getValidRow();
        int position = getValidPosition(row);
        double weight = getValidWeight();

        double currentRowWeight = 0;
        for (double posWeight : bandLayout[row]) {
            currentRowWeight += posWeight;
        }

        double maxRowWeight = bandLayout[row].length * 100.0; // 100 kg per position
        if (currentRowWeight + weight <= maxRowWeight) {
            bandLayout[row][position] = weight;
            System.out.println("****** Musician added.");
        } else {
            System.out.println("Cannot add musician: adding this musician would exceed the weight " +
                    "limit for the row.");
        }
    }// end of addMusician method

    /**
     * Prompts the user for a row and validates the input.
     *
     * @return The valid row index as an integer.
     */
    private static int removeRow() {
        int row = -1;
        do {
            System.out.print("Please enter row letter: ");
            String input = scanner.nextLine().toUpperCase();
            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'J') {
                row = input.charAt(0) - 'A';
            } else {
                System.out.println("ERROR: Out of range, try again.");
            }
        } while (row == -1);
        return row;
    } // end of the removeRow method

    /**
     * Prompts the user for a position within a specific row and validates the input.
     *
     * @param row The row index for which the position is being added.
     * @return The valid position index as an integer.
     */
    private static int getValidPosition(int row) {
        int position = -1;
//----Get a valid position number

        do {
            System.out.printf("Please enter position number (1 to %d): ", bandLayout[row].length);
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input >= 1 && input <= bandLayout[row].length && bandLayout[row][input - 1] == 0) {
                position = input - 1;
            } else {
                System.out.println("ERROR: Out of range or position occupied, try again.");
            }
        } while (position == -1);
        return position;
    } // end of the getValidPosition method

    /**
     * Prompts the user for the musician's weight and validates the input.
     *
     * @return The valid weight as a double.
     */
    private static double getValidWeight() {
        double weight = 0;
//----gets a valid weight

        do {
            System.out.print("Please enter weight (45.0 to 200.0): ");
            double input = scanner.nextDouble();
            scanner.nextLine();
            if (input >= 45.0 && input <= 200.0) {
                weight = input;
            } else {
                System.out.println("ERROR: Out of range, try again.");
            }
        } while (weight == 0);
        return weight;
    } // end of the getValidWeight method

    /**
     * Stores the musician's weight in the specified row and position.
     *
     * @param row      The row index where the musician is to be added.
     * @param position The position index within the row where the musician is to be added.
     * @param weight   The weight of the musician to be added.
     */
    private static void storeMusician(int row, int position, double weight) {

        bandLayout[row][position] = weight;
        System.out.println("****** Musician added.");
    } // end of the storeMusician method


    /**
     * Handles removing a musician by prompting for and validating the row and position.
     */
    public static void removeMusician() {
//----Get the row and position of the musician to remove

        int row = getValidRow();
        int position = getValidPositionForRemoval(row);
        removeMusicianAtPosition(row, position);
    } // end of the removeMusician method

    /**
     * Prompts the user for a row and validates the input.
     *
     * @return The valid row index as an integer.
     */
    private static int getValidRow() {
//----Get a valid row letter

        int row = -1;
        do {
            System.out.print("Please enter row letter: ");
            String input = scanner.nextLine().toUpperCase();
            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'J') {
                row = input.charAt(0) - 'A';
            } else {
                System.out.println("ERROR: Out of range, try again.");
            }
        } while (row == -1);
        return row;
    } // end of the getValidRow method

    /**
     * Prompts the user for a position within a specific row for removal and validates the input.
     *
     * @param row The row index from which the musician is being removed.
     * @return The valid position index as an integer.
     */
    private static int getValidPositionForRemoval(int row) {
//----get position to remove

        int position = -1;
        do {
            System.out.printf("Please enter position number (1 to %d): ", bandLayout[row].length);
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input >= 1 && input <= bandLayout[row].length && bandLayout[row][input - 1] != 0) {
                position = input - 1;
            } else {
                System.out.println("ERROR: Out of range or position is vacant, try again.");
            }
        } while (position == -1);
        return position;
    } // end of the getValidPositionForRemoval method

    /**
     * Removes the musician's weight at the specified row and position.
     *
     * @param row      The row index from which the musician is to be removed.
     * @param position The position index within the row from which the musician is to be removed.
     */
    private static void removeMusicianAtPosition(int row, int position) {
        bandLayout[row][position] = 0;
        System.out.println("****** Musician removed.");
    } // end of the removeMusicianAtPosition method
//----Remove musician and prints message

    /**
     * Prints the current assignment of musicians in the band layout.
     */
    private static void printCurrentAssignment() {
//----prints out current band layout and information

        int maxPositionLength = String.valueOf(MAX_POSITIONS).length();
        for (int i = 0; i < bandLayout.length; i++) {
            double totalWeight = 0;
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < bandLayout[i].length; j++) {
                System.out.printf("%6.1f ", bandLayout[i][j]);
                totalWeight += bandLayout[i][j];
            }

            for (int k = bandLayout[i].length; k < MAX_POSITIONS; k++) {
                System.out.print("       ");
            }

            double averageWeight = bandLayout[i].length > 0 ? totalWeight / bandLayout[i].length : 0;
            System.out.printf(" [%6.1f, %6.1f]\n", totalWeight, averageWeight);
        }

    }// end of the printCurrentAssignment method

} // end of the BandOfTheHour class
