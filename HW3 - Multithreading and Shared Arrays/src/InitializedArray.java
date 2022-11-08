
/**
 * Class containing an array of 10,000,000 integers that is initialized For use
 * in Homework 3 Multithreading. This is part of the shared data.
 *
 */
public class InitializedArray
{
	protected int[] theArray = new int[10000000];

	// no arg constructor
	public InitializedArray()
	{
		for (int i = 0; i < 10000000; i++)
		{
			theArray[i] = i;
		}
	}

	/*
	 * Getter method for a single element of array
	 * 
	 * @param int - index of array
	 * 
	 * @return int - value at index
	 */;

	int getElement(int index)
	{
		return theArray[index];
	}

}
