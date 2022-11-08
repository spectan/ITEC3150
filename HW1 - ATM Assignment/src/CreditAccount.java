/**
 * Extends the account class for credit card accounts.
 * @author - Samuel Mckinney
 */
public class CreditAccount extends Account {

    //Attributes
    protected double limit;

    /**
     * Constructor
     * @param accNumber
     * @param accHolderName
     * @param accType
     * @param balance
     * @param limit
     */
    public CreditAccount(int accNumber, String accHolderName, String accType, double balance, double limit) {
        super(accNumber, accHolderName, accType, balance);
        this.limit = limit;
    }

    /**
     * Method to make a payment on your card
     * @param amount
     */
    public void deposit(double amount) {
        if((balance - amount) < 0) {
            System.out.println("You would have overpaid your balance, the remainder has been returned.");
            setBalance(0);
        }
        else {
            setBalance(balance - amount);
        }
    }
    /**
     * Method to check if the new requested balance would be over the limit, and modifies it accordingly
     * Returns true if the amount won't put you over the limit
     * @param amount
     * @return
     */
    public boolean withdraw(double amount) {
        if((balance + amount) < limit) {
           setBalance(getBalance() + amount);
           return true;
        }
        else {
            return false;
        }
    }
    //Getters and Setters
    /**
     * @return the limit
     */
    public double getLimit() {
        return limit;
    }
    /**
     * set the account's limit
     */
    public void setLimit(double limit) {
        this.limit = limit;
    }

    /**
     * Object to string
     */
    @Override
	public String toString()
	{
		return accNumber + "\n" + accHolderName + "\n"  + accType + "\n" + balance + "\n" + limit;
	}
}
