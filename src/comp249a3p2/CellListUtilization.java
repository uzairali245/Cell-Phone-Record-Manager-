//-------------------------------------------------------------------------------------
// 
// Part: 2
// Written by: Uzair Ali ()
//-------------------------------------------------------------------------------------

package comp249a3p2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		CellPhone c3 = new CellPhone(22222, "Sony", 2018, 32.99), c4 = new CellPhone(3333, "Oppo", 2019, 99.8),
				c5 = new CellPhone(444, "Amazon", 1990, 21.8), c6 = new CellPhone(555, "Pixel", 2007, 200.8);
		CellList cplst1 = new CellList();
		CellList cplst2 = null;

		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		long serial;
		String name, s;
		int year;
		double price;
		while (sc.hasNextLine()) {
			serial = sc.nextLong();
			name = sc.next();
			price = Double.parseDouble(sc.next());
			year = Integer.parseInt(sc.next());
			CellPhone c1 = new CellPhone(serial, name, year, price);
			if (!cplst1.contains(serial))
				cplst1.addToStart(c1);

		}

		System.out.println("The current size of the list is " + cplst1.getSize()
				+ ". Here are the contents of the list\n---------------------------------------------------------------------");
		cplst1.showListContents();
System.out.println(cplst1.equals(cplst2));
		// search serial
		System.out.println("Please enter the serial number you want to check in a list: ");
		long check1 = in.nextLong();
		cplst1.find(check1);
		if (cplst1.contains(check1))
			System.out.println("The list contains this serial number");
		else
			System.out.println("The list does not contains this serial number");

		System.out.println("Please enter the index at which you want to insert cellphone record: ");
		int check2 = in.nextInt();
		cplst1.insertAtIndex(check2, c3);
		System.out.println("The current size of the list is " + cplst1.getSize()
				+ ". Here are the contents of the list\n---------------------------------------------------------------------");
		cplst1.showListContents();

		System.out.println("Please enter the index at which you want to replace cellphone record:");
		int check3 = in.nextInt();
		cplst1.replaceItemAt(check3, c4);
		System.out.println("The current size of the list is " + cplst1.getSize()
				+ ". Here are the contents of the list\n---------------------------------------------------------------------");
		cplst1.showListContents();

		System.out.println("Now please enter the index at which you want to delete cellphone record: ");
		int check4 = in.nextInt();
		cplst1.deleteFromIndex(check4);
		System.out.println("The current size of the list is " + cplst1.getSize()
				+ ". Here are the contents of the list\n---------------------------------------------------------------------");
		cplst1.showListContents();

		System.out.println("If you want to delete any cellphone record from the start press 1:");
		int check5 = in.nextInt();
		if (check5 == 1) {
			cplst1.deleteFromStart();
			System.out.println("The current size of the list is " + cplst1.getSize()
					+ ". Here are the contents of the list\n---------------------------------------------------------------------");
			cplst1.showListContents();
		}

		System.out.println("Please enter another index at which you want to add cellphone record: ");
		int check6 = in.nextInt();
		cplst1.insertAtIndex(check6, c5);
		System.out.println("The current size of the list is " + cplst1.getSize()
				+ ". Here are the contents of the list\n---------------------------------------------------------------------");
		cplst1.showListContents();

		cplst2 = cplst1.clone();
		System.out.println("\nList has been cloned to another. Here are the contents of the cloned list: ");
		cplst2.showListContents();
		System.out.println("Now checking whether this list is equal to the first or not");
		if (cplst2.equals(cplst1)) {
			System.out.println("both lists are equal");
		} else {
			System.out.println("They are not equal");
		}
		System.out.println("Thankyou for using bye!!");
	}

}
