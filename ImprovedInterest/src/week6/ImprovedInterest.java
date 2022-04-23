package week6;

import java.util.Scanner;

public class ImprovedInterest {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        boolean playing = true;

        do {
            double depositAmount = 0;
            double annualIntRate = 0;
            int numOfMonths = 0;

            System.out.println("This program will ask the user for a monthly deposit, an annual interest rate and the number of months the user plans on saving.");
            System.out.println("It will then show the monthly balance over the period of planned savings.");
            System.out.println();

            // Deposit Amount each Month
            boolean depositAmountValid = false;
            do {
                System.out.print("Please enter the amount to be deposited each month: ");
                try {
                    depositAmount = Double.parseDouble(userInput.nextLine());
                    depositAmountValid = true;
                }
                catch (Exception e) {
                    System.out.println("Invalid response! Please enter a number.");
                    System.out.println();
                }
            } while(!depositAmountValid);

            // Annual Interest Rate
            boolean annualIntRateValid = false;
            do {
                System.out.print("Please enter the annual interest rate: ");
                try {
                    annualIntRate = Double.parseDouble(userInput.nextLine());
                    annualIntRateValid = true;
                }
                catch (Exception e) {
                    System.out.println("Invalid response! Please enter the correct annual interest rate.");
                    System.out.println();
                }
            } while(!annualIntRateValid);

            // Number of Months
            boolean numOfMonthsValid = false;
            do {
                System.out.print("Please enter the number of months you plan to save: ");
                try {
                    numOfMonths = Integer.parseInt(userInput.nextLine());
                    numOfMonthsValid = true;
                }
                catch (Exception e) {
                    System.out.println("Invalid response! Please enter a whole number.");
                    System.out.println();
                }
            } while(!numOfMonthsValid);

            System.out.println();
            System.out.println("The following table shows the balance of the account for each month of the designated savings period.");
            System.out.print("Month");
            System.out.print("\t\t");
            System.out.print("Balance");


            double interestRate = ((annualIntRate / 100 / 12) + 1);
            double previousBalance = 0;

            for(int year = 1; year <= numOfMonths; year++) {
                depositAmount *= interestRate;
                previousBalance += depositAmount;

                System.out.println();
                System.out.printf("Month" + year + ":");
                if (year < 10) {
                    System.out.print("\t\t");
                }
                else {
                    System.out.print("\t");
                }
                System.out.printf("$%,.2f", previousBalance);
            }

            System.out.println();
            System.out.print("Would you like to make another calculation? (Y/N): ");
            String userPlayAgain = userInput.nextLine();

            if (userPlayAgain.equalsIgnoreCase("Y")) {
                playing = false;
                System.out.println();
            }
            else if (userPlayAgain.equalsIgnoreCase("N")){
                playing = true;
            }

        } while(!playing);

    }
}
