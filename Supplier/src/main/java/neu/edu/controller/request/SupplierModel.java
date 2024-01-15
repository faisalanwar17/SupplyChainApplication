package neu.edu.controller.request;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;


public class SupplierModel {

	public SupplierModel() {
		// TODO Auto-generated constructor stub
	}
	private String supplierid;
	private String weather;
	private String politicalissues;
	private String labourissues;
	private String driverissues;
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getPoliticalissues() {
		return politicalissues;
	}
	public void setPoliticalissues(String politicalissues) {
		this.politicalissues = politicalissues;
	}
	public String getLabourissues() {
		return labourissues;
	}
	public void setLabourissues(String labourissues) {
		this.labourissues = labourissues;
	}
	public String getDriverissues() {
		return driverissues;
	}
	public void setDriverissues(String driverissues) {
		this.driverissues = driverissues;
	}
	
}
