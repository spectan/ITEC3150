/**
 * Account parent class for banking information
 * @author - Samuel Mckinney
 */
public class Account {

    //attributes
    protected int accNumber;
    protected String accHolderName;
    protected String accType;
    protected double balance;

    /**
     * Constructor for our parent class, Account
     * @param accNumber
     * @param accHolderName
     * @param accType
     * @param balance
     */
    public Account(int accNumber, String accHolderName, String accType, double balance) {
        this.accNumber = accNumber;
        this.accHolderName = accHolderName;
        this.accType = accType;
        this.balance = balance;
    }

    /**
     * Method to deposit money into your checking account
     * @param amount
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }
    /**
     * Method to withdraw money from your account. Checks if you have enough money.
     * @param amount
     * @return
     */
    public boolean withdraw(double amount) {
        if((balance - amount) >= 0) {
            balance = balance - amount;
            return true;
        }
        else {
            return false;
        }

    }
    //Getters and Setters
    /**
     * @return the account number
     */
    public int getAccNumber() {
        return accNumber;
    }
    /**
     * sets the account number
     */
    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }
    /**
     * @return the account holder's name
     */
    public String getAccHolderName() {
        return accHolderName;
    }
    /**
     * sets the account holder's name.
     */
    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }
    /**
     * @return the account type
     */
    public String getType() {
        return accType;
    }
    /**
     * set the account type
     */
    public void setType(String accType) {
        this.accType = accType;
    }
    /**
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }
    /**
     * sets the account's balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Object to string
     */
    @Override
	public String toString()
	{
		return accNumber + "\n" + accHolderName + "\n"  + accType + "\n" + balance;
	}
}
