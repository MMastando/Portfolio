package week3;

import java.util.Scanner;


public class KangarooKill {
    private static Scanner keyboard = new Scanner(System.in);
//---- Create Constants etc. ABOVE the main
    private static final double KILL_CONSTANT = 1.47;
    private static final double ROAD_WIDTH_CONSTANT = 0.010; // change from meters to kilometers

    public static void main(String[] args) {
        
        System.out.println("WEEK 3, LAB 2");

//---- Create double variables
        double length_of_land;
        double length_of_road;
        double number_of_kangaroos;

//---- Get 3 inputs from user
        System.out.print("Enter the length of the side of square of land in km : ");
        length_of_land = keyboard.nextDouble();
        System.out.print("Enter the length of the road in km : ");
        length_of_road = keyboard.nextDouble();
        System.out.print("Enter the number of kangaroos living in the area : ");
        number_of_kangaroos = keyboard.nextDouble();

//---- Create double variables
        double kangaroo_density;
        double surface_area;
        double killed_and_injured;

//---- Calculate kangaroo death and injuries
        kangaroo_density = number_of_kangaroos / (length_of_land * length_of_land);
        surface_area = length_of_road * ROAD_WIDTH_CONSTANT;
        killed_and_injured = (kangaroo_density) * (surface_area) * KILL_CONSTANT;

//---- Output number of kangaroos killed and injured
        System.out.println("Expected number of kills :  " + (int)(killed_and_injured)); // use (int)
        System.out.print("Expected number of injuries : " + (int)(Math.ceil(killed_and_injured % 1))); // capital M for Math




    } // end of the main method
    
} // end of the KangarooKill class
