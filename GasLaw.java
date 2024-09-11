package week2;

import java.util.Scanner;

//=============================================================================
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K
    private static final double GAS_CONSTANT = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double volume, moles, temperature;
        double pressure;

//----Get 3 inputs from user
        System.out.print("Enter volume, moles, temperature : ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temperature = keyboard.nextDouble();

//----Calculate the pressure
        pressure = moles * GAS_CONSTANT * temperature / volume;

//----Output pressure result to screen
        System.out.println("Pressure is " + pressure);
    }// end main method
}//end of GasLaw class
//-----------------------------------------------------------------------------
//=============================================================================
