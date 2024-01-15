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

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import neu.edu.controller.model.Distributer;
import neu.edu.controller.model.DistributerManufactureOrder;
import neu.edu.controller.model.DistributerOrders;
import neu.edu.controller.model.DistributerProduct;
import neu.edu.controller.model.ManufactureModel;
import neu.edu.controller.model.ManufactureOrder;
import neu.edu.controller.model.RawmaterialModel;
import neu.edu.controller.model.SupplierController;

@Service
public class DistributerService {

	public DistributerService() {
		// TODO Auto-generated constructor stub
	}
	public List<Distributer>   getDistributers(String company) throws URISyntaxException, IOException, InterruptedException
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
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/getdistributers/"+company)).POST(BodyPublishers.ofString(company)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<Distributer> distributer  = mapper.readValue(postResponse.body(), new TypeReference<List<Distributer>>() {});
		System.out.println("hihh");
		return distributer;
	}
	public DistributerProduct   checkProduct(DistributerProduct distributerProduct) throws URISyntaxException, IOException, InterruptedException
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
		String json = ow.writeValueAsString(distributerProduct);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		//System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/checkproduct")).POST(BodyPublishers.ofString(json)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		DistributerProduct distributer=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			distributer = mapper.readValue(postResponse.body(), DistributerProduct.class);//replaced result.getResponseAsString() with res
		} catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("hihh");
		return distributer;
	}
	public Distributer   getDistributer(String company) throws URISyntaxException, IOException, InterruptedException
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
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/getdistributerBydistributerid/"+company)).POST(BodyPublishers.ofString(company)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		Distributer distributer=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			distributer = mapper.readValue(postResponse.body(), Distributer.class);//replaced result.getResponseAsString() with res
		} catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("hihh");
		return distributer;
	}
	public List<DistributerProduct>  getproductsByproductname(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/getproductsByproductname/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<DistributerProduct> itemModel  = mapper.readValue(postResponse.body(), new TypeReference<List<DistributerProduct>>() {});
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
	public List<DistributerProduct>  getproductsBydistributerid(String companyid) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/getproductsBydistributerid/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		List<DistributerProduct> itemModel  = mapper.readValue(postResponse.body(), new TypeReference<List<DistributerProduct>>() {});
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
	
	public DistributerManufactureOrder  findOrder (int company) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		String companyid = Integer.toString(company);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/checkorder/"+companyid)).POST(BodyPublishers.ofString(companyid)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		DistributerManufactureOrder distributerManufactureOrder=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			distributerManufactureOrder = mapper.readValue(postResponse.body(), DistributerManufactureOrder.class);//replaced result.getResponseAsString() with res
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
		 
		return  distributerManufactureOrder;
	}
	public boolean   updateDistributer(Distributer distributer) throws URISyntaxException, IOException, InterruptedException
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
		String json = ow.writeValueAsString(distributer);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/updatedistributer")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	
	public boolean   createProduct(DistributerProduct distributerProduct) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(distributerManufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(distributerProduct);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/createproduct")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	
	public boolean   createOrder(DistributerManufactureOrder distributerManufactureOrder) throws URISyntaxException, IOException, InterruptedException
	{
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper
		      .writerWithDefaultPrettyPrinter()
		      .writeValueAsString(supplierController);
		System.out.println(requestBody);
		*/
		//System.out.println(distributerManufactureOrder.getItemid());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(distributerManufactureOrder);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/createmanufactureorder")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	
	public DistributerProduct  findProductbyupc(String company) throws URISyntaxException, IOException, InterruptedException
	{
		
		SupplierController supplierController = new SupplierController();
		//String companyid = Integer.toString(company);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/getproductbyupc/"+company)).POST(BodyPublishers.ofString(company)).build();		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String lsm2="";
		//System.out.println(postResponse.body());
		ObjectMapper mapper = new ObjectMapper();
		//RawmaterialModel rawmaterialModel  = mapper.readValue(postResponse.body(), new TypeReference<RawmaterialModel>() {});
		//System.out.println("hihh");
		DistributerProduct distributerProduct=null;
		//StatusResponses loginValidator = null;
		//ItemModel itemModel  = mapper.readValue(postResponse.body(), new TypeReference<ItemModel>() {});
		try {
		    //String res = postResponse.getResponseAsString();//{"status":"true","msg":"success"}
			distributerProduct = mapper.readValue(postResponse.body(), DistributerProduct.class);//replaced result.getResponseAsString() with res
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
		 
		return  distributerProduct;
	}
	
	public boolean   updateDistributerProduct(DistributerProduct distributerProduct) throws URISyntaxException, IOException, InterruptedException
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
		String json = ow.writeValueAsString(distributerProduct);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/updatebyupc")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
	public boolean   updateManufactureorderstatus(DistributerManufactureOrder distributerManufactureOrder) throws URISyntaxException, IOException, InterruptedException
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
		String json = ow.writeValueAsString(distributerManufactureOrder);
		//System.out.println(manufactureOrder.getItemid());
		//Gson gson = new Gson();
	    //String jsons = gson.toJson(json);
		System.out.println(json);
		HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Distributer/distributer/updatemanufactureorderstatus")).setHeader("Content-type", "application/json").POST(BodyPublishers.ofString(json)).build();		
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
}
