/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Hardeep
 */
public class getflights {
	private String provider;
	private String source;
	private String destination;
	private String duration;
        private double price;
        private String flightnumber;
        private int flightid;
	
	public getflights(){
		provider = null;
		source = null;
		destination = null;
		duration = null;
		price = 0;
		flightnumber = null;
		flightid = 0;
	}
	
	public String getprovider() {
		return provider;
	}
	public void setprovider(String provider) {
		this.provider = provider;
	}
	public String getsource() {
		return source;
	}
	public void setsource(String source) {
		this.source = source;
	}
	public String getdestination() {
		return destination;
	}
	public void setdestination(String destination) {
		this.destination = destination;
	}
	public String getduration() {
		return duration;
	}
	public void setduration(String duration) {
		this.duration = duration;
	}
	public void setprice(double price) {
		this.price = price;
	}
	public double getprice() {
		return price;
	}
        public String getflightnumber() {
		return flightnumber;
	}
	public void setflightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
        
        public int getflightid() {
		return flightid;
	}
	public void setflightid(int flightid) {
		this.flightid = flightid;
	}
}
