package neu.edu.entity;
// Generated 24-Nov-2022, 2:04:12 am by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "supplychain")
public class Employee implements java.io.Serializable {

	private String username;
	private String password;
	private String email;
	private String address;
	private String city;
	private String state;
	private String country;
	private String role;
	private String companyid;
	private String firstName;
	private String lastName;

	public Employee() {
	}

	public Employee(String username) {
		this.username = username;
	}

	public Employee(String username, String password, String email, String address, String city, String state,
			String country, String role, String companyid) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.role = role;
		this.companyid = companyid;
	}

	@Id

	@Column(name = "username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", length = 50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 50)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country", length = 50)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "role", length = 50)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "companyid", length = 50)
	public String getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	
	@Column(name = "firstname", length = 100)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "lastname", length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
