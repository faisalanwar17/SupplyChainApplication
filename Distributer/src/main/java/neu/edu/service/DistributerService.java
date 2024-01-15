package neu.edu.service;

import java.util.List;

import org.apache.catalina.authenticator.FormAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.request.DistributerModel;
import neu.edu.controller.request.ManufactureorderModel;
import neu.edu.controller.request.ProductModel;
import neu.edu.controller.response.GenericResponse;
import neu.edu.entity.Distributer;
import neu.edu.entity.Manufactureorder;
import neu.edu.entity.Product;
import neu.edu.repository.DistributerRepository;
import neu.edu.repository.ManufactureorderRepository;
import neu.edu.repository.ProductRepository;

@Service
public class DistributerService {

	public DistributerService() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private DistributerRepository distributerRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ManufactureorderRepository manufactureorderRepository;
	
	
	public GenericResponse createUser(DistributerModel distributerModel) {
		
		Distributer distributer = new Distributer();

		distributer.setDriverissues(distributerModel.getDriverissues());
		distributer.setLabourissues(distributerModel.getLabourissues());
		distributer.setPoliticalissues(distributerModel.getPoliticalissues());

		distributer.setWeather(distributerModel.getWeather());
		
		
		distributerRepository.save(distributer);
		
		return new GenericResponse(true);
		
	}
	public GenericResponse createProduct(ProductModel productModel) {
		
		Product product= new Product();

		product.setAvailability(productModel.getAvailability());
		product.setCost(productModel.getCost());
		product.setDistributerid(productModel.getDistributerid());
		product.setProductid(productModel.getProductid());
		product.setProductname(productModel.getProductname());
		product.setProductupc(productModel.getProductupc());
		productRepository.save(product);
		
		return new GenericResponse(true);
		
	}
	public GenericResponse createManufactureorder(ManufactureorderModel manufactureorderModel) {
		
		Manufactureorder manufactor = new Manufactureorder();

		manufactor.setCost(manufactureorderModel.getCost());
		manufactor.setDistributerid(manufactureorderModel.getDistributerid());
		manufactor.setManufactureid(manufactureorderModel.getManufactureid());
		manufactor.setOrderid(manufactureorderModel.getOrderid());
		manufactor.setProductid(manufactureorderModel.getProductid());
		manufactor.setProductname(manufactureorderModel.getProductname());
		manufactor.setStatus(manufactureorderModel.getStatus());
		manufactor.setUnits(manufactureorderModel.getUnits());
		
		
		
		manufactureorderRepository.save(manufactor);
		
		return new GenericResponse(true);
		
	}
public GenericResponse updateDistributer(DistributerModel distributer) {
		
		String id= distributer.getDistributerid();
		String we= distributer.getWeather();
		String po = distributer.getPoliticalissues();
		String la = distributer.getLabourissues();
		String dr= distributer.getDriverissues();
		
		distributerRepository.updateBydistributerid(id, we, po, la, dr);
		
		return new GenericResponse(true);
		
	}
public Distributer getdistributerBydistributerid(String id) {
	// TODO Auto-generated method stub
	//int id1=Integer.parseInt(id);
	return distributerRepository.findBydistributerid(id);
}
public Product checkproduct(Product product) {
	// TODO Auto-generated method stub
	//int id1=Integer.parseInt(id);
	String id=product.getDistributerid();
	String name=product.getProductname();
	return productRepository.findBydistributeridandname(id,name);
}
public Manufactureorder getmanufactureorderbyorderID(String id) {
	// TODO Auto-generated method stub
	int id1=Integer.parseInt(id);
	return manufactureorderRepository.findByorderid(id1);
}

public List<Product> getproductsBydistributerid(String id) {
	// TODO Auto-generated method stub
	//int id1=Integer.parseInt(id);
	return productRepository.findBydistributerid(id);
}
public Product getproductsByupc(String id) {
	// TODO Auto-generated method stub
	//int id1=Integer.parseInt(id);
	return productRepository.findByproductupc(id);
}
public List<Product> getproductsByproductname(String id) {
	// TODO Auto-generated method stub
	//int id1=Integer.parseInt(id);
	return productRepository.findByproductname(id);
}
public List<Distributer> getdistributers( ) {
	// TODO Auto-generated method stub
	//int id1=Integer.parseInt(id);
	return distributerRepository.findAll();
}
public GenericResponse updatemanufactureOrderStatus(ManufactureorderModel manufactureorderModel) {
	
	int id=manufactureorderModel.getOrderid();
	String avai =manufactureorderModel.getStatus();
	
	manufactureorderRepository.updateByorderid(id,avai);
	
	return new GenericResponse(true);
	
}
public GenericResponse updateproductbyupc(Product product) {
	
	String id=product.getProductupc();
	int avai =product.getAvailability();
	int cost=product.getCost();
	
	productRepository.updateByproductupc(id, avai,cost);
	
	return new GenericResponse(true);
	
}
}
