
/**
 * A basic bank account class with attributes,constructors and methods
 * @author clj17
 * Renamed for clarity purposes.
 */
public class SerializableAccount implements java.io.Serializable
{
	// attributes
	protected int accountNumber;
	protected String accountHolderName;
	protected double balance;
	protected String accountType;
	
	
	// constructor
	// note that there is not a no-arg constructor provided- you must
	// use the all fields constructor provided
	
	/**
	 * All fields constructor
	 * @param accountNumber
	 * @param accountHolderName
	 * @param balance
	 * @param accountType
	 */
	public SerializableAccount(int accountNumber, String accountHolderName, double balance, String accountType)
	{
		
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.accountType = accountType;
	}

	/*
	 * Method to allow funds to be deposited
	 * 
	 * @param double - the amount being deposited into bank
	 */
	public void deposit(double amount)
	{
		if (accountType.equals("credit card"))
		{
			// for credit card depost = payment
			balance = balance - amount;
		}
		else
		{
			balance = balance + amount;
		}
	}
	
	public boolean withdraw(double amount)
	{
		if (accountType.equals("credit card"))
		{
			// for credit card withdrawal adds to balance
			balance = balance + amount;
			return true;
		}
		else
		{
			if ((balance- amount) >= 0)
			{
			balance = balance - amount;
			return true;
			}
			else
			{
				return false;
			}
		}
		
	}

	/**
	 * @return the accountHolderName
	 */
	public String getAccountHolderName() {
		return accountHolderName;
	}

	/**
	 * @param accountHolderName the accountHolderName to set
	 */
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
     * Object to string
	*/
    @Override
	public String toString()
	{
		return "Account Number: " + accountNumber + ", Holder's Name: " + accountHolderName + ", Account's Type: "  + accountType + ", Existing Balance: $" + balance;
	}
	
}
