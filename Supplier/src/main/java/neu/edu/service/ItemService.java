package neu.edu.service;


import java.util.List;
import java.util.Objects;

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
import neu.edu.entity.Supplier;
import neu.edu.repository.ItemRepository;
import neu.edu.repository.OrdersRepository;
import neu.edu.repository.SupplierRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	public ItemService() {
		// TODO Auto-generated constructor stub
	}
	public  GenericResponse updateItem(ItemModel itemModel) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		//ObjectMapper objectMapper = new ObjectMapper();
		//SupplierModel supplierModel = objectMapper.readValue(supplierid, SupplierModel.class);
		int id= itemModel.getItemid();
		int avai = itemModel.getAvailability();
		int cost =itemModel.getCost();
		
		itemRepository.updateByItemid(id,avai,cost);
		return new GenericResponse(true);
	}
	public  GenericResponse updateOrderbystatus(OrderModel orderModel) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		//ObjectMapper objectMapper = new ObjectMapper();
		//SupplierModel supplierModel = objectMapper.readValue(supplierid, SupplierModel.class);
		int id= orderModel.getOrderid();
		String avai = orderModel.getStatus();
		
		
		ordersRepository.updateByorderid(id,avai);
		return new GenericResponse(true);
	}
	@Autowired(required=false)
	public boolean checkItem(String name, String id)
	{
	 Item item=itemRepository.checkItem(name,id);
	 System.out.println(Objects.isNull(item));
	 if(Objects.isNull(item))
	 {
		 return false;
		 
	 }
	 return true;
	}
	@Autowired(required=false)
	public GenericResponse createItem(ItemModel itemModel)
	{
		
		Item item = new Item();
		
		item.setItemid(itemModel.getItemid());
		item.setItemname(itemModel.getItemname());
		item.setSupplierid(itemModel.getSupplierid());
		item.setAvailability(itemModel.getAvailability());
		item.setCost(itemModel.getCost());
		itemRepository.save(item);
		return new GenericResponse(true);
		
		
	}
	public List<Item> getItemsBySupplierId(String supplierid) {
		// TODO Auto-generated method stub
		//Supplier sup  = supplierRepository.findBysupplierid(supplierid);
		return itemRepository.findBysupplierid(supplierid);
	}
	public Item getItemsByItemId(String id1) {
		// TODO Auto-generated method stub
		//Supplier sup  = supplierRepository.findBysupplierid(supplierid);
		int id=Integer.parseInt(id1);
		return itemRepository.findByitemid(id);
	}
	public List<Item> getItemsByItemname(String itemname) {
		// TODO Auto-generated method stub
		//Supplier sup  = supplierRepository.findBysupplierid(supplierid);
		return itemRepository.findByitemname(itemname);
	}

}
