package neu.edu.entity;
// Generated 16-Dec-2022, 3:02:55 pm by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Distributer generated by hbm2java
 */
@Entity
@Table(name = "distributer", catalog = "distributer")
public class Distributer implements java.io.Serializable {

	private String distributerid;
	private String weather;
	private String politicalissues;
	private String labourissues;
	private String driverissues;

	public Distributer() {
	}

	public Distributer(String distributerid) {
		this.distributerid = distributerid;
	}

	public Distributer(String distributerid, String weather, String politicalissues, String labourissues,
			String driverissues) {
		this.distributerid = distributerid;
		this.weather = weather;
		this.politicalissues = politicalissues;
		this.labourissues = labourissues;
		this.driverissues = driverissues;
	}

	@Id

	@Column(name = "distributerid", unique = true, nullable = false, length = 50)
	public String getDistributerid() {
		return this.distributerid;
	}

	public void setDistributerid(String distributerid) {
		this.distributerid = distributerid;
	}

	@Column(name = "weather", length = 50)
	public String getWeather() {
		return this.weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	@Column(name = "politicalissues", length = 50)
	public String getPoliticalissues() {
		return this.politicalissues;
	}

	public void setPoliticalissues(String politicalissues) {
		this.politicalissues = politicalissues;
	}

	@Column(name = "labourissues", length = 50)
	public String getLabourissues() {
		return this.labourissues;
	}

	public void setLabourissues(String labourissues) {
		this.labourissues = labourissues;
	}

	@Column(name = "driverissues", length = 50)
	public String getDriverissues() {
		return this.driverissues;
	}

	public void setDriverissues(String driverissues) {
		this.driverissues = driverissues;
	}

}