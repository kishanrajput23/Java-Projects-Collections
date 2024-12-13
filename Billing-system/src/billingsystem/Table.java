package billingsystem;

import java.util.ArrayList;

import javafx.scene.control.Label;

/**
 * 
 * @author Jason Li
 * @version 1.0
 * @since 19.12.2016
 * 
 * 
 * 
 * The Class Table.
 */
public class Table extends Label implements java.io.Serializable {

	/** The tbl name. */
	private String tblName;
	
	/** The people. */
	private String people;
	
	/** The orders. */
	ArrayList<Order> orders = new ArrayList<Order>();
	
	/** The pos X. */
	private double posX;
	
	/** The pos Y. */
	private double posY;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return tblName;
	}

	/**
	 * Gets the orders.
	 *
	 * @return the orders
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}

	/**
	 * Set new X and Y.
	 *
	 * @param x the x-position
	 * @param y the y-position
	 */
	public void setXY(double x, double y) {
		this.posX = x;
		this.posY = y;
	}

	/**
	 * Gets the x-position.
	 *
	 * @return the x
	 */
	public double getX() {
		return posX;
	}

	/**
	 * Gets the y-position.
	 *
	 * @return the y
	 */
	public double getY() {
		return posY;
	}

	/**
	 * Sets the number of people at the table.
	 *
	 * @param people -  Number of people
	 */
	public void setPeople(String people) {
		this.people = people;
	}

	/**
	 * Gets the number of people at the table.
	 *
	 * @return people - Number of people
	 */
	public String getPeople() {
		return people;
	}

	/**
	 * Adds the order.
	 *
	 * @param order item the order item
	 */
	public void addOrder(Order orderItem) {
		orders.add(orderItem);
	}

	/**
	 * Sets the orders.
	 *
	 * @param set new orders
	 */
	public void setOrders(ArrayList<Order> setOrders) {
		this.orders = setOrders;
	}

	/**
	 * Clear table
	 */
	public void clear() {
		this.people = "";
		this.orders.clear();;
	}

	/**
	 * Instantiates a new table.
	 *
	 * @param tblName the table name
	 */
	public Table(String tblName) {
		this.tblName = tblName;
	}

	/**
	 * Instantiates a new table.
	 *
	 * @param copyTable - the table to copy
	 */
	public Table(Table copyTable) {
		this.tblName = copyTable.tblName;
		this.posX = copyTable.posX;
		this.posY = copyTable.posY;
	}

}
