import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Use this class to generate pet.dat file for Homework 2
 * 
 * @author cjohns25
 *
 */
public class GeneratePetFile
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// create 10 dogs and cats
		ArrayList<Pet> pets = new ArrayList<Pet>();

		// create 5 dogs
		Dog d = new Dog("Spot", 2020, true, "dalmation", 86);
		pets.add(d);
		d = new Dog("Charlie", 2015, true, "spaniel", 5);
		pets.add(d);
		d = new Dog("Fritz", 2016, true, "dachshound", 7);
		pets.add(d);
		d = new Dog("Schultz", 2010, true, "German Shepherd", 60);
		pets.add(d);
		d = new Dog("Goldie", 2019, true, "Golden Lab", 50);
		pets.add(d);

		// now cats
		Cat c = new Cat("Petey", 2013, false, false, 17);
		pets.add(c);
		c = new Cat("Nico", 2013, false, false, 12);
		pets.add(c);
		c = new Cat("Fluffy", 2020, false, true, 6);
		pets.add(c);
		c = new Cat("Garfield", 1982, false, false, 29);
		pets.add(c);
		c = new Cat("Cat", 2019, false, true, 10);
		pets.add(c);

		// Now write file using ObjectOutputStream
		try
		{ // Create an output stream for file object.dat
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("pets.dat"));

			for (Pet p : pets)
			{
				output.writeObject(p);
			}
			output.close();

		} catch (IOException ex)
		{
			ex.printStackTrace();
			System.out.println("Problem writing output file");
		}

	}

}
