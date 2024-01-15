package neu.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import neu.edu.controller.request.ItemModel;
import neu.edu.controller.request.OrderModel;
import neu.edu.controller.request.SupplierModel;
import neu.edu.controller.response.GenericResponse;
import neu.edu.entity.Item;
import neu.edu.entity.Orders;
import neu.edu.entity.Supplier;
import neu.edu.service.ItemService;
import neu.edu.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    public SupplierController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired(required=true)
	private SupplierService supplierService;
	@Autowired(required=true)
	private ItemService itemService;

	@PostMapping("/create")
	public @ResponseBody ResponseEntity<GenericResponse> createUser(@Valid @RequestBody SupplierModel supplierModel){
		System.out.println("hii");
		GenericResponse response = supplierService.createSupplier(supplierModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/createitem")
	public @ResponseBody ResponseEntity<GenericResponse> createItem(@Valid @RequestBody ItemModel itemModel){
		System.out.println("hii");
		GenericResponse response = itemService.createItem(itemModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/createorder")
	public @ResponseBody ResponseEntity<GenericResponse> createOrder(@Valid @RequestBody OrderModel orderModel){
		System.out.println("hii");
		GenericResponse response = supplierService.createOrder(orderModel);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		//return new GenericResponse(true);
	}
	@PostMapping("/checkitem")
	public @ResponseBody boolean checkItem(@Valid @RequestBody ItemModel itemModel){
		System.out.println("hii");
		boolean response = itemService.checkItem(itemModel.getItemname(),itemModel.getSupplierid());
		return response;
		//return new GenericResponse(true);
	}
	/*
	@GetMapping("/item/{id}")
    public List<Supplier> getItemsById(@PathVariable String supplierId){
		System.out.println("hii");
		return supplierService.getItemsBySupplierId(supplierId);
        
    }
    */
	@PostMapping("/item/{id}")
    public Supplier getItemsById(@PathVariable("id") String id){
		System.out.println("hii");
		Supplier sm= supplierService.getItemsBySupplierId(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getorder/{id}")
    public List<Orders> getOrderBysuppplierId(@PathVariable("id") String id){
		System.out.println("hii");
		List<Orders> sm= supplierService.getOrderBySupplierId(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getorderbyid/{id}")
    public Orders getOrderByOrderId(@PathVariable("id") String id){
		System.out.println("hii");
		Orders sm= supplierService.getOrderByOrderId(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getitems/{id}")
    public List<Item> getItemsBySupplierId(@PathVariable("id") String id){
		System.out.println("hii");
		List<Item> sm= itemService.getItemsBySupplierId(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getitemsbyname/{id}")
    public List<Item> getItemsByItemname(@PathVariable("id") String id){
		System.out.println("hii");
		List<Item> sm= itemService.getItemsByItemname(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/getitem/{id}")
    public Item getItemsByItemId(@PathVariable("id") String id){
		System.out.println("hii");
		
		Item sm= itemService.getItemsByItemId(id);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	@PostMapping("/list")
    public List<Supplier> getAllSupplier(){
		System.out.println("hii");
		List<Supplier> sm= supplierService.listAll();
		//System.out.println(sm.getWeather()+"from supplier");
		
		return sm;
        
    }
	//@RequestMapping("/update"")
	//@ResponseBody
	//@PostMapping("/update")
	@RequestMapping("/update")
    public @ResponseBody ResponseEntity<GenericResponse> updateSupplier(@RequestBody SupplierModel input) throws JsonMappingException, JsonProcessingException{
		System.out.println("herrrep");
		System.out.println(input.getPoliticalissues());
		//System.out.println(id);
		GenericResponse response= supplierService.updateSuppplier(input);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
        
    }
	@RequestMapping("/updateorderstatus")
    public @ResponseBody ResponseEntity<GenericResponse> updateorderstatus(@RequestBody OrderModel input) throws JsonMappingException, JsonProcessingException{
		System.out.println("herrrep");
		
		//System.out.println(id);
		GenericResponse response= itemService.updateOrderbystatus(input);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
        
    }
	@RequestMapping("/updateitem")
    public @ResponseBody ResponseEntity<GenericResponse> updateItem(@RequestBody ItemModel itemModel) throws JsonMappingException, JsonProcessingException{
		System.out.println("herrrep");
		//System.out.println(input.getPoliticalissues());
		//System.out.println(id);
		GenericResponse response= itemService.updateItem(itemModel);
		//System.out.println(sm.getWeather()+"from supplier");
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
        
    }
	

}
