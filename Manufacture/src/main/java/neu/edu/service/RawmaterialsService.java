package neu.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.request.ProductModel;
import neu.edu.controller.request.RawmaterialsModel;
import neu.edu.controller.request.SupplierorderModel;
import neu.edu.controller.response.GenericResponse;
import neu.edu.entity.Product;
import neu.edu.entity.Rawmaterial;

import neu.edu.repository.RawmaterialsRepository;
import neu.edu.repository.SupplierorderRepository;

@Service
public class RawmaterialsService {

	public RawmaterialsService() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private RawmaterialsRepository rawmaterialsRepository;
	@Autowired
	private SupplierorderRepository supplierorderRepository;
	public GenericResponse createRawmaterial(RawmaterialsModel rawmaterialsModel) {
		
		Rawmaterial rawmaterials = new Rawmaterial();
		rawmaterials.setMaterialid(rawmaterialsModel.getMaterialid());
		rawmaterials.setItemid(rawmaterialsModel.getItemid());
		rawmaterials.setItemname(rawmaterialsModel.getItemname());
		rawmaterials.setAvailability(rawmaterialsModel.getAvailability());
		rawmaterials.setManufactureid(rawmaterialsModel.getManufactureid());
		
		rawmaterialsRepository.save(rawmaterials);
		
		return new GenericResponse(true);
		
	}
public GenericResponse updateRawmaterial(RawmaterialsModel rawmaterialsModel) {
		
		String id=rawmaterialsModel.getMaterialid();
		int avai =rawmaterialsModel.getAvailability();
		
		rawmaterialsRepository.updateBymaterialid(id,avai);
		
		return new GenericResponse(true);
		
	}
public GenericResponse updateOrderStatus(SupplierorderModel supplierorderModel) {
	
	int id=supplierorderModel.getOrderid();
	String avai =supplierorderModel.getStatus();
	
	supplierorderRepository.updateByorderid(id,avai);
	
	return new GenericResponse(true);
	
}
	public List<Rawmaterial> getItemsBymanufacureId(String id) {
		// TODO Auto-generated method stub
		return rawmaterialsRepository.findBymanufactureid(id);
	}
	public Rawmaterial getItemsByrawId(String id) {
		// TODO Auto-generated method stub
		//int id1=Integer.parseInt(id);
		return rawmaterialsRepository.findBymaterialid(id);
	}
	public Rawmaterial getrawmaterialbyitemname(RawmaterialsModel rawmaterialsModel) {
		// TODO Auto-generated method stub
		//int id1=Integer.parseInt(id);
		String id= rawmaterialsModel.getManufactureid();
		String name= rawmaterialsModel.getItemname();
		return rawmaterialsRepository.getrawmaterial(name,id);
	}

}
