import java.io.File;
import java.util.Scanner;

/**
 * WordCounter - reads a .txt file, grabs all the words, adds to a BST and increments the count when a duplicate is found
 * @author - Samuel Mckinney
 */
public class WordCounter {
    public static void main(String[] args) throws Exception {
        String filename = "TedAndtheTelephone.txt"; //Filename
        BST theTree = new BST(); //Create the binary search tree
        Scanner in = new Scanner(new File(filename)); //Scans the file
        in.useDelimiter("[^a-zA-Z]+"); // Use any characters other than a-z or A-Z as delimiters
        while (in.hasNext()) { //While scanner has more to read
            Word wordToAdd = new Word(in.next().toLowerCase());
            theTree.insert(wordToAdd);        
        }
        System.out.println("Word" + "\t" + "Count");
        theTree.reverseOrder();
    }
}

