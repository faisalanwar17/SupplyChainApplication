package neu.edu.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Constants;

import neu.edu.controller.model.Customer;
import neu.edu.controller.model.EmployeeModel;
import neu.edu.controller.model.ItemModel;
import neu.edu.controller.model.ManufactureOrder;
import neu.edu.controller.model.Options;
import neu.edu.controller.model.RawmaterialModel;
import neu.edu.controller.model.SupplierController;
import neu.edu.entity.Customers;
import neu.edu.entity.Employee;
import neu.edu.service.CustomerService;
import neu.edu.service.EmployeeService;
import neu.edu.service.ManufactureService;
import neu.edu.service.SupplierService;
@RestController
@Controller
@SessionAttributes("employee")
public class SuppplierController {
	@Autowired
	private  SupplierService supplierService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ManufactureService manufactureService;
	public SuppplierController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value = "updateDashboard", method = RequestMethod.POST)
	public  ModelAndView updateDashboard(@ModelAttribute SupplierController supplierController ,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		System.out.println("hi"+supplierController.getSupplierid());
		SupplierController supplier = supplierService.findCompany(supplierController.getSupplierid());
		model.addAttribute("supplier",supplier);

	    return new ModelAndView("updateSupplier");

	}
	@RequestMapping(value = "updateItemDashboard", method = RequestMethod.POST)
	public  ModelAndView updateItemDashboard(@ModelAttribute ItemModel itemModel ,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		//System.out.println("hi"+supplierController.getSupplierid());
		ItemModel item = supplierService.findItem(itemModel.getItemid());
		model.addAttribute("item",item);

	    return new ModelAndView("updateItem");

	}
	@RequestMapping(value="updatesupplierr", method = RequestMethod.POST)
	public ModelAndView updateSupplier(@Valid @ModelAttribute SupplierController supplierController ,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException
	{
		boolean ans =supplierService.updateSupplier(supplierController);
		System.out.println(ans);
		List<SupplierController> supplier = employeeService.findCompany();
		model.addAttribute("supplier",supplier);
		return new ModelAndView("plantManagerDashboard");
	}
	@RequestMapping(value="updateitem", method = RequestMethod.POST)
	public ModelAndView updateItem(@Valid @ModelAttribute ItemModel itemModel ,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException
	{
		boolean ans =supplierService.updateItem(itemModel);
		System.out.println(ans);
		List<ItemModel> itemModel1 = supplierService.findItems(itemModel.getSupplierid());
		System.out.println("done printing");
		model.addAttribute("itemModel",itemModel1);
		model.addAttribute("comp", itemModel.getSupplierid());
		return new ModelAndView("managerDashboard");
	}
	@RequestMapping(value="createitem", method = RequestMethod.POST)
	public ModelAndView createItem(@Valid @ModelAttribute ItemModel itemModel ,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		ItemModel item =supplierService.findItem(itemModel.getItemid());
		if(!(Objects.isNull(item)))
		{
			model.addAttribute("comp",itemModel.getSupplierid());
			String error ="Item ID already exist";
			 model.addAttribute("error", error);
		    return new ModelAndView("itemRegister");
		}
		System.out.println(itemModel.getSupplierid()+"before");
		if(supplierService.checkItem(itemModel))
		{
			model.addAttribute("comp",itemModel.getSupplierid());
			String error ="Item Already exist in this company";
			 model.addAttribute("error", error);
		    return new ModelAndView("itemRegister");
		}
		System.out.println(itemModel.getSupplierid()+"After");
		boolean ans= supplierService.createItem(itemModel);
		System.out.println(ans);
		List<ItemModel> itemModel1 = supplierService.findItems(itemModel.getSupplierid());
		System.out.println("done printing");
		model.addAttribute("itemModel",itemModel1);
		model.addAttribute("comp", itemModel.getSupplierid());
		return new ModelAndView("managerDashboard");
		//return supplierService.createItem(itemModel);
		
	}
	@RequestMapping(value = "supplierorders", method = RequestMethod.POST)
	public  ModelAndView supplierOrder(@Valid @ModelAttribute ItemModel itemModel ,@ModelAttribute("error") String error,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		model.addAttribute("comp",itemModel.getSupplierid());
		model.addAttribute("error", error);
		List<Options> op= supplierService.findOrders(itemModel.getSupplierid());
		model.addAttribute("order",op);
	    return new ModelAndView("supplierOrders");

	}
	@RequestMapping(value = "orderacceptbysupplier", method = RequestMethod.POST)
	public  ModelAndView acceptOrder(@Valid @ModelAttribute Options options ,@ModelAttribute("error") String error,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		Options op=supplierService.getOrderbyorderid(options.getOrderid());
		System.out.println(op.getStatus());
		if(op.getStatus().equalsIgnoreCase("Completed"))
		{
			System.out.println("in");
			model.addAttribute("comp",op.getSupplierid());
			String er2="Order already processed";
			model.addAttribute("error", er2);
			List<Options> op2= supplierService.findOrders(op.getSupplierid());
			model.addAttribute("order",op2);
		    return new ModelAndView("supplierOrders");
		}
		ItemModel item=supplierService.findItem(op.getItemid());
		System.out.println(item.getAvailability());
		System.out.println(op.getUnits());
		if(item.getAvailability()>=op.getUnits())
		{	
			System.out.println("ini");
			int available=item.getAvailability()- op.getUnits();
			int cost=item.getCost()/item.getAvailability();
			cost=(cost) * (available);
			ItemModel itemup=new ItemModel();
			itemup.setItemid(item.getItemid());
			itemup.setAvailability(available);
			itemup.setCost(cost);
			boolean ans=supplierService.updateItem(itemup);
			String[] ar=op.getStatus().split(" ");
			String rawid= Integer.toString(item.getItemid())+ar[2];
			RawmaterialModel rw= manufactureService.findRawMaterialbyrawid(rawid);
			if(Objects.isNull(rw))
			{
				RawmaterialModel raw= new RawmaterialModel();
				raw.setItemid(op.getItemid());
				raw.setAvailability(op.getUnits());
				raw.setItemname(op.getItemname());
				raw.setMaterialid(rawid);
				System.out.println(ar[2]);
				raw.setManufactureid(ar[2]);
				System.out.println("before");
				manufactureService.createRawmaterial(raw);
				System.out.println("after");
				
			}
			else
			{
				rw.setAvailability(op.getUnits()+rw.getAvailability());
				manufactureService.updateRawmaterial(rw);
			}
			Options op1= new Options();
			op1.setOrderid(options.getOrderid());
			op1.setStatus("Completed");
			supplierService.updateOrderStatus(op1);
			ManufactureOrder mo= new ManufactureOrder();
			mo.setOrderid(options.getOrderid());
			mo.setStatus("Completed");
			manufactureService.updateOrderStatus(mo);
			List<ItemModel> itemModel = supplierService.findItems(item.getSupplierid());
			System.out.println("done printing");
			model.addAttribute("itemModel",itemModel);
			model.addAttribute("comp", item.getSupplierid());
			return new ModelAndView("managerDashboard");
		}else
		{
			String er="check the quantity ordered is understocked";
			model.addAttribute("error", er);
			List<Options> ops= supplierService.findOrders(item.getSupplierid());
			model.addAttribute("order",ops);
		    return new ModelAndView("supplierOrders");
		}
	   

	}
}
