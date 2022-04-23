package week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayListDup {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean  valid = true;

        do {
            System.out.println("This program will ask the user to enter a series of numbers.");
            System.out.println("The user may enter as many numbers as they wish, hitting the enter key with no data when they wish to stop.");
            System.out.println("The program will then display the array of numbers and the sum total of those numbers.");


            boolean inPlay = true;
            ArrayList<Integer> value = new ArrayList <Integer>();

            do {
                System.out.println();
                System.out.println("Please enter a number (or just hit enter to finish): ");
                String input = in.nextLine();
                if (input.equals("")) {
                    break;
                }
                try {
                    int number = Integer.parseInt(input);
                    value.add(number);
                    valid = true;
                }catch(Exception e) {
                    System.out.println("Invalid response! Please enter a whole number: ");
                }

            }while(true);

            System.out.println("Index" + "\t" + "Item" );

            for(int i = 0; i < value.size(); i++ ) {

                System.out.printf("%d\t %d", i , value.get(i));
                System.out.println("\n");
            }
            System.out.println("There are " + value.size() + " items in the ArrayList.");
            int sumArray = sumValues(value);
            System.out.println("The sum total of numbers in the ArrayList is: " + sumArray);
            String duplicateValues = dups(value);
            System.out.println("The following numbers were duplicated in the ArrayList: " + duplicateValues);


            do {
                System.out.println("Do you wish to play again? (Y/N) ");
                String userRespond = in.nextLine();
                if(userRespond.equalsIgnoreCase("y")) {
                    valid = false;
                    break;
                }else if(userRespond.equalsIgnoreCase("n")){
                    inPlay = true;
                    valid = true;
                    break;
                }else
                    System.out.println("Invalid response! Please enter either a 'Y' or 'N'");
                inPlay = false;
            }while(!inPlay);

        }while(!valid);




    }//Main Class close bracket



    private static String dups(ArrayList<Integer>value) {

        Collections.sort(value);
        ArrayList<Integer> duplicate = new ArrayList <Integer>();
        ArrayList<Integer> nonDuplicate = new ArrayList <Integer>();
        String toString = "";
        for(int i = 0; i < value.size(); i++){
            List<Integer> inputSub = value.subList( i + 1, value.size());
            //System.out.println("Comparing" + value.get(i).toString()+ "with sublist:" + inputSub.toString());
            for(Integer Duplicates: inputSub) {
                duplicate.remove(Duplicates);
                if(inputSub.contains(value.get(i))) {
                    duplicate.add(value.get(i));
                }
            }
        }

        for(Integer nonDuplicateValue: duplicate) {
            if (!nonDuplicate.contains(nonDuplicateValue)) {
                nonDuplicate.add(nonDuplicateValue);
                toString = String.valueOf(nonDuplicate);
            }
        }


        return toString;
    }








    private static int sumValues(ArrayList<Integer> value) {
        int totalScore = 0;
        for (int i = 0; i < value.size(); i++) {
            totalScore += value.get(i);
        }

        return totalScore;
    }
}
