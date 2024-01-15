package neu.edu.controller.request;

public class ProductModel {

	public ProductModel() {
		// TODO Auto-generated constructor stub
	}
	
	private int productid;
	private String productname;
	private Integer availability;
	private Integer cost;
	private String manufactureid;
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
	public String getManufactureid() {
		return manufactureid;
	}
	public void setManufactureid(String manufactureid) {
		this.manufactureid = manufactureid;
	}
	
	
	
}
