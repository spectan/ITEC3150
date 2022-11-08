import java.io.Serializable;

/**
 * Person Class for Extra Credit Homework in ITEC 3150
 * 
 * @author cjohns25
 *
 */
public class Person implements Serializable
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return fullName;
	}

	/**
	 * @param fullName
	 * @param type
	 * @param id
	 */
	public Person(String fullName, String type, int id)
	{
		super();
		this.fullName = fullName;
		this.type = type;
		this.id = id;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName()
	{
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	// attributes of Person
	private String fullName;
	private String type; // Employee or Student
	private int id;

}
