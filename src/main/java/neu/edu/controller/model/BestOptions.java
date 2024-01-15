package neu.edu.controller.model;

public class BestOptions {

	public BestOptions() {
		// TODO Auto-generated constructor stub
	}
	private String orderid;
	private int productid;
	private String productname;
	private int units;
	private int cost;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDistributerid() {
		return distributerid;
	}
	public void setDistributerid(String distributerid) {
		this.distributerid = distributerid;
	}
	private String status;
	private String distributerid;
}
