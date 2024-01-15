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

import neu.edu.controller.request.DistributerModel;
import neu.edu.controller.request.ManufactureorderModel;
import neu.edu.controller.request.ProductModel;
import neu.edu.controller.response.GenericResponse;
import neu.edu.entity.Distributer;
import neu.edu.entity.Manufactureorder;
import neu.edu.entity.Product;
import neu.edu.service.DistributerService;

@RestController
@RequestMapping("/distributer")
public class DistributerController {

	public DistributerController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired(required=true)
	private DistributerService distributerService;

	@PostMapping("/createdistributer")
	public @ResponseBody ResponseEntity<GenericResponse> createUser(@Valid @RequestBody DistributerModel distributerModel){
		
		GenericResponse response = distributerService.createUser(distributerModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/createproduct")
	public @ResponseBody ResponseEntity<GenericResponse> createproduct(@Valid @RequestBody ProductModel productModel){
		
		GenericResponse response = distributerService.createProduct(productModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/checkproduct")
    public Product checkproduct(@Valid @RequestBody Product product){
		System.out.println("hii");
		Product sm= distributerService.checkproduct(product);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/updatebyupc")
	public @ResponseBody ResponseEntity<GenericResponse> updatebyupc(@Valid @RequestBody Product product){
		
		GenericResponse response = distributerService.updateproductbyupc(product);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/updatemanufactureorderstatus")
	public @ResponseBody ResponseEntity<GenericResponse> updatemanufactureorderstatus(@Valid @RequestBody ManufactureorderModel manufactureorder){
		
		GenericResponse response = distributerService.updatemanufactureOrderStatus(manufactureorder);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/createmanufactureorder")
	public @ResponseBody ResponseEntity<GenericResponse> createUser(@Valid @RequestBody ManufactureorderModel manufactureorderModel){
		
		GenericResponse response = distributerService.createManufactureorder(manufactureorderModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/getdistributerBydistributerid/{id}")
    public Distributer getdistributerBydistributerid(@PathVariable("id") String id){
		System.out.println("hii");
		Distributer sm= distributerService.getdistributerBydistributerid(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getproductbyupc/{id}")
	public Product getproductbyupc(@PathVariable("id") String id){
		System.out.println("hii");
		Product sm= distributerService.getproductsByupc(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getproductsBydistributerid/{id}")
    public List<Product> getproductsBydistributerid(@PathVariable("id") String id){
		System.out.println("hii");
		List<Product> sm= distributerService.getproductsBydistributerid(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/checkorder/{id}")
    public Manufactureorder getOrderByorderId(@PathVariable("id") String id){
		System.out.println("hii");
		Manufactureorder sm= distributerService.getmanufactureorderbyorderID(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getproductsByproductname/{id}")
    public List<Product> getproductsByproductname(@PathVariable("id") String id){
		System.out.println("hii");
		List<Product> sm= distributerService.getproductsByproductname(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getdistributers/{id}")
    public List<Distributer> getdistributers(@PathVariable("id") String id){
		System.out.println("hii");
		List<Distributer> sm= distributerService.getdistributers();
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@RequestMapping("/updatedistributer")
	 public @ResponseBody ResponseEntity<GenericResponse> updateDistributer(@RequestBody DistributerModel distributerModel) throws JsonMappingException, JsonProcessingException{
			System.out.println("herrrep");
			//System.out.println(input.getPoliticalissues());
			//System.out.println(id);
			GenericResponse response= distributerService.updateDistributer(distributerModel);
			//System.out.println(sm.getWeather()+"from supplier");
			
			return new ResponseEntity<>(response, HttpStatus.CREATED);
	        
	    }
}
