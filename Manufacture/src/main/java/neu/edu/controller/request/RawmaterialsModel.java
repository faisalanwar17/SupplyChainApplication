package neu.edu.controller.request;

public class RawmaterialsModel {

	public RawmaterialsModel() {
		// TODO Auto-generated constructor stub
	}
	private String materialid;
	public String getMaterialid() {
		return materialid;
	}
	public void setMaterialid(String materialid) {
		this.materialid = materialid;
	}
	private int itemid;
	private String itemname;
	private Integer availability;
	private String manufactureid;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	public String getManufactureid() {
		return manufactureid;
	}
	public void setManufactureid(String manufactureid) {
		this.manufactureid = manufactureid;
	}
	
}
