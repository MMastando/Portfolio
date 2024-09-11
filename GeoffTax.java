package week5;

import java.util.Scanner;

public class GeoffTax {

    private static Scanner keyboard = new Scanner(System.in);
    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;
    private static final double HIGH_RATE = 0.25;
    private static final double MEDIUM_TAX = 0.10;
    private static final double AVERAGE_TAX = 0.03;


    public static void main(String[] args) {

        System.out.println("Week 5- LAB 4");

//        double income = 0.0;
//        double deduction = 0.0;
//
//        System.out.println("Enter next amount:");
//        double inputValue = keyboard.nextDouble();
//
//        while (inputValue != 0){
//            if(inputValue > 0){
//                income = income + inputValue;
//            }else{
//                deduction = deduction + Math.abs(inputValue);//taking absolute value
//            }//end of if else
//
//            System.out.println("Enter next amount:");
//            inputValue = keyboard.nextDouble();
//
//        }//end of while loop

        double income = 0.0;
        double deduction = 0.0;
        double inputValue;
        double taxable;
        char tax_group;
        double tax_owed;


        do {

            System.out.println("Enter next amount:");
            inputValue = keyboard.nextDouble();

            if (inputValue > 0){
                income = income + inputValue;
            }else{
                deduction = deduction + Math.abs(inputValue);
            }

        }while (inputValue !=0);

        taxable = computeTaxableIncome(income, deduction);
        tax_group = chooseTaxGroup(taxable);
        tax_owed = computeTax(taxable, tax_group);
        displayOutput(income,deduction,taxable,tax_group,tax_owed);




    }// end main method

    private static double computeTaxableIncome(double income, double deductions){

        double taxable = 0.0;

        if (income >= deductions){
            taxable = income - deductions;
        }

        return taxable; //return whatever you will use again
    } //end of computeTaxableIncome method

    private static char chooseTaxGroup(double taxable){
        char tax_group;

        if (taxable >= STINKING_RICH){
            tax_group = 'S';
        } else if (taxable >= QUITE_RICH) {
            tax_group = 'Q';
        } else if (taxable >= MIAMI_POOR) {
            tax_group = 'M';
        }else if (taxable >= AVERAGE){
            tax_group = 'A';
        }else if (taxable >= REALISTIC){
            tax_group = 'R';
        }else{
            tax_group = 'P';
        }
        return tax_group;
    }//end of chooseTaxGroup method



    private static double computeTax(double taxable, char tax_group){
        double tax_owed = 0.0;

        if (tax_group == 'S' || tax_group =='Q') {
            tax_owed = taxable * HIGH_RATE;
        }else if (tax_group == 'M'){
            tax_owed = taxable * MEDIUM_TAX;
        }else if (tax_group == 'A' || tax_group == 'R') {
            tax_owed = taxable * AVERAGE_TAX;
        }else if (tax_group == 'P'){
            tax_owed = 0.0;
        }else{
            System.out.println("Error!");
        }
        return (tax_owed);
    }//end of computeTaxableIncome method

    private static void displayOutput(double income, double deduction,  double taxable, char tax_group, double tax_owed){
        // must use void here^^
        System.out.println("Income =" + income);
        System.out.println("Deductions =" + deduction);
        System.out.println("Taxable income =" + taxable);
        System.out.println("Tax Group =" + tax_group);
        System.out.println("Tax Owed =" + tax_owed);


    }//end of displayOutput method



}// end of the GeoffTax class
