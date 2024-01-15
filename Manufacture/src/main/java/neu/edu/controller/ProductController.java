package neu.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import neu.edu.controller.request.DistributerorderModel;
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
import neu.edu.repository.ManufactureRepository;
import neu.edu.service.DistributerorderService;
import neu.edu.service.ProductService;
import neu.edu.service.RawmaterialsService;

@RestController
@RequestMapping("/manufacture")
public class ProductController {

	public ProductController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired(required=true)
	private ProductService productService;
	@Autowired(required=true)
	private RawmaterialsService rawmaterialsService;
	@Autowired(required=true)
	private DistributerorderService distributerorderService;
	@PostMapping("/createproduct")
	public @ResponseBody ResponseEntity<GenericResponse> createUser(@Valid @RequestBody ProductModel productModel){
		
		GenericResponse response = productService.createUser(productModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/checkorder/{id}")
    public Supplierorder getOrderByorderId(@PathVariable("id") String id){
		System.out.println("hii");
		Supplierorder sm= productService.getItemsByorderId(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getrawmaterials/{id}")
    public List<Rawmaterial> getItemsByManufactureId(@PathVariable("id") String id){
		System.out.println("hii");
		List<Rawmaterial> sm= rawmaterialsService.getItemsBymanufacureId(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getproducts/{id}")
    public List<Product> getproductBymanufactureid(@PathVariable("id") String id){
		System.out.println("hii");
		List<Product> sm= productService.getproductBymanufactureid(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getproductsbyproductname/{id}")
    public List<Product> getproductsbyproductname(@PathVariable("id") String id){
		System.out.println("hii");
		List<Product> sm= productService.getproductBymproductname(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getrawmaterialbyrawid/{id}")
    public Rawmaterial getrawmaterialbyitemid(@PathVariable("id") String id){
		System.out.println("hii");
		Rawmaterial sm= rawmaterialsService.getItemsByrawId(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/checkproduct/{id}")
    public Product getproductByproductid(@PathVariable("id") String id){
		System.out.println("hii");
		Product sm= productService.getproductByproductid(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getmanufacture/{id}")
    public Manufacture getmanufacture(@PathVariable("id") String id){
		System.out.println("hii");
		Manufacture sm= productService.getmanufactureBymanufactureid(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getdistributerorderbymanufacture/{id}")
    public List<Distributerorder> getdistributerorderbymanufacture(@PathVariable("id") String id){
		System.out.println("hii");
		List<Distributerorder> sm= distributerorderService.getdistributerorderBymanufactureid(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getdistributerorderbyid/{id}")
    public Distributerorder getdistributerorderbyorderid(@PathVariable("id") String id){
		System.out.println("hii");
		Distributerorder sm= distributerorderService.getdistributerorderbyorderid(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getrawmaterialbyitemname")
    public Rawmaterial getrawmaterialbyitemname(@Valid @RequestBody RawmaterialsModel rawmaterialsModel){
		System.out.println("hii");
		Rawmaterial sm= rawmaterialsService.getrawmaterialbyitemname(rawmaterialsModel);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/checkproductbynameandid")
    public Product checkproductbynameandid(@Valid @RequestBody Product product){
		System.out.println("hii");
		Product sm= productService.checkproductbynameandid(product);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/createorder")
	public @ResponseBody ResponseEntity<GenericResponse> createOrder(@Valid @RequestBody SupplierorderModel supplierorderModel){
		System.out.println("hi");
		GenericResponse response = productService.createOrder(supplierorderModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	
	
	@PostMapping("/createdistributerorder")
	public @ResponseBody ResponseEntity<GenericResponse> createdistributerOrder(@Valid @RequestBody OrderModel orderModel){
		System.out.println("hi");
		GenericResponse response = productService.createdistributerOrder(orderModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/createrawmaterial")
	public @ResponseBody ResponseEntity<GenericResponse> createRawmaterial(@Valid @RequestBody RawmaterialsModel rawmaterialsModel){
		System.out.println("hi");
		GenericResponse response = rawmaterialsService.createRawmaterial(rawmaterialsModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	/*
	@PostMapping("/createdistributerorder")
	public @ResponseBody ResponseEntity<GenericResponse> createRawmaterial(@Valid @RequestBody DistributerorderModel distributerorderModel){
		System.out.println("hi");
		GenericResponse response = distributerorderService.createDistributerorder(distributerorderModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	*/
	
	@RequestMapping("/updaterawmaterial")
    public @ResponseBody ResponseEntity<GenericResponse> updateRawmaterial(@RequestBody RawmaterialsModel rawmaterialsModel) throws JsonMappingException, JsonProcessingException{
		System.out.println("herrrep");
		//System.out.println(input.getPoliticalissues());
		//System.out.println(id);
		GenericResponse response= rawmaterialsService.updateRawmaterial(rawmaterialsModel);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
        
    }
	@RequestMapping("/updateDistributerorderbystatus")
    public @ResponseBody ResponseEntity<GenericResponse> updateDistributerorderbystatus(@RequestBody DistributerorderModel distributerorderModel) throws JsonMappingException, JsonProcessingException{
		System.out.println("herrrep");
		//System.out.println(input.getPoliticalissues());
		//System.out.println(id);
		GenericResponse response= distributerorderService.updateDistributerorderbystatus(distributerorderModel);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
        
    }
	@RequestMapping("/updatemanufacture")
	 public @ResponseBody ResponseEntity<GenericResponse> updateManufacture(@RequestBody Manufacture manufacture) throws JsonMappingException, JsonProcessingException{
			System.out.println("herrrep");
			//System.out.println(input.getPoliticalissues());
			//System.out.println(id);
			GenericResponse response= productService.updateManufacture(manufacture);
			//System.out.println(sm.getWeather()+"from supplier");
			
			return new ResponseEntity<>(response, HttpStatus.CREATED);
	        
	    }
	@RequestMapping("/updateproduct")
	 public @ResponseBody ResponseEntity<GenericResponse> updateProduct(@RequestBody ProductModel productModel) throws JsonMappingException, JsonProcessingException{
			System.out.println("herrrep");
			//System.out.println(input.getPoliticalissues());
			//System.out.println(id);
			GenericResponse response= productService.updateProduct(productModel);
			//System.out.println(sm.getWeather()+"from supplier");
			
			return new ResponseEntity<>(response, HttpStatus.CREATED);
	        
	    }
	@RequestMapping("/updateorderstatus")
    public @ResponseBody ResponseEntity<GenericResponse> updateOrderStatus(@RequestBody SupplierorderModel supplierorderModel) throws JsonMappingException, JsonProcessingException{
		System.out.println("herrrep");
		//System.out.println(input.getPoliticalissues());
		//System.out.println(id);
		GenericResponse response= rawmaterialsService.updateOrderStatus(supplierorderModel);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
        
    }

}
