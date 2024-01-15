package neu.edu.entity;
// Generated 14-Dec-2022, 10:01:30 pm by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "manufacture")
public class Product implements java.io.Serializable {

	private int productid;
	private String productname;
	private Integer availability;
	private Integer cost;
	private String manufactureid;

	public Product() {
	}

	public Product(int productid) {
		this.productid = productid;
	}

	public Product(int productid, String productname, Integer availability, Integer cost, String manufactureid) {
		this.productid = productid;
		this.productname = productname;
		this.availability = availability;
		this.cost = cost;
		this.manufactureid = manufactureid;
	}

	@Id

	@Column(name = "productid", unique = true, nullable = false)
	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Column(name = "productname", length = 50)
	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Column(name = "availability")
	public Integer getAvailability() {
		return this.availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	@Column(name = "cost")
	public Integer getCost() {
		return this.cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Column(name = "manufactureid", length = 50)
	public String getManufactureid() {
		return this.manufactureid;
	}

	public void setManufactureid(String manufactureid) {
		this.manufactureid = manufactureid;
	}

}