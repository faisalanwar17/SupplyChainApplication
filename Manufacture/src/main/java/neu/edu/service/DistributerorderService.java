package neu.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import neu.edu.controller.request.DistributerorderModel;

import neu.edu.controller.request.ProductModel;
import neu.edu.controller.request.SupplierorderModel;
import neu.edu.controller.response.GenericResponse;
import neu.edu.entity.Distributerorder;
import neu.edu.entity.Product;
import neu.edu.repository.DistributerorderRepository;
import neu.edu.repository.ManufactureRepository;
import neu.edu.repository.ProductRepository;
import neu.edu.repository.SupplierorderRepository;
@Service
public class DistributerorderService {

	public DistributerorderService() {
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
	/*
	@Autowired(required=false)
	
	public GenericResponse createDistributerorder(DistributerorderModel distributerorderModel) {
		
		Distributerorder dis = new Distributerorder();
		dis.setOrderid(distributerorderModel.getOrderid());
		dis.setProductid(distributerorderModel.getProductid());
		dis.setProductname(distributerorderModel.getProductname());
		dis.setManufactureid(distributerorderModel.getManufactureid());
		dis.setStatus(distributerorderModel.getStatus());
		dis.setUnits(distributerorderModel.getUnits());
		dis.setCost(distributerorderModel.getCost());
		
		
		
		distributerorderRepository.save(dis);
		
		return new GenericResponse(true);
		
	}
	*/
	public  GenericResponse updateDistributerorderbystatus(DistributerorderModel distributerorderModel) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		//ObjectMapper objectMapper = new ObjectMapper();
		//SupplierModel supplierModel = objectMapper.readValue(supplierid, SupplierModel.class);
		int id= distributerorderModel.getOrderid();
		String avai = distributerorderModel.getStatus();
		
		
		distributerorderRepository.updateByorderid(id,avai);
		return new GenericResponse(true);
	}
	public List<Distributerorder> getdistributerorderBymanufactureid(String id) {
		// TODO Auto-generated method stub
		//int id1=Integer.parseInt(id);
		return distributerorderRepository.findBymanufactureid(id);
	}
	public Distributerorder getdistributerorderbyorderid(String id) {
		// TODO Auto-generated method stub
		int id1=Integer.parseInt(id);
		return distributerorderRepository.findByorderid(id1);
	}


}
