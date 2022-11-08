import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * AutomatedBanking
 * A java program that acts as a mock ATM with a functioning forever-loop, working deposits and withdrawals, as well as reading and writing to a file.
 * @author - Samuel Mckinney
 * @date written - 8/28/21
 */
public class AutomatedBanking {
    /**
     * readFile - reads the requested file and stores it in a linked list
     * @param accounts
     * @return
     */
    public ArrayList<Account> readFile(ArrayList<Account> accounts) {

        String fileName = "accounts.txt"; // File to read
        //Placeholders
        File theFile = null;
        Scanner inputFile = null;

        try { // Open the file
            theFile = new File(fileName);
            inputFile = new Scanner(theFile);
        } catch (FileNotFoundException ex) {
            System.out.println("Specified file \"" + fileName + "\" could not be found.");
            return accounts;
        }
        try { //Read the file and create the objects from the data
            while(inputFile.hasNextLine()) {
                String plcAccNumber = inputFile.nextLine();
                int accNumber = Integer.parseInt(plcAccNumber);
                String accHolderName = inputFile.nextLine();
                String accType = inputFile.nextLine();
                String plcBalance = inputFile.nextLine();
                double balance = Double.parseDouble(plcBalance);
                if(accType.equals("credit card")) {
                    String plcLimit = inputFile.nextLine();
                    double limit = Double.parseDouble(plcLimit);
                    accounts.add(new CreditAccount(accNumber, accHolderName, accType, balance, limit));
                }
                else {
                    accounts.add(new Account(accNumber, accHolderName, accType, balance));
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Could not read the file, check directory and values");
        } finally {
            inputFile.close();
        }
        return accounts;
    }

    /**
     * writeFile - writes to the file specified in the method when given an appropriate list
     * @param accounts
     */
    public static void writeFile(ArrayList<Account> accounts) {
        ListIterator<Account> listIterator = accounts.listIterator();

        String fileName = "accounts.txt"; // File to write
        //Placeholders
        File theFile = null;
        PrintWriter writer = null;

        try { //Open the file
            theFile = new File(fileName);
            writer = new PrintWriter(theFile);
        } catch(IOException ex) {
            System.out.println("Unable to open \"" + fileName + "\". Check the directory and name.");
        }
        try { //Write to the file
            while(listIterator.hasNext()) {
                writer.print(listIterator.next() + "\n");
            }
        } catch (Exception ex) {
            System.out.println("There was a problem writing to \"" + fileName + "\"");
        } finally {
            writer.close();
        }
    }

    /**
     * findAccount - finds the specified account by matching the account numbers and returns the index of the object in the list
     * @param accounts
     * @param accNumber
     * @return
     */
    public static int findAccount(ArrayList<Account> accounts, int accNumber) {
        int accIndex = 999;

        //Iterates through the arraylist to find the account, when it does, returns the index.
        for(Account a: accounts) {
            if(a.getAccNumber() == accNumber) {
                accIndex = accounts.indexOf(a);
            }
        }
    
        return accIndex;
    }

    /**
     * bankTeller - effectively does all the functions of the teller, including deposits and withdrawals.
     * @param accounts
     * @param accIndex
     */
    public static void bankTeller(ArrayList<Account> accounts, int accIndex) {
        Scanner input = new Scanner(System.in);
        String choice = "q";
        double amount = 0;

        //Determine if the account is a credit card account or not.
        boolean isCredit = false;
        if(accounts.get(accIndex).getType().equals("credit card")) {
            isCredit = true;
        }

        if(isCredit == true) { // Credit path
            //Display the account's information.
            System.out.println("Welcome " + accounts.get(accIndex).getAccHolderName() + ".");
            System.out.printf("Your current owed balance is: $%.2f. Your current limit is: $%.2f. \n", accounts.get(accIndex).getBalance(), ((CreditAccount)accounts.get(accIndex)).getLimit());
            //Account actions
            do {
                System.out.println("Enter 'D' to make a payment towards your balance, enter 'W' to withdraw some cash, or enter 'Q' to quit.");
                choice = input.next();

                if(choice.equalsIgnoreCase("d")) { //Deposits
                    try {
                    System.out.println("How much would you like to put towards your balance?");
                    amount = input.nextDouble();
                    accounts.get(accIndex).deposit(amount);
                    System.out.printf("Your new balance is $%.2f. \n", accounts.get(accIndex).getBalance());
                    } catch (Exception ex) { // Verifies the amount input is actually a number, otherwise catches the exception
                        System.out.println("I'm sorry, I couldn't figure out the number you input, please try again.");
                        input.nextLine();
                    }
                }

                if(choice.equalsIgnoreCase("w")) { //Withdrawal
                    try {
                    System.out.println("How much would you like to withdraw from your account?");
                    amount = input.nextDouble();
                    if(((CreditAccount)accounts.get(accIndex)).withdraw(amount)) { //Checks if it puts it over our limit
                        System.out.printf("Your new balance is $%.2f. \n", accounts.get(accIndex).getBalance());
                    }
                    else {
                        System.out.println("I'm sorry, that would put you over your limit.");
                    }
                    } catch (Exception ex) { // Verifies the amount input is actually a number, otherwise catches the exception
                        System.out.println("I'm sorry, I couldn't figure out the number you input, please try again.");
                        input.nextLine();
                    }
                }
            } while(!choice.equalsIgnoreCase("q"));
        }

        if(isCredit == false) { // Banking path
            //Display the account's information.
            System.out.println("Welcome " + accounts.get(accIndex).getAccHolderName() + ".");
            System.out.printf("Your current balance is: $%.2f. \n", accounts.get(accIndex).getBalance());
            //Account actions
            do {
                System.out.println("Enter 'D' to make a deposit, enter 'W' to withdraw some cash, or enter 'Q' to quit.");
                choice = input.next();

                if(choice.equalsIgnoreCase("d")) { //Deposits
                    try {
                    System.out.println("How much would you like to deposit");
                    amount = input.nextDouble();
                    accounts.get(accIndex).deposit(amount);
                    System.out.printf("Your new balance is $%.2f. \n", accounts.get(accIndex).getBalance());
                    } catch (Exception ex) { // Verifies the amount input is actually a number, otherwise catches the exception
                        System.out.println("I'm sorry, I couldn't figure out the number you input, please try again.");
                        input.nextLine();
                    }
                }

                if(choice.equalsIgnoreCase("w")) { //Withdrawal
                    try {
                    System.out.println("How much would you like to withdraw from your account?");
                    amount = input.nextDouble();
                    if(accounts.get(accIndex).withdraw(amount)) { //Checks if it puts it under zero.
                        System.out.printf("Your new balance is $%.2f. \n", accounts.get(accIndex).getBalance());
                    }
                    else {
                        System.out.println("I'm sorry, that would overdraft your account.");
                    }
                    } catch (Exception ex) { // Verifies the amount input is actually a number, otherwise catches the exception
                        System.out.println("I'm sorry, I couldn't figure out the number you input, please try again.");
                        input.nextLine();
                    }
                }
                input.nextLine();
                //input.close();
            } while(!choice.equalsIgnoreCase("q"));
        }
    }

    /**
     * Main method
     * This will serve primarily as the runner for all of the above methods.
     * @param args
     */
    public static void main(String[] args) {

        //Reinstantiate the main class to read in the array list
        AutomatedBanking bank = new AutomatedBanking();
        ArrayList<Account> accList = new ArrayList<Account>();
        accList = bank.readFile(accList);
    
        while(true) { // Infinite loop
            Scanner input = new Scanner(System.in);
            int accNumber, accIndex;
            try { //Asks for account number and ensures the number input is an appropriate number.
                System.out.println("Please enter your account number or enter 'Q' to quit.");
                String placeholder = input.nextLine();
                if(placeholder.equalsIgnoreCase("q")) {
                    input.close();
                    break;
                }
                accNumber = Integer.parseInt(placeholder);
                accIndex = findAccount(accList, accNumber);
                if(accIndex != 999) {
                    bankTeller(accList, accIndex);
                    writeFile(accList); // Saves the updated account list.
                }
                else {
                    System.out.println("I'm sorry, we couldn't find that account.");
                }
            } catch (Exception ex) {
                System.out.println("I'm sorry, that doesn't appear to be a number.");
                input.nextLine();
            }
        }
    }
}
