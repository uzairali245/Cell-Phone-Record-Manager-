//-------------------------------------------------------------------------------------
// 
// Part: 2
// Written by: Uzair Ali ()
//-------------------------------------------------------------------------------------

package comp249a3p2;

import java.util.Scanner;
//Privacy leak: Uses the Instance variables from CellListUtilization for keyInputs
//as we can directly modify instance variable outside class
public class CellPhone {
	static Scanner in = new Scanner(System.in);
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	/**
	 * CellPhone parameterized Constructor
	 *
	 * @param sn a long that represents the serialNumber
	 * @param b        a String that represents the brand
	 * @param y         an int that represents the year
	 * @param pr        a double that represents the price
	 */
	public CellPhone(long sn, String b, int y, double pr) {
		this.serialNum = sn;
		this.brand = b;
		this.year = y;
		this.price = pr;

	}
	/**
	 * Copy constructor
	 *
	 * @param c    the CellPhone to be cloned
	 * @param serial the Serial Number of the new Cellphone
	 */
	public CellPhone(CellPhone c, long serial) {
		setBrand(c.brand);
		setYear(c.year);
		setPrice(c.price);
		serialNum = serial;
	}
	/**
	 * Gets serial number
	 * @return serial number (long)
	 */
	public long getSerialNum() {
		return serialNum;
	}
	/**
	 * Get the brand
	 * @return returns a string containing the brand of the cellphone
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Get the year
	 * @return an int representing the year of the cellphone
	 */
	public int getYear() {
		return year;
	}
	/**
	 * Get the price
	 * @return a double representing the price of the cellphone
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Set serial number
	 * @param sr long containing the serial number
	 */
	public void setSerialNum(long sr) {
		serialNum = sr;
	}
	/**
	 * Set the year
	 * @param year an int containing the year of the cellphone
	 */
	public void setYear(int ye) {
		year = ye;

	}

	/**
	 * Set the brand
	 * @param br a String containing the brand of the cellphone
	 */
	public void setBrand(String br) {
		brand = br;
	}
	/**
	 * Set the price
	 * @param pric a double containing the price of the cellphone
	 */
	public void setPrice(double pric) {
		price = pric;
	}

	public CellPhone clone() {
		System.out.print("Please enter new serial number:");
		long snum = in.nextLong();

		return new CellPhone(this, snum);
		// return new CellPhone(this);
	}

	/**
	 * Checks whether two cellphones are equal (serial number notwithstanding)
	 * @param o object to check whether it is equal
	 * @return boolean value
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CellPhone cellPhone = (CellPhone) o;
		return year == cellPhone.year && Double.compare(cellPhone.price, price) == 0 && brand.equals(cellPhone.brand);
	}

	@Override
	/**
	 * Returns a string containing the information of the cellphone
	 */

	public String toString() {
		return ("[" + serialNum + ": " + brand + " " + price + "$ " + year + "] ");
	}
}
