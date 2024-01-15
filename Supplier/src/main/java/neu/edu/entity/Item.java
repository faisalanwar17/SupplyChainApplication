package neu.edu.entity;
// Generated 13-Dec-2022, 10:53:03 pm by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Item generated by hbm2java
 */
@Entity
@Table(name = "item", catalog = "supplier")
public class Item implements java.io.Serializable {

	private int itemid;
	private String itemname;
	private Integer availability;
	private Integer cost;
	private String supplierid;

	public Item() {
	}

	public Item(int itemid) {
		this.itemid = itemid;
	}

	public Item(int itemid, String itemname, Integer availability, Integer cost, String supplierid) {
		this.itemid = itemid;
		this.itemname = itemname;
		this.availability = availability;
		this.cost = cost;
		this.supplierid = supplierid;
	}

	@Id

	@Column(name = "itemid", unique = true, nullable = false)
	public int getItemid() {
		return this.itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	@Column(name = "itemname", length = 50)
	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
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

	@Column(name = "supplierid", length = 50)
	public String getSupplierid() {
		return this.supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

}