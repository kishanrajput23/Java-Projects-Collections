package billingsystem;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Jason Li
 * @version 1.0
 * @since 19.12.2016
 * 
 * 
 * 
 * The Class Order.
 */
public class Order implements Serializable {

	/** The name. */
	private String name;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name2 the new name
	 */
	public void setName(String name2) {
		this.name = name2;
	}

	/** The price. */
	private double price;

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price2 the new price
	 */
	public void setPrice(double price2) {
		this.price = price2;
	}

	/** The quantity. */
	private int quantity;

	/**
	 * Gets the order quantity.
	 *
	 * @return the order quantity
	 */
	public int getQnty() {
		return quantity;
	}
	
	/** The date. */
	private Date date;
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	
	/** The comment. */
	private String comment;
	
	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	
	/** The source table. */
	private String sourceTable;
	
	/**
	 * Gets the source table.
	 *
	 * @return the source table
	 */
	public String getSrcTbl() {
		return sourceTable;
	}
	
	/**
	 * Return each order as a comma delimited row for csv output.
	 *
	 * @return the string
	 */
	public String toCsvRow() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	    return Stream.of(name, ("" + price), ("" + quantity), ("" + sourceTable), ("" + price*quantity), comment, ("" + dateFormat.format(date)))
	            .collect(Collectors.joining(","));
	}

	/**
	 * Instantiates a new order.
	 *
	 * @param copyOrder the copy order
	 * @param qnty the order quantity
	 * @param comment the comment
	 * @param sourceTable the source table
	 */
	public Order(Order copyOrder, int qnty, String comment, String sourceTable) {
		this.name = copyOrder.name;
		this.price = copyOrder.price;
		this.quantity = qnty;
		this.comment = comment;
		this.sourceTable = sourceTable;
		this.date = new Date();
	}

	/**
	 * Instantiates a new order.
	 *
	 * @param name the name
	 * @param price the price
	 */
	public Order(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	
	/**
	 * Instantiates a new order.
	 *
	 * @param name the name
	 * @param price the price
	 * @param qnty the qnty
	 * @param srcTable the src table
	 * @param comment the comment
	 * @param date the date
	 */
	public Order(String name, double price, int qnty, String srcTable, String comment, Date date) {
		this.name = name;
		this.price = price;
		this.quantity = qnty;
		this.comment = comment;
		this.sourceTable = srcTable;
		this.date = date;
	}
}
