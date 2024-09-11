package week4;

import java.util.Scanner;

public class Scuba {

    private static Scanner keyboard = new Scanner(System.in);

//----Declare Constants
    private static final int FEET_PER_ATMOSPHERE = 33;
    private static final double MAX_OXYGEN_PRESSURE = 1.4;
    private static final double MAX_CONTINGENCY_PRESSURE = 1.6;


    public static void main(String[] args) {

        System.out.println("WEEK 4 - LAB 3");

//---Get Input Variables
        int depth;
        int oxygen;

//----Get Inputs
        System.out.print("Enter depth and percentage O2 : ");
        depth = keyboard.nextInt();
        oxygen = keyboard.nextInt();

//----Get calculation variables
        double ambient_pressure;
        double partial_pressure;
        boolean max_partial_pressure;
        boolean max_contingency_pressure;

//----Compute pressures
        ambient_pressure = (double)(depth/FEET_PER_ATMOSPHERE)+1;
        partial_pressure = (oxygen/100.0)*(ambient_pressure);
        char oxygen_group = (char)((int)(partial_pressure * 10)+(int)('A'));



//----Create Outputs

        System.out.println("Ambient Pressure: " + ambient_pressure);
        System.out.println("O2 pressure: " + partial_pressure);
        System.out.println("O2 group: " + oxygen_group);

//----Create Warnings
        if (partial_pressure > MAX_OXYGEN_PRESSURE) {
            max_partial_pressure = true;
        } else {
            max_partial_pressure = false;
        }

        if (partial_pressure > MAX_CONTINGENCY_PRESSURE) {
            max_contingency_pressure = true;
        } else {
            max_contingency_pressure = false;
        }

//----Print
        System.out.println("Exceeds Max O2 Pressure: " + max_partial_pressure);
        System.out.println("Exceeds Max Contingency Pressure: " + max_contingency_pressure);

    }//end main method

}//end Scuba class
