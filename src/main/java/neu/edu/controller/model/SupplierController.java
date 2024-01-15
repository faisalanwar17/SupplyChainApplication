package neu.edu.controller.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierController {
	private List<SupplierController> suppliers;
	public List<SupplierController> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<SupplierController> suppliers) {
		this.suppliers = suppliers;
	}
	public SupplierController() {
		// TODO Auto-generated constructor stub
		suppliers = new ArrayList<>();
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
