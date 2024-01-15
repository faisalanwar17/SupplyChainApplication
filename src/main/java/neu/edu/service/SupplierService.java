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
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;

import neu.edu.controller.model.Customer;
import neu.edu.controller.model.EmployeeModel;
import neu.edu.controller.model.ItemModel;
import neu.edu.controller.model.Options;
import neu.edu.controller.model.SupplierController;
import neu.edu.entity.Customers;
import neu.edu.entity.Employee;
import neu.edu.repository.CustomerRepository;
import neu.edu.repository.EmployeeRepository;
@Service
public class SupplierService {

	public SupplierService() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private EmployeeRepository employeeReopsitory;
	public boolean   updateSupplier(SupplierController supplierController) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(supplierController);
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/update")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		if(!(postResponse.body().isEmpty()))
			{
			return true;
		}
		 
		return  false;
	}
	public boolean   updateItem(ItemModel itemModel) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(itemModel);
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/updateitem")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		if(!(postResponse.body().isEmpty()))
			{
			return true;
		}
		 
		return  false;
	}
	public boolean   updateOrderStatus(Options option) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(option);
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/updateorderstatus")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		if(!(postResponse.body().isEmpty()))
			{
			return true;
		}
		 
		return  false;
	}


	public boolean   createOrder(Options option) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		System.out.println(option.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(option);
		System.out.println(option.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/createorder")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		if(!(postResponse.body().isEmpty()))
			{
			return true;
		}
		 
		return  false;
	}
	public boolean   createItem(ItemModel itemModel) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		System.out.println(itemModel.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(itemModel);
		System.out.println(itemModel.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/createitem")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		if(!(postResponse.body().isEmpty()))
			{
			return true;
		}
		 
		return  false;
	}
	public boolean   checkItem(ItemModel itemModel) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(itemModel);
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/checkitem")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		if(postResponse.body().equalsIgnoreCase("false"))
		{
			return false;
		}
		 
		return  true;
	}
	public SupplierController  findCompany(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/item/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		SupplierController supplier  = mapper.readValue(postResponse.body(), new TypeReference<SupplierController>() {});
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
	public List<ItemModel>  findItems(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/getitems/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<ItemModel> itemModel  = mapper.readValue(postResponse.body(), new TypeReference<List<ItemModel>>() {});
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
		 
		return  itemModel;
	}
	public Options  getOrderbyorderid(int company) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		String companyid = Integer.toString(company);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/getorderbyid/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		Options orderModel  = mapper.readValue(postResponse.body(), new TypeReference<Options>() {});
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
		 
		return  orderModel;
	}
	public List<Options>  findOrders(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/getorder/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<Options> orderModel  = mapper.readValue(postResponse.body(), new TypeReference<List<Options>>() {});
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
		 
		return  orderModel;
	}
	public ItemModel  findItem(int company) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		String companyid = Integer.toString(company);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/getitem/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		ItemModel itemModel=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
		    itemModel = mapper.readValue(postResponse.body(), ItemModel.class);//replaced result.getResponseAsString() with res
		} catch (Exception e) {
		    e.printStackTrace();
		}
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
		 
		return  itemModel;
	}
	
}
