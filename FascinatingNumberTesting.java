package week6;

import java.util.Scanner;

public class FascinatingNumberTesting {

    private static Scanner keyboard = new Scanner(System.in);

    private static final int MAX_NUMBERS = 10;
    private static final int STOP_INPUT_VALUE = 0;


    public static void main(String[] args) {

        System.out.println("WEEK 6 - LAB 5");

        int [] myArray = new int [MAX_NUMBERS];

        int count = getCandidates(myArray);

        int index;

        for (index = 0; index < count; index++) {
            int currentValue = myArray[index];

            if (isPrime(currentValue) && isFibonacci(currentValue)) {
                System.out.println(currentValue + "is fibonacci and a prime");
            } else if (isFibonacci(currentValue) && !isPrime(currentValue)){
                System.out.println(currentValue + "It's fibonacci but not prime");
            }else if (!isFibonacci(currentValue) && isPrime(currentValue)){
                System.out.println(currentValue + "is not fibonacci but is prime");
            }else{
                System.out.println(currentValue + "is not fibonacci and not prime");
            }

        }

    }// end of the main method


    private static int getCandidates(int[] candidates){// declare array []   in get candidate

        int index = 0;
        int inputValue = 0;
        System.out.println("Please enter numbers (0-stop):");

        do {
            inputValue = keyboard.nextInt();
            if (inputValue > 0){
                candidates[index] = inputValue;
                index++;

                }
        }while (inputValue != STOP_INPUT_VALUE && index < MAX_NUMBERS);
        return index;


    }// end of getCandidates method

    private static boolean isPrime(int aNumber){

        int divisor = 2;
        int index;
        for(index=2; index <= Math.sqrt(aNumber); index++) {
            if (aNumber % divisor == 0) {
                return false;
            }
            divisor ++;
        }// end of the loop

        return true;

    }// end of isPrime method

    private static boolean isFibonacci (int aNumber) {

        int previous = 1;
        int current = 0;
        int next;
        int index;

        while (current <= aNumber) {
            next = current + previous;
            previous = current;
            current = next;
        }

        return current == aNumber;

    } // end of IsFibonacci method


}// end of the FascinatingNumberTesting class












