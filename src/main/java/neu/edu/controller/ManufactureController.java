package neu.edu.controller;

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
	/*
	@RequestMapping(value = "procurementManagerDashboard", method = RequestMethod.GET)
	public  ModelAndView getDashboard(@ModelAttribute("rawmaterialModel") String rawmaterialModel,Model model) {
		model.addAttribute("rawmaterialModel",rawmaterialModel);
		
	    return new ModelAndView("procurementManagerDashboard");

	}
	*/
	@RequestMapping(value = "placeOrderDashboard", method = RequestMethod.POST)
	public  ModelAndView placeOrderDashboard(@Valid @ModelAttribute RawmaterialModel rawmaterialModel,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) {
		
		model.addAttribute("comp",rawmaterialModel.getManufactureid());
		System.out.println(rawmaterialModel.getManufactureid()+"from dash");
		model.addAttribute("error",error);
	    return new ModelAndView("placeOrderDashboard");

	}
	@RequestMapping(value = "createproduct", method = RequestMethod.POST)
	public  ModelAndView createproduct(@Valid @ModelAttribute RawmaterialModel rawmaterialModel,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) {
		
		model.addAttribute("comp",rawmaterialModel.getManufactureid());
		
	    return new ModelAndView("createProduct");

	}
	@RequestMapping(value = "products", method = RequestMethod.POST)
	public  ModelAndView products(@Valid @ModelAttribute ProductModel productModel,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		//model.addAttribute("comp",rawmaterialModel.getManufactureid());
		List<ProductModel> pm=manufactureService.findProductsBymanufactureid(productModel.getManufactureid());
		model.addAttribute("product", pm);
		model.addAttribute("comp",productModel.getManufactureid());
	    return new ModelAndView("products");

	}
	@RequestMapping(value = "updatemanufacture", method = RequestMethod.POST)
	public  ModelAndView updatemanufacture(@Valid @ModelAttribute ManufactureModel manufactureModel,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		ManufactureModel manufacture=manufactureService.getManufacture(manufactureModel.getManufactureid());
		model.addAttribute("manufacture", manufacture);
		
	    return new ModelAndView("updateManufacture");

	}
	@RequestMapping(value = "updatemanufacturer", method = RequestMethod.POST)
	public  ModelAndView updatemanufacturer(@Valid @ModelAttribute ManufactureModel manufactureModel,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		manufactureService.updateManufacture(manufactureModel);
		ManufactureModel manufacture = manufactureService.getManufacture(manufactureModel.getManufactureid());  
		System.out.println("done printing");
		model.addAttribute("manufactureModel",manufacture);
		//model.addAttribute("comp", emp.getCompanyid());
		return new ModelAndView("supplyManagerDashboard");
	 

	}
	@RequestMapping(value = "getbackproductionmanagerDashboard", method = RequestMethod.POST)
	public  ModelAndView getBackManagerDashboard(@ModelAttribute("comp") String comp,Model model) throws URISyntaxException, IOException, InterruptedException {
		List<RawmaterialModel> rawmaterialModel1 = manufactureService.findRawMaterials(comp);
		
		model.addAttribute("rawmaterial",rawmaterialModel1);
		//model.addAttribute("comp", comp);
		
		return new ModelAndView("productionManagerDashboard");

	}
	@RequestMapping(value = "getbacksupplydashboard", method = RequestMethod.POST)
	public  ModelAndView getbacksupplydashboard(@Valid @ModelAttribute ProductModel productModel,Model model) throws URISyntaxException, IOException, InterruptedException {
		ManufactureModel manufactureModel = manufactureService.getManufacture(productModel.getManufactureid());  
		System.out.println("done printing");
		model.addAttribute("manufactureModel",manufactureModel);
		//model.addAttribute("comp", emp.getCompanyid());
		return new ModelAndView("supplyManagerDashboard");
	}
	@RequestMapping(value = "distributerorderstomanufacture", method = RequestMethod.POST)
	public  ModelAndView distributerorderstomanufacture(@Valid @ModelAttribute DistributerOrders distributerOrders,Model model) throws URISyntaxException, IOException, InterruptedException {
		List<DistributerOrders> ddis=manufactureService.findDistributerorderbymanufacture(distributerOrders.getManufactureid());
		System.out.println("done printing");
		model.addAttribute("distributerOrders",ddis);
		model.addAttribute("comp", distributerOrders.getManufactureid());
		return new ModelAndView("distributerOrderstomanufacture");
	}
	
	@RequestMapping(value = "registerproduct", method = RequestMethod.POST)
	public  ModelAndView registerproduct(@Valid @ModelAttribute ProductModel productModel,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		ProductModel pm=manufactureService.findProductid(productModel.getProductid());
		if(!(Objects.isNull(pm)))
		{
			model.addAttribute("comp",productModel.getManufactureid());
			String er="Product ID already exsit";
			model.addAttribute("error",er);
		    return new ModelAndView("createProduct");
		}
		if(productModel.getProductname().equalsIgnoreCase("laptop"))
		{
			RawmaterialModel rm= new RawmaterialModel();
			rm.setManufactureid(productModel.getManufactureid());
			rm.setItemname("motherboard");
			RawmaterialModel ans = manufactureService.getRawmaterial(rm);
			RawmaterialModel rm1= new RawmaterialModel();
			rm1.setManufactureid(productModel.getManufactureid());
			rm1.setItemname("ram");
			RawmaterialModel ans1 = manufactureService.getRawmaterial(rm1);
			System.out.println(ans1);
			System.out.println(ans);
			if(Objects.isNull(ans) ||Objects.isNull(ans1))
			{
				model.addAttribute("comp",productModel.getManufactureid());
				String er="Raw materials not available";
				model.addAttribute("error", er);
			    return new ModelAndView("createProduct");
			}
			System.out.println(ans.getAvailability());
			System.out.println(ans1.getAvailability());
			if(ans.getAvailability()>=productModel.getAvailability() && ans1.getAvailability()>=productModel.getAvailability())
			{
				int  available1=ans.getAvailability()-productModel.getAvailability();
				int  available2=ans1.getAvailability()-productModel.getAvailability();
				ans.setAvailability(available1);
				ans1.setAvailability(available2);
				manufactureService.updateRawmaterial(ans);
				manufactureService.updateRawmaterial(ans1);
				manufactureService.createProduct(productModel);
				List<RawmaterialModel> rawmaterialModel1 = manufactureService.findRawMaterials(productModel.getManufactureid());
				
				model.addAttribute("rawmaterial",rawmaterialModel1);
				model.addAttribute("comp", productModel.getManufactureid());
				return new ModelAndView("productionManagerDashboard");
			}
			else
			{
				model.addAttribute("comp",productModel.getManufactureid());
				String er="Your requirement is over the stock";
				model.addAttribute("error", er);
			    return new ModelAndView("createProduct");
			}
		}else if(productModel.getProductname().equalsIgnoreCase("refregirator"))
		{
			RawmaterialModel rm= new RawmaterialModel();
			rm.setManufactureid(productModel.getManufactureid());
			rm.setItemname("coolent");
			RawmaterialModel ans = manufactureService.getRawmaterial(rm);
			RawmaterialModel rm1= new RawmaterialModel();
			rm1.setManufactureid(productModel.getManufactureid());
			rm1.setItemname("compressor");
			RawmaterialModel ans1 = manufactureService.getRawmaterial(rm);
			if(ans.getAvailability()>=productModel.getAvailability() && ans1.getAvailability()>=productModel.getAvailability())
			{
				int  available1=ans.getAvailability()-productModel.getAvailability();
				int  available2=ans1.getAvailability()-productModel.getAvailability();
				ans.setAvailability(available1);
				ans1.setAvailability(available2);
				manufactureService.updateRawmaterial(ans);
				manufactureService.updateRawmaterial(ans1);
				manufactureService.createProduct(productModel);
				List<RawmaterialModel> rawmaterialModel1 = manufactureService.findRawMaterials(productModel.getManufactureid());
				
				model.addAttribute("rawmaterial",rawmaterialModel1);
				model.addAttribute("comp", productModel.getManufactureid());
				return new ModelAndView("productionManagerDashboard");
			}
			else
			{
				model.addAttribute("comp",productModel.getManufactureid());
				String er="Your requirement is over the stock";
				model.addAttribute("error", er);
			    return new ModelAndView("createProduct");
			}
		}else if(productModel.getProductname().equalsIgnoreCase("tv"))
		{
			RawmaterialModel rm= new RawmaterialModel();
			rm.setManufactureid(productModel.getManufactureid());
			rm.setItemname("leddisplay");
			RawmaterialModel ans = manufactureService.getRawmaterial(rm);
			RawmaterialModel rm1= new RawmaterialModel();
			rm1.setManufactureid(productModel.getManufactureid());
			rm1.setItemname("tvchip");
			RawmaterialModel ans1 = manufactureService.getRawmaterial(rm);
			if(ans.getAvailability()>=productModel.getAvailability() && ans1.getAvailability()>=productModel.getAvailability())
			{
				int  available1=ans.getAvailability()-productModel.getAvailability();
				int  available2=ans1.getAvailability()-productModel.getAvailability();
				ans.setAvailability(available1);
				ans1.setAvailability(available2);
				manufactureService.updateRawmaterial(ans);
				manufactureService.updateRawmaterial(ans1);
				manufactureService.createProduct(productModel);
				List<RawmaterialModel> rawmaterialModel1 = manufactureService.findRawMaterials(productModel.getManufactureid());
				
				model.addAttribute("rawmaterial",rawmaterialModel1);
				model.addAttribute("comp", productModel.getManufactureid());
				return new ModelAndView("productionManagerDashboard");
			}
			else
			{
				model.addAttribute("comp",productModel.getManufactureid());
				String er="Your requirement is over the stock";
				model.addAttribute("error", er);
			    return new ModelAndView("createProduct");
			}
		}
		model.addAttribute("comp",productModel.getManufactureid());
		
	    return new ModelAndView("createProduct");

	}
	@RequestMapping(value = "orderprocess", method = RequestMethod.POST)
	public  ModelAndView orderprocess(@Valid @ModelAttribute ItemModel itemModel,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		//model.addAttribute("comp",rawmaterialModel.getManufactureid());
		//List<ItemModel> itemModel1=manufactureService.findItemsbyitemname(itemModel.getItemname());
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
		model.addAttribute("comp",Manufactureid);
	    return new ModelAndView("orderOptions");

	}
	@RequestMapping(value = "orderrequested", method = RequestMethod.POST)
	public  ModelAndView getManagerDashboard(@ModelAttribute("itemid1") String item1,@ModelAttribute("orderid") String orderid,@ModelAttribute("units") String units,@ModelAttribute("comp") String comp,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		//model.addAttribute("comp",comp);
		ManufactureOrder order1= manufactureService.findOrder(Integer.parseInt(orderid));
		if (!(Objects.isNull(order1)))
		{
			model.addAttribute("comp",comp);
			//System.out.println(rawmaterialModel.getManufactureid()+"from dash");
			String error="Order ID Already exsit";
			model.addAttribute("error",error);
		    return new ModelAndView("placeOrderDashboard");
			
		}
		System.out.println(item1);
		System.out.println(comp);
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
		manufactureOrder.setStatus("requested by "+item.getSupplierid());
		manufactureOrder.setManufactureid(comp);
		boolean ans = supplierService.createOrder(option);
		boolean ans1= manufactureService.createOrder(manufactureOrder);
		List<RawmaterialModel> rawmaterialModel = manufactureService.findRawMaterials(comp);
		System.out.println("done printing");
		model.addAttribute("rawmaterialModel",rawmaterialModel);
		return new ModelAndView("procurementManagerDashboard");
	}
	@RequestMapping(value = "orderacceptbymanufacture", method = RequestMethod.POST)
	public  ModelAndView acceptOrder(@Valid @ModelAttribute DistributerOrders distributerOrders ,@ModelAttribute("error") String error,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		DistributerOrders op=manufactureService.getDistributerOrderbyorderid(distributerOrders.getOrderid());
		System.out.println(distributerOrders.getOrderid());
		System.out.println(op.getProductid());
		System.out.println(op.getStatus());
		if(op.getStatus().equalsIgnoreCase("Completed"))
		{
			System.out.println("in");
			model.addAttribute("comp",op.getManufactureid());
			String er2="Order already processed";
			model.addAttribute("error", er2);
			List<DistributerOrders> op2= manufactureService.findDistributerorderbymanufacture(op.getManufactureid());
			model.addAttribute("distributerOrders",op2);
		    return new ModelAndView("distributerOrderstomanufacture");
		}
		ProductModel item=manufactureService.findProductid(op.getProductid());
		//System.out.println(item.getAvailability());
		//System.out.println(op.getUnits());
		if(item.getAvailability()>=op.getUnits())
		{	
			System.out.println("ini");
			int available=item.getAvailability()- op.getUnits();
			int cost=item.getCost()/item.getAvailability();
			int newcost=cost*op.getUnits();
			cost=(cost) * (available);
			
			ProductModel itemup=new ProductModel();
			itemup.setProductid(item.getProductid());
			itemup.setAvailability(available);
			itemup.setCost(cost);
			boolean ans=manufactureService.updateProduct(itemup);
			String[] ar=op.getStatus().split(" ");
			String rawid= Integer.toString(item.getProductid())+ar[2];
			////------------------
			//RawmaterialModel rw= manufactureService.findRawMaterialbyrawid(rawid);
			DistributerProduct rw = distributerService.findProductbyupc(rawid);
			if(Objects.isNull(rw))
			{
				DistributerProduct raw= new DistributerProduct();
				raw.setProductid(op.getProductid());
				raw.setAvailability(op.getUnits());
				raw.setProductname(op.getProductname());
				raw.setProductupc(rawid);
				System.out.println(ar[2]);
				raw.setDistributerid(ar[2]);
				System.out.println("before");
				//manufactureService.createRawmaterial(raw);
				raw.setCost(newcost);
				distributerService.createProduct(raw);
				System.out.println("after");
				
			}
			else
			{
				rw.setAvailability(op.getUnits()+rw.getAvailability());
				rw.setCost(newcost);
				//manufactureService.updateRawmaterial(rw);
				distributerService.updateDistributerProduct(rw);
			}
			//Options op1= new Options();
			DistributerOrders op1 = new DistributerOrders();
			op1.setOrderid(distributerOrders.getOrderid());
			op1.setStatus("Completed");
			//supplierService.updateOrderStatus(op1);//manufactureside
			manufactureService.updateDistributerOrderStatus(op1);
			DistributerManufactureOrder mo= new DistributerManufactureOrder();
			mo.setOrderid(distributerOrders.getOrderid());
			mo.setStatus("Completed");
			//manufactureService.updateOrderStatus(mo);
			distributerService.updateManufactureorderstatus(mo);
			ManufactureModel manufactureModel = manufactureService.getManufacture(item.getManufactureid());  
			System.out.println("done printing");
			model.addAttribute("manufactureModel",manufactureModel);
			//model.addAttribute("comp", emp.getCompanyid());
			return new ModelAndView("supplyManagerDashboard");
		}else
		{
			String er="check the quantity ordered is understocked";
			model.addAttribute("error", er);
			List<DistributerOrders> op2= manufactureService.findDistributerorderbymanufacture(op.getManufactureid());
			model.addAttribute("distributerOrders",op2);
		    return new ModelAndView("distributerOrderstomanufacture");
		}
	   

	}
	/*
	@RequestMapping(value = "distributerorderstomanufacture", method = RequestMethod.POST)
	public  ModelAndView distributerOrder(@Valid @ModelAttribute ProductModel productModel ,@ModelAttribute("error") String error,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		model.addAttribute("comp",productModel.getManufactureid());
		model.addAttribute("error", error);
		//List<Options> op= supplierService.findOrders(itemModel.getSupplierid());
		List<DistributerOrders>op=manufactureService.findDistributerorderbymanufacture(productModel.getManufactureid());
		model.addAttribute("order",op);
	    return new ModelAndView("distributerOrderstomanufacture");

	}
	*/

}
