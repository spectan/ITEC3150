import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SubSummer - a class to share a thread-safe arraylist.
 * @author - Dr. Johnson
 * @modified by - Samuel Mckinney
 */
public class SubSummer {
    //Initialize the list and the lock, as well as the sum value for the sumSubSums method.
    protected ArrayList<Long> subSums = new ArrayList<>();
    protected Lock aLock = new ReentrantLock();
    protected long sum;

    /**
     * Thread-safe method to add an element to the list
     * @param subSum
     */
    public void addElement(long subSum) {
        aLock.lock();
        try {
            subSums.add(subSum);
        } finally {
            aLock.unlock();
        }
    }

    /**
     * Thread-safe method to retrieve an element from the list
     * @param index
     * @return
     */
    public long getElement(int index) {
        aLock.lock();
        try {
            return subSums.get(index);
        } finally {
            aLock.unlock();
        }
    }

    /**
     * Returns the size of the arraylist
     * @return
     */
    public int getSize() {
        return subSums.size();
    }

    /**
     * Sums the subsums
     */
    public void sumSubSums() {
        sum = 0;
        for(int i = 0; i < subSums.size(); i++) {
            sum = sum + subSums.get(i);
        }
        System.out.println("Final sum is: " + sum);
    }
}