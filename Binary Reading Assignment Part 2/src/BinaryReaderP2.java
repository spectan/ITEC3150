import java.io.*;

/**
 * BinaryReaderP2 - Part two of the binary reader assignment
 * @author - Samuel Mckinney
 */
public class BinaryReaderP2 {
    /**
     * writeBinary - writes the hardcoded objects to accounts2.dat
     * @param accountList
     */
    public static void writeBinary() {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream("accounts2.dat")); //Creates an instance of ObjectOutputStream and FileOutputStream to output to file named accounts2.dat.

            //Defines the five objects to write.
            objectOutput.writeObject(new SerializableAccount(1111, "Iron Man", 6000, "credit card"));
            objectOutput.writeObject(new SerializableAccount(2222, "Spiderman", 300, "checking"));
            objectOutput.writeObject(new SerializableAccount(3333, "Black Widow", 60000, "checking"));
            objectOutput.writeObject(new SerializableAccount(4444, "Black Panther", 5000, "credit card"));
            objectOutput.writeObject(new SerializableAccount(5555, "Doctor Strange", 200, "checking"));

            objectOutput.close(); // Close the OOS.
        } catch (Exception ex) {
            System.out.println("We were unable to write to a file, ensure the arraylist was populated with appropriate data type.");
            ex.printStackTrace();
        }
        
    }

/**
 * Main method - pilots the program
 * @param args
 * @throws Exception
 */
    public static void main(String[] args) throws Exception {
        writeBinary(); //Writes the accounts to the .dat file

        try {
            //Creates an instance of FileInputStream to read accounts2.dat and then passes that to ObjectInputStream to read the serialized information as objects.
            FileInputStream fileInput = new FileInputStream("accounts2.dat");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            while(fileInput.available() != 0) {
                    System.out.println(((SerializableAccount)objectInput.readObject()).toString()); //Calls the toString method of the object to print it to console.
            }
            
            objectInput.close(); //Close the OIS.
        } catch (Exception ex) { //Catch any further exceptions.
            System.out.println("There was an error reading the file. Please check the name");
        }
    }
}
