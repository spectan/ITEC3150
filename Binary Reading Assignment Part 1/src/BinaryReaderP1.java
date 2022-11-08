import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * BinaryReaderP1 - Part one of the binary reader assignment
 * @author - Samuel Mckinney
 */
public class BinaryReaderP1 {


    public static void readDat() {
        try {
            DataInputStream input = new DataInputStream(new FileInputStream("Npc_drops.dat"));
            while(input.available() != 0) {
                System.out.println(input.readUTF());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
        catch(IOException e) {
            System.out.println("Error reading file");
        }
    }
/**
 * Main method - pilots the program
 * @param args
 * @throws Exception
 */
    public static void main(String[] args) throws Exception {
        //Re-instantiate the main class and populate the arraylist
        readDat();
    }
}
