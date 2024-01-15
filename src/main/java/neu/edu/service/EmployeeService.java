package neu.edu.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscribers;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.Flow.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import neu.edu.controller.model.Customer;
import neu.edu.controller.model.EmployeeModel;
import neu.edu.controller.model.SupplierController;
import neu.edu.entity.Customers;
import neu.edu.entity.Employee;
import neu.edu.repository.CustomerRepository;
import neu.edu.repository.EmployeeRepository;
@Service
public class EmployeeService {

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private EmployeeRepository employeeReopsitory;
	
	public boolean saveUser(EmployeeModel employeeModel) {
		Employee employee= new Employee();
		employee.setFirstName(employeeModel.getFirstName());
		employee.setLastName(employeeModel.getLastName());
		employee.setPassword(employeeModel.getPassword());
		employee.setUsername(employeeModel.getUsername());
		employee.setAddress(employeeModel.getAddress());
		employee.setEmail(employeeModel.getEmail());
		employee.setCity(employeeModel.getCity());
		employee.setState(employeeModel.getState());
		employee.setCountry(employeeModel.getCountry());
		employee.setCompanyid(employeeModel.getCompanyid());
		employee.setRole(employeeModel.getRole());
		
		
		
		System.out.println("inserted ser");
		return employeeReopsitory.save(employee);
	}
	public Employee   findEmployee(String username)
	{
		return employeeReopsitory.findByUserName(username);
	}
	public List<SupplierController>  findCompany() throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/list")).POST(BodyPublishers.ofString("")).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<SupplierController> supplier  = mapper.readValue(postResponse.body(), new TypeReference<List<SupplierController>>() {});
		System.out.println("hihh");
		//System.supplier.getPoliticalissues();
		
		//List<SupplierController> sm= (List<SupplierController>) ((Object) postResponse).readObject();
		//List<SupplierController> sm1= (List<SupplierController>)SerializationUtils.dserialize(postResponse.body());
		//String json =postResponse.body();
		
		//String lsm2="";
		/*
		RestTemplate restTemplate;
		SupplierController  response = restTemplate.getForObject(
				  "http://localhost:8081/Supplier/supplier/item/"+companyid,
SupplierController.class);
				List<SupplierController> supplier = response.getSuppliers();
		
		for (SupplierController lsm: supplier)
		{
			 System.out.println(lsm.getPoliticalissues());
		}
		//postResponse.(SupplierController.class);
		//HttpResponse List<supplierController> = 
		//SupplierController supplierController = (SupplierController) postResponse.body();
		 * */
		 
		return  supplier;
	}
}
