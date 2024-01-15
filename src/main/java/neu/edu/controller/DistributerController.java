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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import neu.edu.controller.model.Distributer;
import neu.edu.controller.model.DistributerManufactureOrder;
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
public class DistributerController {

	public DistributerController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private ManufactureService manufactureService;
	@Autowired
	private  SupplierService supplierService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DistributerService distributerService;
	@RequestMapping(value = "updatedistributerer", method = RequestMethod.POST)
	public  ModelAndView updatedistributerer(@Valid @ModelAttribute Distributer distributer,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		distributerService.updateDistributer(distributer);
		Distributer distributer1 = distributerService.getDistributer(distributer.getDistributerid());  
		System.out.println("done printing");
		model.addAttribute("distributer",distributer1);
		//model.addAttribute("comp", emp.getCompanyid());
		return new ModelAndView("distributerManagerDashboard");
	 

	}
	@RequestMapping(value = "placeOrderDistributerDashboard", method = RequestMethod.POST)
	public  ModelAndView placeOrderDistributerDashboard(@Valid @ModelAttribute Distributer distributer,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) {
		
		model.addAttribute("comp",distributer.getDistributerid());
		//System.out.println(rawmaterialModel.getManufactureid()+"from dash");
		model.addAttribute("error",error);
	    return new ModelAndView("placeOrderDistributerDashboard");

	}
	@RequestMapping(value = "getbackdistributermanagerdashboard", method = RequestMethod.POST)
	public  ModelAndView getbackdistributermanagerdashboard(@Valid @ModelAttribute Distributer distributer,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		Distributer distributer1 = distributerService.getDistributer(distributer.getDistributerid());  
		System.out.println("done printing");
		model.addAttribute("distributer",distributer1);
		//model.addAttribute("comp", emp.getCompanyid());
		return new ModelAndView("distributerManagerDashboard");
	 

	}
	@RequestMapping(value = "distributerproducts", method = RequestMethod.POST)
	public  ModelAndView getproducts(@Valid @ModelAttribute DistributerProduct distributerProduct,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		//model.addAttribute("comp",rawmaterialModel.getManufactureid());
		List<DistributerProduct> pm=distributerService.getproductsBydistributerid(distributerProduct.getDistributerid());
		model.addAttribute("product", pm);
		model.addAttribute("comp",distributerProduct.getDistributerid());
	    return new ModelAndView("distributerProducts");

	}
	@RequestMapping(value = "updatedistributer", method = RequestMethod.POST)
	public  ModelAndView updatedistributer(@Valid @ModelAttribute Distributer distributer,@ModelAttribute("comp") String comp,@ModelAttribute("error") String error,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		Distributer distributer1 = distributerService.getDistributer(distributer.getDistributerid());
		model.addAttribute("distributer", distributer1);
		
	    return new ModelAndView("updatedistributer");

	}
	@RequestMapping(value = "distributerorderprocess", method = RequestMethod.POST)
	public  ModelAndView orderprocess(@Valid @ModelAttribute ProductModel productModel,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		//model.addAttribute("comp",rawmaterialModel.getManufactureid());
		//List<ItemModel> itemModel1=manufactureService.findItemsbyitemname(itemModel.getItemname());
		String Distributerid=productModel.getManufactureid();
		System.out.println(Distributerid+"rrtyu");
		List<Options> option = new ArrayList<>();
		for(ProductModel item : (ArrayList<ProductModel>) manufactureService.findProductsbyproductname(productModel.getProductname()))
		{
			ManufactureModel sup=manufactureService.getManufacture(item.getManufactureid());
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
			op.setItemid(item.getProductid());
			op.setItemname(item.getProductname());
			op.setCost(cost);
			op.setSupplierid(item.getManufactureid());
			
			option.add(op);
			
		}
		model.addAttribute("option",option);
		model.addAttribute("comp",Distributerid);
	    return new ModelAndView("distributerorderOptions");

	}
	@RequestMapping(value = "orderrequestedbydistributer", method = RequestMethod.POST)
	public  ModelAndView getManagerDashboard(@ModelAttribute("itemid1") String item1,@ModelAttribute("orderid") String orderid,@ModelAttribute("units") String units,@ModelAttribute("comp") String comp,Model model) throws URISyntaxException, IOException, InterruptedException {
		
		//model.addAttribute("comp",comp);
		DistributerManufactureOrder order1= distributerService.findOrder(Integer.parseInt(orderid));
		if (!(Objects.isNull(order1)))
		{
			model.addAttribute("comp",comp);
			//System.out.println(rawmaterialModel.getManufactureid()+"from dash");
			String error="Order ID Already exsit";
			model.addAttribute("error",error);
		    return new ModelAndView("placeOrderDistributerDashboard");
			
		}
		System.out.println(item1);
		System.out.println(comp);
		DistributerManufactureOrder manufactureOrder = new DistributerManufactureOrder();
		Options option= new Options();
		String[] arr=item1.split(",");
		ProductModel item= manufactureService.findProductid(Integer.parseInt(arr[0]));
		option.setItemid(Integer.parseInt(arr[0]));
		option.setCost(Integer.parseInt(arr[1]));
		option.setItemname(item.getProductname());
		option.setOrderid(Integer.parseInt(orderid));
		option.setUnits(Integer.parseInt(units));
		option.setSupplierid(item.getManufactureid());
		option.setStatus("requested by "+comp);
		
		manufactureOrder.setProductid(Integer.parseInt(arr[0]));
		manufactureOrder.setCost(Integer.parseInt(arr[1]));
		manufactureOrder.setProductname(item.getProductname());
		manufactureOrder.setOrderid(Integer.parseInt(orderid));
		manufactureOrder.setUnits(Integer.parseInt(units));
		manufactureOrder.setManufactureid(item.getManufactureid());
		manufactureOrder.setStatus("requested by "+item.getManufactureid());
		manufactureOrder.setDistributerid(comp);
		boolean ans = manufactureService.createDistributerOrder(option);
		boolean ans1= distributerService.createOrder(manufactureOrder);
		Distributer distributer1 = distributerService.getDistributer(comp);  
		System.out.println("done printing");
		model.addAttribute("distributer",distributer1);
		//model.addAttribute("comp", emp.getCompanyid());
		return new ModelAndView("distributerManagerDashboard");
	}

}
