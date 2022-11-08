/**
 * ArraySplitter - this splits a bigger array into ten smaller arrays and sums up all objects inside each array
 * before passing the sum to something that sums all the subsums using multithreading.
 * @author - Samuel Mckinney
 */
public class ArraySplitter {
    /**
     * Main method - drives the creation of the big array, the splitting, and calling for the sum.
     * @param args
     */
    public static void main(String[] args) {
        //Create the big array and the subsummer instances
        InitializedArray bigarray = new InitializedArray();
        SubSummer sumArray = new SubSummer();

        //Set up a for-loop to create all ten threads for us.
        //Each thread is passed the array, and the iteration of the for loop * 1 million, so each index passed to the thread is the appropriate million
        final int threads = 10;
        final int iterator = 1000000;
        for(int i = 0; i < threads; i++) {
            //Creates the thread per loop to be ran and runs it.
            ArraySummer a = new ArraySummer(bigarray.theArray, i*iterator, sumArray, i);
            a.run();
        }
    } 
}

/**
 * ArraySummer - this sums up every element of the passed array.
 */
class ArraySummer implements Runnable {
    //Holds the starting index, threadNumber, the sum, and the shared array.
    protected int start, threadNum;
    protected long sum;
    protected SubSummer sumArray;

    /**
     * Constructor
     * @param arr
     * @param startIndex
     * @param sumArray
     * @param i
     */
    public ArraySummer(int[] arr, int startIndex, SubSummer sumArray, int i) {
        start = startIndex;
        this.sumArray = sumArray;
        threadNum = i;
    }
    
    /**
     * Runs the thread
     */
    @Override
    public void run() {
        //Holds the subsum and ncreases it by adding the values of i at that index
        sum = 0;
        for(int i = start; i < start+1000000; i++) {
            sum = i + sum;
        }
        //Prints the subsum and adds it to the arraylist.
        System.out.println("Thread " + threadNum + " complete. Subsum is: " + sum);
        sumArray.addElement(sum);
        
        //If this is the last thread to run, as in the tenth element of the list, post the final sum.
        if(sumArray.getSize() == 10) {
            sumArray.sumSubSums();
        }
    }
}
