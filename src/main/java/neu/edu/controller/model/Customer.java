package neu.edu.controller.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Customer {

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	@NotBlank
	@NotEmpty (message = "Username should not be empty")
	private String username;
	
	@NotEmpty (message = "First Name should not be empty")
	private String firstName;
	@NotEmpty (message = "Last Name should not be empty")
	private String lastName;
	@NotEmpty @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="please enter in Password in format")
	private String password;
	@Email
	private String email;
	@NotEmpty (message = "Address Line 1 should not be empty")
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
}
