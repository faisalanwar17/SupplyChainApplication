package neu.edu.controller.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeeModel {

	public EmployeeModel() {
		// TODO Auto-generated constructor stub
	}
	private String username;
	@NotEmpty @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="please enter in Password in format")
	private String password;
	@Email
	private String email;
	@NotEmpty (message = "Address Line 1 should not be empty")
	private String address;
	@NotEmpty (message = "City should not be empty")
	private String city;
	@NotEmpty (message = "State should not be empty")
	private String state;
	@NotEmpty (message = "Country should not be empty")
	private String country;
	@NotEmpty(message = "Role should not be empty")
	private String role;
	@NotEmpty(message = "Company shuld not be empty")
	private String companyid;
	@NotEmpty(message = "First Name not be empty")
	private String firstName;
	@NotEmpty(message = "Last Name not be empty")
	private String lastName;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
