package neu.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import neu.edu.controller.request.ItemModel;
import neu.edu.controller.request.OrderModel;
import neu.edu.controller.request.SupplierModel;
import neu.edu.controller.response.GenericResponse;
import neu.edu.entity.Item;
import neu.edu.entity.Orders;
import neu.edu.entity.Supplier;
import neu.edu.repository.OrdersRepository;
import neu.edu.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	
	
	public SupplierService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired(required=false)
	public GenericResponse createSupplier(SupplierModel supplierModel)
	{
		
		Supplier supplier= new Supplier();
		
		supplier.setSupplierid(supplierModel.getSupplierid());
		supplier.setWeather(supplier.getWeather());
		supplier.setDriverissues(supplierModel.getDriverissues());
		supplier.setLabourissues(supplierModel.getLabourissues());
		supplier.setPoliticalissues(supplierModel.getPoliticalissues());
		supplierRepository.save(supplier);
		return new GenericResponse(true);
		
		
	}

	public Supplier getItemsBySupplierId(String supplierid) {
		// TODO Auto-generated method stub
		return supplierRepository.findBysupplierid(supplierid);
	}
	public List<Orders> getOrderBySupplierId(String supplierid) {
		// TODO Auto-generated method stub
		return ordersRepository.findBysupplierid(supplierid);
	}
	public Orders getOrderByOrderId(String supplierid) {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(supplierid);
		return ordersRepository.findByorderid(id);
	}
	public List<Supplier> listAll() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}
	@Autowired(required=false)
	public GenericResponse createOrder(OrderModel orderModel)
	{
		
		Orders order = new Orders();
		
		order.setCost(orderModel.getCost());
		order.setItemid(orderModel.getItemid());
		order.setItemname(orderModel.getItemname());
		order.setOrderid(orderModel.getOrderid());
		order.setStatus(orderModel.getStatus());
		order.setSupplierid(orderModel.getSupplierid());
		order.setUnits(orderModel.getUnits());
		ordersRepository.save(order);
		return new GenericResponse(true);
		
		
	}
	public  GenericResponse updateSuppplier(SupplierModel supplierModel) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		//ObjectMapper objectMapper = new ObjectMapper();
		//SupplierModel supplierModel = objectMapper.readValue(supplierid, SupplierModel.class);
		String id= supplierModel.getSupplierid();
		String we = supplierModel.getWeather();
		String po =supplierModel.getPoliticalissues();
		String li =supplierModel.getLabourissues();
		String di =supplierModel.getDriverissues();
		supplierRepository.updateBysupplierid(id,we,po,li,di);
		return new GenericResponse(true);
	}
}
