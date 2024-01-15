package neu.edu.controller.request;

public class DistributerorderModel {

	public DistributerorderModel() {
		// TODO Auto-generated constructor stub
	}
	private int orderid;
	private Integer productid;
	private String productname;
	private Integer units;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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
	public Integer getUnits() {
		return units;
	}
	public void setUnits(Integer units) {
		this.units = units;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getManufactureid() {
		return manufactureid;
	}
	public void setManufactureid(String manufactureid) {
		this.manufactureid = manufactureid;
	}
	public String getDistributerid() {
		return distributerid;
	}
	public void setDistributerid(String distributerid) {
		this.distributerid = distributerid;
	}
	private Integer cost;
	private String status;
	private String manufactureid;
	private String distributerid;
}
