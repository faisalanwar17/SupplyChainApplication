package neu.edu.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import neu.edu.controller.model.DistributerOrders;
import neu.edu.controller.model.DistributerProduct;
import neu.edu.controller.model.ItemModel;
import neu.edu.controller.model.ManufactureModel;
import neu.edu.controller.model.ManufactureOrder;
import neu.edu.controller.model.Options;
import neu.edu.controller.model.ProductModel;
import neu.edu.controller.model.RawmaterialModel;
import neu.edu.controller.model.SupplierController;

@Service
public class ManufactureService {

	public ManufactureService() {
		// TODO Auto-generated constructor stub
	}
	public List<RawmaterialModel>  findRawMaterials(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/getrawmaterials/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<RawmaterialModel> rawmaterialModel  = mapper.readValue(postResponse.body(), new TypeReference<List<RawmaterialModel>>() {});
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
		 
		return  rawmaterialModel;
	}
	public RawmaterialModel  findRawMaterialbyrawid(String company) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		//String companyid = Integer.toString(company);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/getrawmaterialbyrawid/"+company)).POST(BodyPublishers.ofString(company)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		//System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		//RawmaterialModel rawmaterialModel  = mapper.readValue(postResponse.body(), new TypeReference<RawmaterialModel>() {});
		//System.out.println("hihh");
		RawmaterialModel rawmaterialModel=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			rawmaterialModel = mapper.readValue(postResponse.body(), RawmaterialModel.class);//replaced result.getResponseAsString() with res
		} catch (Exception e) {
		    e.printStackTrace();
		}
	
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
		 
		return  rawmaterialModel;
	}
	public List<ProductModel>  findProductsBymanufactureid(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/getproducts/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<ProductModel> productModel  = mapper.readValue(postResponse.body(), new TypeReference<List<ProductModel>>() {});
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
		 
		return  productModel;
	}
	public List<DistributerOrders>  findDistributerorderbymanufacture(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/getdistributerorderbymanufacture/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<DistributerOrders> itemModel  = mapper.readValue(postResponse.body(), new TypeReference<List<DistributerOrders>>() {});
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
	public List<ItemModel>  findItemsbyitemname(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8081/Supplier/supplier/getitemsbyname/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
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
	public List<ProductModel>  findProductsbyproductname(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/getproductsbyproductname/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<ProductModel> itemModel  = mapper.readValue(postResponse.body(), new TypeReference<List<ProductModel>>() {});
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
	public RawmaterialModel   getRawmaterial(RawmaterialModel rawmaterial) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(rawmaterial);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/getrawmaterialbyitemname")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		RawmaterialModel rawmaterialModel=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			rawmaterialModel = mapper.readValue(postResponse.body(), RawmaterialModel.class);//replaced result.getResponseAsString() with res
		} catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("hihh");
		return rawmaterialModel;
	}
	public ManufactureModel   getManufacture(String company) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
		//ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		//String json = ow.writeValueAsString(rawmaterial);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		//System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/getmanufacture/"+company)).POST(BodyPublishers.ofString(company)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		ManufactureModel manufactureModel=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			manufactureModel = mapper.readValue(postResponse.body(), ManufactureModel.class);//replaced result.getResponseAsString() with res
		} catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("hihh");
		return manufactureModel;
	}
	/*
	public boolean   createDistributerorder(DistributerOrders distributerOrders) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
	/*
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(distributerOrders);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		/*
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/createdistributerorder")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
*/
	public boolean   updateProduct(ProductModel productModel) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(productModel);
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/updateproduct")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	public DistributerOrders  getDistributerOrderbyorderid(int company) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		String companyid = Integer.toString(company);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/getdistributerorderbyid/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		DistributerOrders orderModel  = mapper.readValue(postResponse.body(), new TypeReference<DistributerOrders>() {});
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
	public boolean   createRawmaterial(RawmaterialModel rawmaterial) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(rawmaterial);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/createrawmaterial")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	public boolean   createOrder(ManufactureOrder manufactureOrder) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(manufactureOrder);
		System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/createorder")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	public boolean   createDistributerOrder(Options option) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		///System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(option);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/createdistributerorder")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	public boolean   updateManufacture(ManufactureModel manufactureModel) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(manufactureModel);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/updatemanufacture")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	public boolean   createProduct(ProductModel productModel ) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(productModel);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/createproduct")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	public boolean   updateDistributerOrderStatus(DistributerOrders distributerOrders) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(distributerOrders);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/updateDistributerorderbystatus")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	
	public boolean   updateOrderStatus(ManufactureOrder manufactureOrder) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(manufactureOrder);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/updateorderstatus")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	
	public boolean   updateRawmaterial(RawmaterialModel rawmaterial) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(rawmaterial);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/updaterawmaterial")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	public ManufactureOrder  findOrder (int company) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		String companyid = Integer.toString(company);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/checkorder/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		ManufactureOrder manufactureOrder=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			manufactureOrder = mapper.readValue(postResponse.body(), ManufactureOrder.class);//replaced result.getResponseAsString() with res
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
		 
		return  manufactureOrder;
	}
	public ProductModel  findProductid (int company) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		String companyid = Integer.toString(company);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/checkproduct/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		ProductModel productModel=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			productModel = mapper.readValue(postResponse.body(), ProductModel.class);//replaced result.getResponseAsString() with res
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
		 
		return  productModel;
	}
	public ProductModel   checkProduct(ProductModel productModel) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(manufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(productModel);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		//System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8084/Manufacture/manufacture/checkproductbynameandid")).POST(BodyPublishers.ofString(json)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		ProductModel distributer=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			distributer = mapper.readValue(postResponse.body(), ProductModel.class);//replaced result.getResponseAsString() with res
		} catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("hihh");
		return distributer;
	}

}
