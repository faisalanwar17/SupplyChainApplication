package neu.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import neu.edu.controller.request.OrderModel;
import neu.edu.controller.request.ProductModel;
import neu.edu.controller.request.RawmaterialsModel;
import neu.edu.controller.request.SupplierorderModel;
import neu.edu.controller.response.GenericResponse;
import neu.edu.entity.Distributerorder;
import neu.edu.entity.Manufacture;
import neu.edu.entity.Product;
import neu.edu.entity.Rawmaterial;
import neu.edu.entity.Supplierorder;
import neu.edu.repository.DistributerorderRepository;
import neu.edu.repository.ManufactureRepository;
import neu.edu.repository.ProductRepository;
import neu.edu.repository.SupplierorderRepository;


@Service
public class ProductService {

	public ProductService() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private SupplierorderRepository supplierorderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ManufactureRepository manufactureRepository;
	@Autowired
	private DistributerorderRepository distributerorderRepository;
	
	@Autowired(required=false)
	public GenericResponse createUser(ProductModel productModel) {
		
		Product product = new Product();
		product.setProductid(productModel.getProductid());
		product.setProductname(productModel.getProductname());
		product.setManufactureid(productModel.getManufactureid());
		product.setAvailability(productModel.getAvailability());
		product.setCost(productModel.getCost());
		
		
		
		productRepository.save(product);
		
		return new GenericResponse(true);
		
	}
public GenericResponse updateManufacture(Manufacture manufacture) {
		
		String id= manufacture.getManufactureid();
		String we= manufacture.getWeather();
		String po = manufacture.getPoliticalissues();
		String la = manufacture.getLabourissues();
		String dr= manufacture.getDriverissues();
		
		manufactureRepository.updateBymanufactureid(id, we, po, la, dr);
		
		return new GenericResponse(true);
		
	}
	public Supplierorder getItemsByorderId(String id) {
		// TODO Auto-generated method stub
		int id1=Integer.parseInt(id);
		return supplierorderRepository.findByorderid(id1);
	}
	public Manufacture getmanufactureBymanufactureid(String id) {
		// TODO Auto-generated method stub
		//int id1=Integer.parseInt(id);
		return manufactureRepository.findBymanufactureid(id);
	}
	public Product getproductByproductid(String id) {
		// TODO Auto-generated method stub
		int id1=Integer.parseInt(id);
		return productRepository.findByproductid(id1);
	}
	public Product checkproductbynameandid(Product product) {
		// TODO Auto-generated method stub
		String id1=product.getManufactureid();
		String name=product.getProductname();
		return productRepository.findbynameandid(id1,name);
	}
	public List<Product> getproductBymanufactureid(String id) {
		// TODO Auto-generated method stub
		//int id1=Integer.parseInt(id);
		return productRepository.findBymanufactureid(id);
	}
	public List<Product> getproductBymproductname(String id) {
		// TODO Auto-generated method stub
		//int id1=Integer.parseInt(id);
		return productRepository.findByproductname(id);
	}
	public  GenericResponse updateProduct(ProductModel product) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		//ObjectMapper objectMapper = new ObjectMapper();
		//SupplierModel supplierModel = objectMapper.readValue(supplierid, SupplierModel.class);
		int id= product.getProductid();
		int avai = product.getAvailability();
		int cost =product.getCost();
		
		productRepository.updateByproductid(id,avai,cost);
		return new GenericResponse(true);
	}
	@Autowired(required=false)
	public GenericResponse createOrder(SupplierorderModel supplierorderModel) {
		
		Supplierorder order = new Supplierorder();
		
		order.setCost(supplierorderModel.getCost());
		order.setItemid(supplierorderModel.getItemid());
		order.setItemname(supplierorderModel.getItemname());
		order.setOrderid(supplierorderModel.getOrderid());
		order.setStatus(supplierorderModel.getStatus());
		order.setSupplierid(supplierorderModel.getSupplierid());
		order.setUnits(supplierorderModel.getUnits());
		order.setManufactureid(supplierorderModel.getManufactureid());
		System.out.println("hib");
		supplierorderRepository.save(order);
		
		System.out.println("hibb");
		
		
		
		return new GenericResponse(true);
		
	}
	
	@Autowired(required=false)
	public GenericResponse createdistributerOrder(OrderModel orderModel) {
		
		Distributerorder order = new Distributerorder();
		
		order.setCost(orderModel.getCost());
		order.setProductid(orderModel.getItemid());
		order.setProductname(orderModel.getItemname());
		order.setOrderid(orderModel.getOrderid());
		order.setStatus(orderModel.getStatus());
		order.setManufactureid(orderModel.getSupplierid());
		order.setUnits(orderModel.getUnits());
	
		System.out.println("hib");
		distributerorderRepository.save(order);
		
		System.out.println("hibb");
		
		
		
		return new GenericResponse(true);
		
	}
	

/*
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	public List<User> viewAllUsersByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	public List<User> viewAllUsersByName(String firstName) {
		// TODO Auto-generated method stub
		return userRepository.findByfirstName(firstName);
	}
	
*/
}
