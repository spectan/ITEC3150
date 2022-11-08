import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 * Class: Library
 * 
 * @author Dr. Johnson
 * @modified by - Samuel Mckinney
 * @version 1.0 Course : ITEC 3150, Fall, 2020 Written: September 9 , 2020
 * 
 * 
 *          This class � This class describes library used to contain the Pet
 *          library.
 * 
 *          Purpose: � Methods and attributes needed to create a library of
 *          Pet objects. Print them, read them from a file,search for a
 *          particular id and add a new item.
 *
 */
public class Library
{

	// actual library data
	private ArrayList<Pet> libraryItems = new ArrayList<Pet>();

	public ArrayList<Pet> getTheList()
	{
		return libraryItems;
	}

	/**
	 * Method:printLibraryItems()
	 * 
	 * This method prints the library items contained in the libraryItems Array
	 * list. It relies on the toString method of the various Pet types to print
	 * the items in a user friendly format.
	 * 
	 * 
	 */
	public void printLibraryItems()
	{
		for (int i = 0; i < libraryItems.size(); i++)
		{
			Pet temp = libraryItems.get(i);
			System.out.println(temp);
		}

	}

	/**
	 * Method:addItem()
	 * 
	 * This method adds the parameter m to the libraryItems array list
	 * 
	 * @param m
	 * 
	 */
	public void addItem(Pet m)
	{
		libraryItems.add(m);
	}

	/**
	 * Method:deleteItem()
	 * 
	 * This method deletes the parameter m from the libraryItems array list
	 * 
	 * @param m
	 * @return
	 * 
	 */
	public void deleteItem(String m)
	{
		Pet item = searchByName(m);
		if (item != null)
		{
			libraryItems.remove(item);
		} else
		{
			System.out.println("Can not delete- item number does not exist");
		}

	}

	/**
	 * Method:searchById()
	 * 
	 * This method looks at each item in the Pet array list and if its name
	 * attribute matches the input name, that item is returned to the caller. It
	 * returns null if item is not found.
	 * 
	 * @param name
	 * 
	 * @return Pet
	 * 
	 */
	public Pet searchByName(String name)
	{
		Pet item = null;
		for (Pet temp : libraryItems)
		{

			if (temp.getName().equalsIgnoreCase(name))
			{
				item = temp;
			}

		}
		return item;
	}

	/**
	 * readBinaryFile()
	 * 
	 * This method populates the libraryItems array list from a binary files
	 */
	public void readBinaryFile()
	{
		try
		{ // Create an input stream for file object.dat
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("pets.dat"));
			while (true)
			{
				Pet m = (Pet) input.readObject();
				addItem(m);
			}
		} catch (EOFException ex)
		{
			// do nothing reached the end of the file
		} catch (IOException i)
		{
			System.out.println("Unable to read from file");
			i.printStackTrace();
		} catch (ClassNotFoundException c)
		{
			System.out.println("Object read is not a java.util.Date instance");
		}

	}

	/**
	 * writeListToFile()
	 * 
	 * This method overwites the original binary file with contents of items
	 * 
	 * @param ObservableList<Pet>
	 */
	public void writeListToFile(ObservableList<Pet> items)
	{
		try
		{ // Create an input stream for file object.dat
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("pets.dat"));
			for (Pet p : items)
			{
				output.writeObject(p);

			}
			output.close();
		} catch (IOException i)
		{
			System.out.println("Unable to write to file");
			i.printStackTrace();
		}

	}

}
