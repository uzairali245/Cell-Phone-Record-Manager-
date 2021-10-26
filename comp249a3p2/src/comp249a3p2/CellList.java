//-------------------------------------------------------------------------------------
// Assignment 3
// Part: 2
// Written by: Uzair Ali (40111410)
//-------------------------------------------------------------------------------------

package comp249a3p2;

import java.util.NoSuchElementException;



public class CellList {
	/**
	 * inner CellNode Class Privacy leak: CellNode class is available for direct use
	 * anywhere in the CellList class, but not outside that class.
	 */
	private class CellNode {
		private CellPhone cp;
		private CellNode next;

		/**
		 * Default constructor
		 */
		public CellNode() {
			cp = null;
			next = null;
		}

		/**
		 * Parameterized constructor
		 *
		 * @param cellphone object
		 * @param cellNode  object
		 */
		public CellNode(CellPhone c, CellNode xt) {
			cp = c;
			next = xt;
		}

		/**
		 * Copy Constructor
		 *
		 * @param cellNode object to be copied
		 */
		public CellNode(CellNode cn) {
			cp = cn.cp.clone(); // Deep copy the contents of the node
			next = cn.next;
		}

		/**
		 * Clone method
		 *
		 * @return cloned CellNode
		 */
		public CellNode clone() {
			return new CellNode(this);
		}

		/*
		 * @param cellphone object
		 */
		public void setCellPhone(CellPhone c) {
			cp = c;
		}

		/*
		 * @param node object sets it
		 */
		public void setNext(CellNode xt) {
			next = xt;
		}

		/* @return cellphone */
		public CellPhone getCellPhone() {
			return cp;
		}

		/* @return next */
		public CellNode getNext() {
			return next;
		}

	}

	private CellNode head;
	private int size = 0;

	/**
	 * CellList Default constructor
	 */
	public CellList() {
		head = null;

	}

	/*
	 * @return size of list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * CellList copy constructor
	 * 
	 * @param lst CellList to be copied
	 */
	public CellList(CellList lst) {

		if (lst.head == null)
			head = null;
		else {
			head = null;
			CellNode t1, t2, t3; 

			t1 = lst.head;
			t2 = t3 = null;
			while (t1 != null) {
				if (head == null) 
				{
					t2 = new CellNode(t1);
					head = t2;
				} else {
					t3 = new CellNode(t1);
					t2.next = t3;
					t2 = t3;
				}
				t1 = t1.next;
			}

			t2 = t3 = null; 

		}

	}

	public CellList clone() {
		return new CellList(this);
	}

	/**
	 * Add a cellphone to the start of the Linked list
	 * 
	 * @param c Cellphone object to be added
	 */
	public void addToStart(CellPhone c) {
		CellNode n = new CellNode(c, head);
		head = n;
		n = null;
		size++;
	}

	/**
	 * Insert the cell phone at an index
	 * 
	 * 
	 * @param index     the index where to add the Cellphone
	 * @param val Cellphone object to be added
	 */
	// A method that inserts a node at a given index. The old node pointed by index
	// is shifted forward (right)
	public void insertAtIndex(int index, CellPhone val) {

		if (index > size - 1) {
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			throw new NoSuchElementException();
		}

		System.out.println("\nInserting new node with value " + val + " at index # " + index + ".");
		int i = 0;
		CellNode temp = head;

		
		if (index == 0) {
			CellNode newNode = new CellNode(val, head);
			head = newNode;
			newNode = null;
		} else {
			while (i != index - 1) 
			{
				temp = temp.next;
				i++;
			}
			
			CellNode newNode = new CellNode(val, temp.next); 
			
			temp.next = newNode;
			newNode = null;
		}
		size++;
	}

	/**
	 * Deletes the node at a certain index
	 * 
	 * @param index an int representing the index of the node to delete
	 */
	// A method that deletes a node at a given index
	public void deleteFromIndex(int index) {

		if (index > size - 1) {
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			throw new NoSuchElementException();
		}

		int i = 0;
		CellNode temp = head;

		

		if (size == 1) {
			System.out.println("\nDeleting the only node of the list at index # " + 0 + ".");

			head = null;
			size--;
			return;
		}

		
		if (index == 0) {
			System.out.println("\nDeleting node with value " + head.cp + " from index # " + index + ".");
			head = head.next;
			
		}
		
		else // The more general case; deletion from the middle
		{
			while (i != index - 1) // Stop at the node that precedes index
			{
				temp = temp.next;
				i++;
			}
			// Now we are pointing at the node preceding index where deletion should take
			// place
			System.out.println("\nDeleting node with value " + temp.next.cp + " from index # " + index + ".");
			temp.next = temp.next.next;
			
		}
		size--;
	}

	/**
	 * Replace the cellphone at a particular index
	 * 
	 * @param val   Cellphone object to replace with
	 * @param index int representing the index at which the node is replaced
	 */
	// A method that replaces the value at a given index
	public void replaceItemAt(int index, CellPhone val) {
		
		  if (index > size -1) { System.out.
		  println("ERROR: Given index is out of range! Program will terminate. \n");
		  throw new NoSuchElementException(); }
		 

		int i = 0;
		CellNode temp = head;
		while (i != index) {
			temp = temp.next;
			i++;
		}
		System.out.println("Replacing value at index # " + index + " from " + temp.cp + " to " + val + ". \n");
		temp.cp = val;
	}

	/**
	 * This method does not have a privacy leak because it is private. The method is
	 * used by both searchFor as well as contains.
	 * 
	 * @param sn to search for serial number
	 * @return CellNode
	 */
	/*public CellNode find(long sn) {
		CellNode t = head;
		while (t != null) {
			if (t.cp.getSerialNum() == sn)
				return t; 
			t = t.next;
		}
		return null; 
	}*/

	/**
	 *
	 * @param sn is serial number
	 * @return boolean
	 */
	
	public boolean contains(long sn) {
		if (find(sn) != null)
			return true;
		else
			return false;
	}

	/* print the contents of the list */
	public void showListContents() {
		CellNode temp = head;
		if (temp == null)
			System.out.println("\nThere is nothing to display; list empty.");
		else
			while (temp != null) {
				System.out.println(temp.cp + " ---> ");
				temp = temp.next;
			}
		System.out.println("X");

	}

	/**
	 * Deletes a node from the start
	 */
	public boolean deleteFromStart() {
		if (head != null) {
			head = head.getNext();
			return true;
		} else
			return false;
	}

	/**
	 * Checks equality of celllists
	 * 
	 * @param o another list to compare to
	 * @return whether the list is equal or not
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CellList cellList = (CellList) o;
		return size == cellList.size && checkIfSameElements(cellList);
	}

	/**
	 * Checks whether the nodes contains same elements in subsequent nodes or not
	 * 
	 * @param list starting node to check
	 * @return boolean
	 */
	public boolean checkIfSameElements(CellList list) {
		CellNode list1Head = head;
		CellNode list2Head = list.head;

		if (list1Head == null || list2Head == null) {
			if (list1Head == null && list2Head == null)
				return true;
			else
				return false;
		} else {
			return list1Head.equals(list2Head);
		}
	}
	public CellNode find(long serialNumber) {
		int      searchCounter = 1;
		CellNode nodeToCheck   = head;

		while (nodeToCheck != null)
		{
			System.out.println("Search iteration #" + searchCounter);
			// Check if it is equal, return the nodeToCheck if true
			if (nodeToCheck.cp.getSerialNum() == serialNumber)
			{
				return nodeToCheck;
			}
			else
			{
				// Go to next node
				nodeToCheck = nodeToCheck.next;
				searchCounter++;
			}
		}

		// If it hits a null node (the end)
		return null;
	}

}
