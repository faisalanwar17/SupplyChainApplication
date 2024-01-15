package neu.edu.controller;
/*
This file is the controller of  Manufacture Springboot application which is a microservice of the Supply Chain Management System project, 
this controller maps the API request from the Supplier and the Distributor checks the inventory of products and items and  returns the appropriate page with  information 

*/
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import neu.edu.controller.model.DistributerManufactureOrder;
import neu.edu.controller.model.DistributerOrders;
import neu.edu.controller.model.DistributerProduct;
import neu.edu.controller.model.ItemModel;
import neu.edu.controller.model.ManufactureModel;
import neu.edu.controller.model.ManufactureOrder;
import neu.edu.controller.model.Options;
import neu.edu.controller.model.ProductModel;
import neu.edu.controller.model.RawmaterialModel;
import neu.edu.controller.model.SupplierController;
import neu.edu.service.DistributerService;
import neu.edu.service.EmployeeService;
import neu.edu.service.ManufactureService;
import neu.edu.service.SupplierService;

@RestController
@Controller
@SessionAttributes("employee")
public class ManufactureController {
	@Autowired
	private ManufactureService manufactureService;
	@Autowired
	private  SupplierService supplierService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DistributerService distributerService;
	public ManufactureController() {
		// TODO Auto-generated constructor stub
	}
	// returns order dashboard with the order information for a particular manufacturer
	@RequestMapping(value = "placeOrderDashboard", method = RequestMethod.POST)
	public  ModelAndView placeOrderDashboard(@Valid @ModelAttribute RawmaterialModel rawmaterialModel,@ModelAttribute("id") String comp,@ModelAttribute("error") String error,Model model) {
		
		model.addAttribute("id",rawmaterialModel.getManufactureid());
		model.addAttribute("error",error);
	        return new ModelAndView("placeOrderDashboard");

	}

	// returns the jsp page where products can be created
	@RequestMapping(value = "createproduct", method = RequestMethod.POST)
	public  ModelAndView createProduct(@Valid @ModelAttribute RawmaterialModel rawmaterialModel,@ModelAttribute("id") String comp,@ModelAttribute("error") String error,Model model) {
		
		model.addAttribute("id",rawmaterialModel.getManufactureid());
		
	       return new ModelAndView("createProduct");

	}

	// returns all the products of a particular manufacturer
	@RequestMapping(value = "products", method = RequestMethod.POST)
	public  ModelAndView products(@Valid @ModelAttribute ProductModel productModel,@ModelAttribute("id") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		// gets product object from manufacture microservice
		List<ProductModel> product=manufactureService.findProductsBymanufactureid(productModel.getManufactureid());
		model.addAttribute("product", product);
		model.addAttribute("id",productModel.getManufactureid());
	    return new ModelAndView("products");

	}

	// Returns update manufacture page
	@RequestMapping(value = "updatemanufacture", method = RequestMethod.POST)
	public  ModelAndView updateManufacturePage(@Valid @ModelAttribute ManufactureModel manufactureModel,@ModelAttribute("id") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		// gets manufacture object from manufacture microservice
		ManufactureModel manufacture=manufactureService.getManufacture(manufactureModel.getManufactureid());
		model.addAttribute("manufacture", manufacture);
		
	    return new ModelAndView("updateManufacture");

	}

	// Updates the Manufacturer details and returns the Manager dashboard
	@RequestMapping(value = "updatemanufacturer", method = RequestMethod.POST)
	public  ModelAndView updateManufacturer(@Valid @ModelAttribute ManufactureModel manufactureModel,@ModelAttribute("id") String id,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		// updates the manufacture object and gets the object
		manufactureService.updateManufacture(manufactureModel);
		ManufactureModel manufacture = manufactureService.getManufacture(manufactureModel.getManufactureid());  
		System.out.println("done printing");
		model.addAttribute("manufactureModel",manufacture);

		return new ModelAndView("supplyManagerDashboard");
	 

	}

	// Returns the production manager dashboard
	@RequestMapping(value = "getbackproductionmanagerDashboard", method = RequestMethod.POST)
	public  ModelAndView getBackManagerDashboard(@ModelAttribute("id") String id,Model model) throws URISyntaxException, IOException, InterruptedException {

		// gets Raw material object from Supplier microservice
		List<RawmaterialModel> rawmaterialModel1 = manufactureService.findRawMaterials(id);
		
		model.addAttribute("rawmaterial",rawmaterialModel1);
		
		
		return new ModelAndView("productionManagerDashboard");

	}

	// Returns the supply manager dashboard
	@RequestMapping(value = "getbacksupplydashboard", method = RequestMethod.POST)
	public  ModelAndView getbacksupplydashboard(@Valid @ModelAttribute ProductModel productModel,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		// gets manufacture object from manufacture microservice
		ManufactureModel manufactureModel = manufactureService.getManufacture(productModel.getManufactureid());  
		System.out.println("done printing");
		model.addAttribute("manufactureModel",manufactureModel);
		
		return new ModelAndView("supplyManagerDashboard");
	}

	// returns the list of orders from a distributers for a Manufacturer 
	@RequestMapping(value = "distributerorderstomanufacture", method = RequestMethod.POST)
	public  ModelAndView distributerorderstomanufacture(@Valid @ModelAttribute DistributerOrders distributerOrders,Model model) throws URISyntaxException, IOException, InterruptedException {
		List<DistributerOrders> orders=manufactureService.findDistributerorderbymanufacture(distributerOrders.getManufactureid());
		model.addAttribute("distributerOrders",orders);
		model.addAttribute("id", distributerOrders.getManufactureid());
		return new ModelAndView("distributerOrderstomanufacture");
	}
	

	// Creates products based on the availability of raw materials 
	@RequestMapping(value = "registerproduct", method = RequestMethod.POST)
	public  ModelAndView registerProduct(@Valid @ModelAttribute ProductModel productModel,@ModelAttribute("id") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		ProductModel product=manufactureService.findProductid(productModel.getProductid());
		// returns error if the product Id already exists
		if(!(Objects.isNull(product)))
		{
			model.addAttribute("id",productModel.getManufactureid());
			String error="Product ID already exist";
			model.addAttribute("error",error);
		    return new ModelAndView("createProduct");
		}
		
		// checks if the availability of raw materials, if available then creates the product and updates the raw material quantity if not then returns error 
		if(productModel.getProductname().equalsIgnoreCase("laptop"))
		{
			RawmaterialModel material1= new RawmaterialModel();
			material1.setManufactureid(productModel.getManufactureid());
			material1.setItemname("motherboard");
			RawmaterialModel material1_availability= manufactureService.getRawmaterial(material1);
			RawmaterialModel material2= new RawmaterialModel();
			material2.setManufactureid(productModel.getManufactureid());
			material2.setItemname("ram");
			RawmaterialModel material2_availability = manufactureService.getRawmaterial(material2);
			
			if(Objects.isNull(material1_availability) ||Objects.isNull(material2_availability))
			{
				model.addAttribute("id",productModel.getManufactureid());
				String error="Raw materials not available";
				model.addAttribute("error", error);
			    return new ModelAndView("createProduct");
			}
			//System.out.println(material1_availability.getAvailability());
			//System.out.println(material2_availability.getAvailability());
			if(material1_availability.getAvailability()>=productModel.getAvailability() && material2_availability.getAvailability()>=productModel.getAvailability())
			{
				int  available1=material1_availability.getAvailability()-productModel.getAvailability();
				int  available2=material2_availability.getAvailability()-productModel.getAvailability();
				material1_availability.setAvailability(available1);
				material2_availability.setAvailability(available2);
				manufactureService.updateRawmaterial(material1_availability);
				manufactureService.updateRawmaterial(material2_availability);
				manufactureService.createProduct(productModel);
				List<RawmaterialModel> rawmaterialModel1 = manufactureService.findRawMaterials(productModel.getManufactureid());
				
				model.addAttribute("rawmaterial",rawmaterialModel1);
				model.addAttribute("id", productModel.getManufactureid());
				return new ModelAndView("productionManagerDashboard");
			}
			else
			{
				model.addAttribute("id",productModel.getManufactureid());
				String error="Your requirement is over the stock";
				model.addAttribute("error", error);
			    return new ModelAndView("createProduct");
			}
		}else if(productModel.getProductname().equalsIgnoreCase("refregirator"))
		{
			RawmaterialModel material1= new RawmaterialModel();
			material1.setManufactureid(productModel.getManufactureid());
			material1.setItemname("coolent");
			RawmaterialModel material1_availability = manufactureService.getRawmaterial(material1);
			RawmaterialModel material2= new RawmaterialModel();
			material2.setManufactureid(productModel.getManufactureid());
			material2.setItemname("compressor");
			RawmaterialModel material2_availability = manufactureService.getRawmaterial(material2);
			if(material1_availability.getAvailability()>=productModel.getAvailability() && material2_availability.getAvailability()>=productModel.getAvailability())
			{
				int  available1=material1_availability.getAvailability()-productModel.getAvailability();
				int  available2=material2_availability.getAvailability()-productModel.getAvailability();
				material1_availability.setAvailability(available1);
				material2_availability.setAvailability(available2);
				manufactureService.updateRawmaterial(material1_availability);
				manufactureService.updateRawmaterial(material2_availability);
				manufactureService.createProduct(productModel);
				List<RawmaterialModel> rawmaterialModel1 = manufactureService.findRawMaterials(productModel.getManufactureid());
				
				model.addAttribute("rawmaterial",rawmaterialModel1);
				model.addAttribute("id", productModel.getManufactureid());
				return new ModelAndView("productionManagerDashboard");
			}
			else
			{
				model.addAttribute("id",productModel.getManufactureid());
				String error="Your requirement is over the stock";
				model.addAttribute("error", error);
			    return new ModelAndView("createProduct");
			}
		}else if(productModel.getProductname().equalsIgnoreCase("tv"))
		{
			RawmaterialModel material1= new RawmaterialModel();
			material1.setManufactureid(productModel.getManufactureid());
			material1.setItemname("leddisplay");
			RawmaterialModel material1_availability = manufactureService.getRawmaterial(material1);
			RawmaterialModel material2= new RawmaterialModel();
			material2.setManufactureid(productModel.getManufactureid());
			material2.setItemname("tvchip");
			RawmaterialModel material2_availability = manufactureService.getRawmaterial(material2);
			if(material1_availability.getAvailability()>=productModel.getAvailability() && material2_availability.getAvailability()>=productModel.getAvailability())
			{
				int  available1=material1_availability.getAvailability()-productModel.getAvailability();
				int  available2=material2_availability.getAvailability()-productModel.getAvailability();
				material1_availability.setAvailability(available1);
				material2_availability.setAvailability(available2);
				manufactureService.updateRawmaterial(material1_availability);
				manufactureService.updateRawmaterial(material2_availability);
				manufactureService.createProduct(productModel);
				List<RawmaterialModel> rawmaterialModel1 = manufactureService.findRawMaterials(productModel.getManufactureid());
				
				model.addAttribute("rawmaterial",rawmaterialModel1);
				model.addAttribute("id", productModel.getManufactureid());
				return new ModelAndView("productionManagerDashboard");
			}
			else
			{
				model.addAttribute("comp",productModel.getManufactureid());
				String error="Your requirement is over the stock";
				model.addAttribute("error", error);
			    return new ModelAndView("createProduct");
			}
		}
		model.addAttribute("id",productModel.getManufactureid());
		
	    return new ModelAndView("createProduct");

	}

	// returns list of options to buy raw materials based on various supply chain conditions from all suppliers
	@RequestMapping(value = "orderprocess", method = RequestMethod.POST)
	public  ModelAndView orderProcess(@Valid @ModelAttribute ItemModel itemModel,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		
		String Manufactureid=itemModel.getSupplierid();
		System.out.println(Manufactureid+"rrtyu");
		List<Options> option = new ArrayList<>();
		for(ItemModel item : (ArrayList<ItemModel>) manufactureService.findItemsbyitemname(itemModel.getItemname()))
		{
			SupplierController sup=supplierService.findCompany(item.getSupplierid());
			int weight=0;
			int cost=0;
			if(sup.getWeather().equalsIgnoreCase("Cloudy"))
			{
				weight=weight+3;
				
			}
			if(sup.getWeather().equalsIgnoreCase("Sunny"))
			{
				weight=weight+1;
			}
			if(sup.getWeather().equalsIgnoreCase("Rainy"))
			{
				weight=weight+5;
			}
			if(sup.getPoliticalissues().equalsIgnoreCase("Yes"))
			{
				weight=weight+5;
			}
			if(sup.getLabourissues().equalsIgnoreCase("Yes"))
			{
				weight=weight+5;
			}
			if(sup.getDriverissues().equalsIgnoreCase("Yes"))
			{
				weight=weight+5;
			}
			if(weight>10) {
				cost=(item.getCost()/item.getAvailability())*(125/100);
			}
			if(item.getAvailability()<50)
			{
				cost=cost*(5/100);
			}
			Options op = new Options();
			op.setItemid(item.getItemid());
			op.setItemname(item.getItemname());
			op.setCost(cost);
			op.setSupplierid(item.getSupplierid());
			
			option.add(op);
			
		}
		model.addAttribute("option",option);
		model.addAttribute("id",Manufactureid);
	    return new ModelAndView("orderOptions");

	}

	// requests the selected option raw material item to the supplier and creates order on supplier microservice and manufacture microservices by setting its status and returns procurement manager dashboard
	@RequestMapping(value = "orderrequested", method = RequestMethod.POST)
	public  ModelAndView getManagerDashboard(@ModelAttribute("itemid1") String item1,@ModelAttribute("orderid") String orderid,@ModelAttribute("units") String units,@ModelAttribute("id") String comp,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		//model.addAttribute("comp",comp);
		ManufactureOrder order1= manufactureService.findOrder(Integer.parseInt(orderid));
		if (!(Objects.isNull(order1)))
		{
			model.addAttribute("id",id);
			//System.out.println(rawmaterialModel.getManufactureid()+"from dash");
			String error="Order ID Already exsit";
			model.addAttribute("error",error);
		    return new ModelAndView("placeOrderDashboard");
			
		}
		System.out.println(item1);
		
		ManufactureOrder manufactureOrder = new ManufactureOrder();
		Options option= new Options();
		String[] arr=item1.split(",");
		ItemModel item= supplierService.findItem(Integer.parseInt(arr[0]));
		option.setItemid(Integer.parseInt(arr[0]));
		option.setCost(Integer.parseInt(arr[1]));
		option.setItemname(item.getItemname());
		option.setOrderid(Integer.parseInt(orderid));
		option.setUnits(Integer.parseInt(units));
		option.setSupplierid(item.getSupplierid());
		option.setStatus("requested by "+comp);
		
		manufactureOrder.setItemid(Integer.parseInt(arr[0]));
		manufactureOrder.setCost(Integer.parseInt(arr[1]));
		manufactureOrder.setItemname(item.getItemname());
		manufactureOrder.setOrderid(Integer.parseInt(orderid));
		manufactureOrder.setUnits(Integer.parseInt(units));
		manufactureOrder.setSupplierid(item.getSupplierid());
		manufactureOrder.setStatus("requested to "+item.getSupplierid());
		manufactureOrder.setManufactureid(comp);
		// sends request to supplier
		boolean supplierOrderCreated = supplierService.createOrder(option);
		// creates requested order in manufacturer
		boolean manufactureOrderRequested= manufactureService.createOrder(manufactureOrder);
		List<RawmaterialModel> rawmaterialModel = manufactureService.findRawMaterials(comp);
		System.out.println("done printing");
		model.addAttribute("rawmaterialModel",rawmaterialModel);
		return new ModelAndView("procurementManagerDashboard");
	}

	// accepts the orders requested by the distributer based on the availability if available process the order else retuens orders page
	@RequestMapping(value = "orderacceptbymanufacture", method = RequestMethod.POST)
	public  ModelAndView acceptOrder(@Valid @ModelAttribute DistributerOrders distributerOrders ,@ModelAttribute("error") String error,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		DistributerOrders requestedOrder=manufactureService.getDistributerOrderbyorderid(distributerOrders.getOrderid());
		

		if(requestedOrder.getStatus().equalsIgnoreCase("Completed"))
		{
			System.out.println("in");
			model.addAttribute("id",requestedOrder.getManufactureid());
			String error="Order already processed";
			model.addAttribute("error", error);
			List<DistributerOrders> orders= manufactureService.findDistributerorderbymanufacture(requestedOrder.getManufactureid());
			model.addAttribute("distributerOrders",orders);
		    return new ModelAndView("distributerOrderstomanufacture");
		}
		ProductModel item=manufactureService.findProductid(requestedOrder.getProductid());
		//System.out.println(item.getAvailability());
		//System.out.println(op.getUnits());
		if(item.getAvailability()>=requestedOrder.getUnits())
		{	
			System.out.println("ini");
			int available=item.getAvailability()- requestedOrder.getUnits();
			int cost=item.getCost()/item.getAvailability();
			int newcost=cost*requestedOrder.getUnits();
			cost=(cost) * (available);
			
			ProductModel itemUpdate=new ProductModel();
			itemUpdate.setProductid(item.getProductid());
			itemUpdate.setAvailability(available);
			itemUpdate.setCost(cost);
			boolean resultUpdated=manufactureService.updateProduct(itemUpdate);
			String[] ar=requestedOrder.getStatus().split(" ");
			String productUPC= Integer.toString(item.getProductid())+ar[2];
			
			// checks if product already presnt if yes, then updates the quantity and cost else creates new product

			DistributerProduct newProduct = distributerService.findProductbyupc(productUPC);
			if(Objects.isNull(newProduct))
			{
				DistributerProduct product= new DistributerProduct();
				product.setProductid(requestedOrder.getProductid());
				product.setAvailability(requestedOrder.getUnits());
				product.setProductname(requestedOrder.getProductname());
				product.setProductupc(productUPC);
				product.setDistributerid(ar[2]);
				System.out.println("before");
				product.setCost(newcost);
				distributerService.createProduct(product);
				
				
			}
			else
			{
				newProduct.setAvailability(requestedOrder.getUnits()+newProduct.getAvailability());
				newProduct.setCost(newcost);
				
				distributerService.updateDistributerProduct(newProduct);
			}
			
			// updates status at manufacture
			DistributerOrders distributerOrder = new DistributerOrders();
			distributerOrder.setOrderid(distributerOrders.getOrderid());
			distributerOrder.setStatus("Completed");
			
			manufactureService.updateDistributerOrderStatus(distributerOrder);

			// updates status at distributer
			DistributerManufactureOrder manufactureOrder= new DistributerManufactureOrder();
			manufactureOrder.setOrderid(distributerOrders.getOrderid());
			manufactureOrder.setStatus("Completed");
			
			distributerService.updateManufactureorderstatus(manufactureOrder);

			ManufactureModel manufactureModel = manufactureService.getManufacture(item.getManufactureid());  
	
			model.addAttribute("manufactureModel",manufactureModel);
			
			return new ModelAndView("supplyManagerDashboard");
		}else
		{
			
			String error="check the quantity ordered is understocked";
			model.addAttribute("error", error);
			List<DistributerOrders> orders= manufactureService.findDistributerorderbymanufacture(op.getManufactureid());
			model.addAttribute("distributerOrders",orders);
		    return new ModelAndView("distributerOrderstomanufacture");
		}
	   

	}
	

}
