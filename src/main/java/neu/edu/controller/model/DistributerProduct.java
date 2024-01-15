package neu.edu.controller.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DistributerProduct {

	public DistributerProduct() {
		// TODO Auto-generated constructor stub
	}
	private String productupc;
	private Integer productid;
	private String productname;
	private Integer availability;
	private Integer cost;
	private String distributerid;
	public String getProductupc() {
		return productupc;
	}
	public void setProductupc(String productupc) {
		this.productupc = productupc;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getDistributerid() {
		return distributerid;
	}
	public void setDistributerid(String distributerid) {
		this.distributerid = distributerid;
	}
}
