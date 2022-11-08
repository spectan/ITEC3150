
/**
 * Multithreading - Multithreading Class Assignment
 * @author -- Dr Johnson
 * @modified by - Samuel Mckinney
 * 
 */
public class Multithreading
{
    public static void main(String[] args)
    {
        //Define the threads and the tasks
        Runnable printForward = new PrintIntegerForward(1000);
        Thread thread1 = new Thread(printForward);
        Runnable printReverse = new PrintIntegerReverse(2000, 1000);
        Thread thread2 = new Thread(printReverse);

        //Start the threads
        thread1.start();
        thread2.start();
    }
}

/**
 * PrintIntegerForward - Counts from 0 to 1000 with a one second interval between each.
 */
class PrintIntegerForward implements Runnable
{
    //Stores the maximum number.
    private int maxNum;
    
    /**
     * Constructs the task
     * @param n - maximum value for the loop
     */
    public PrintIntegerForward(int n)
    {
        maxNum = n;
    }

    @Override
    /**
     * Instructions to print each number on a new line every second.
     */
    public void run()
    {
        try {
            for(int i = 1; i <= maxNum; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

/**
 * PrintIntegerReverse - Counts from 2000 to 1000 with a two second interval between each.
 */
class PrintIntegerReverse implements Runnable
{
    //Stores the maximum and minimum nubmers.
    private int maxNum;
    private int minNum;

    /**
     * Constructs the task
     * @param n - maximum value for the loop
     * @param mn - minimum value for the loop
     */
    public PrintIntegerReverse(int n, int mn)
    {
        maxNum = n;
        minNum = mn;
    }

    @Override
    /**
     * Instructions to print each number on a new line every two seconds.
     */
    public void run()
    {
        try {
            for(int i = maxNum; i >= minNum; i--) {
                System.out.println(i);
                Thread.sleep(2000);
            }
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}