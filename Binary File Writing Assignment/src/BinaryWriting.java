/**
 * BinaryWriting - Opens a text file, saves the information in an
 * arraylist before writing it to a binary file.
 * @author - Samuel Mckinney
 */

 import java.util.ArrayList;
 import java.io.File;
 import java.io.*;
 import java.util.Scanner;

public class BinaryWriting {

    /**
     * Reads in accounts.txt, converts each line to the appropriate type, and adds it to the arraylist.
     * @param accountItems
     * @return
     */
    public ArrayList<Account> readFile(ArrayList<Account> accountItems) {
        String fileName = "accounts.txt"; //File to be read
        //Placeholders
        File theFile = null;
        Scanner inputFile = null;

        //Open the file
        try {
            theFile = new File(fileName);
            inputFile = new Scanner(theFile);
        } catch (FileNotFoundException ex) {
            System.out.println("Specified file \"" + fileName + "\" could not be found.");
            return accountItems;
        }
        //Read the file
        try {
            while(inputFile.hasNextLine()) {
                String placeholderAccountNumber = inputFile.nextLine();
                int accountNumber = Integer.parseInt(placeholderAccountNumber); // Converts string to int
                String accountHolderName = inputFile.nextLine();
                String accountType = inputFile.nextLine();
                String placeholderBalance = inputFile.nextLine();
                double balance = Double.parseDouble(placeholderBalance); //Converts string to double
                //Add the information to the arraylist
                accountItems.add(new Account(accountNumber, accountHolderName, balance, accountType));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("There was trouble reading the file, check the directory or listed value type.");
        } finally {
            inputFile.close(); // Close the scanner
        }

        return accountItems;
    }
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        //Create an instance of the class and an arraylist to store the read values.
        BinaryWriting binWriter = new BinaryWriting();
        ArrayList<Account> accountList = new ArrayList<Account>();
        accountList = binWriter.readFile(accountList);

        //Writes the information to accounts.dat
        try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream("accounts.dat"));
            for(Account a: accountList) {
                output.writeInt(a.accountNumber);
                output.writeUTF(a.accountHolderName);
                output.writeUTF(a.accountType);
                output.writeDouble(a.balance);
            }
            output.close();
        } catch (IOException ex) {
            System.out.println("Couldn't write to the file.");
            System.exit(0);
        }
        /**
         * For testing the output of the .dat file
        try {
            DataInputStream input = new DataInputStream(new FileInputStream("accounts.dat"));

            for(int i=0;i<5;i++) {
                            System.out.println(input.readInt() + " "
             + input.readUTF() + " " + input.readUTF() + " " + input.readDouble());
            }
        } catch (IOException ex) {
            System.out.println("Problem reading the data file");
            System.exit(0);
        }
        */
    }
}
