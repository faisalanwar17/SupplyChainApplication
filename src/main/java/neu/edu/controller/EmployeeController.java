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
import neu.edu.controller.model.Distributer;
import neu.edu.controller.model.EmployeeModel;
import neu.edu.controller.model.ItemModel;
import neu.edu.controller.model.ManufactureModel;
import neu.edu.controller.model.RawmaterialModel;
import neu.edu.controller.model.SupplierController;
import neu.edu.entity.Customers;
import neu.edu.entity.Employee;
import neu.edu.service.CustomerService;
import neu.edu.service.DistributerService;
import neu.edu.service.EmployeeService;
import neu.edu.service.ManufactureService;
import neu.edu.service.SupplierService;
@RestController
@Controller
@SessionAttributes("employee")
public class EmployeeController {
	private RestTemplate restTemplate;
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private ManufactureService manufactureService;
	@Autowired
	private DistributerService distributerService;
	
	@RequestMapping(value = "employeeRegisterForSupplier", method = RequestMethod.GET)
	public  ModelAndView getEmployeeRegsiterPageSupplier(@ModelAttribute("error") String error,Model model) {
		model.addAttribute("error",error);
	    return new ModelAndView("employeeRegisterForSupplier");

	}
	@RequestMapping(value = "employeeRegisterForManufacturer", method = RequestMethod.GET)
	public  ModelAndView getEmployeeRegsiterPageManufacturer(@ModelAttribute("error") String error,Model model) {
		model.addAttribute("error",error);
	    return new ModelAndView("employeeRegisterForManufacturer");

	}
	@RequestMapping(value = "employeeRegisterForDistributer", method = RequestMethod.GET)
	public  ModelAndView getEmployeeRegsiterDistributer(@ModelAttribute("error") String error,Model model) {
		model.addAttribute("error",error);
	    return new ModelAndView("employeeRegisterForDistributer");

	}
	@RequestMapping(value = "loginpage", method = RequestMethod.GET)
	public  ModelAndView getEmployeeLogin(@ModelAttribute("error") String error,Model model) {
		model.addAttribute("error",error);
	    return new ModelAndView("employeeLogin");

	}
	@RequestMapping(value = "plantManagerDashboard", method = RequestMethod.GET)
	public  ModelAndView getDashboard(@ModelAttribute("supplier") String supplier,Model model) {
		model.addAttribute("supplier",supplier);
		
	    return new ModelAndView("plantManagerDashboard");

	}
	@RequestMapping(value = "managerDashboard", method = RequestMethod.GET)
	public  ModelAndView getManagerDashboard(@ModelAttribute("itemModel") String itemModel,@ModelAttribute("comp") String comp,Model model) {
		model.addAttribute("itemModel",itemModel);
		model.addAttribute("comp",comp);
		
	    return new ModelAndView("managerDashboard");

	}
	@RequestMapping(value = "getbackmanagerDashboard", method = RequestMethod.POST)
	public  ModelAndView getBackManagerDashboard(@ModelAttribute("itemModel") String itemModel,@ModelAttribute("comp") String comp,Model model) throws URISyntaxException, IOException, InterruptedException {
		List<ItemModel> itemModel1 = supplierService.findItems(comp);
		System.out.println("done printing");
		model.addAttribute("itemModel",itemModel1);
		model.addAttribute("comp", comp);
		return new ModelAndView("managerDashboard");

	}
	@RequestMapping(value = "registeritem", method = RequestMethod.POST)
	public  ModelAndView registeritem(@Valid @ModelAttribute ItemModel itemModel ,@ModelAttribute("error") String error,BindingResult bindingResult, Model model) {
		model.addAttribute("comp",itemModel.getSupplierid());
		model.addAttribute("error", error);
	    return new ModelAndView("itemRegister");

	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView getLogoutPage(HttpSession session) {
		session.invalidate();
		return new ModelAndView("employeeLogin");

	}
	@RequestMapping(value="saveemployeesupplier", method = RequestMethod.POST)
	public ModelAndView createEmployeeSupplier(@Valid @ModelAttribute EmployeeModel employeeModel ,BindingResult bindingResult, Model model) {
		String error="";
		System.out.println(error);
		Employee emp=employeeService.findEmployee(employeeModel.getUsername());
		boolean usererror=false;
		//System.out.println(cus.getUsername());
		if (!(Objects.isNull(emp)))
		{
			usererror=true;
		}
		if (bindingResult.hasErrors()) {

			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				error += fieldError.getField() + " : " + fieldError.getDefaultMessage() + "<br/>";

			}
		
			 if(usererror){
					 error +="Username Already Exist";
					
				}
			System.out.println("Has errors");
			model.addAttribute("error", error);
			//redirectAttributes.addAttribute("customer", customer.toString());

			return new ModelAndView("employeeRegisterForSupplier");
		}
		else if(usererror){
			 error +="Username Already Exist";
			 model.addAttribute("error", error);
			 return new ModelAndView("employeeRegisterForSupplier");
				
		}
		else
		{
			System.out.println(error);
			employeeService.saveUser(employeeModel);
			return new ModelAndView("success","employeeModel",false);
			}
	}
	@RequestMapping(value="saveemployeemanufacturer", method = RequestMethod.POST)
	public ModelAndView createEmployeeManufacturer(@Valid @ModelAttribute EmployeeModel employeeModel ,BindingResult bindingResult, Model model) {
		String error="";
		System.out.println(error);
		Employee emp=employeeService.findEmployee(employeeModel.getUsername());
		boolean usererror=false;
		//System.out.println(cus.getUsername());
		if (!(Objects.isNull(emp)))
		{
			usererror=true;
		}
		if (bindingResult.hasErrors()) {

			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				error += fieldError.getField() + " : " + fieldError.getDefaultMessage() + "<br/>";

			}
		
			 if(usererror){
					 error +="Username Already Exist";
					
				}
			System.out.println("Has errors");
			model.addAttribute("error", error);
			//redirectAttributes.addAttribute("customer", customer.toString());

			return new ModelAndView("employeeRegisterForManufacturer");
		}
		else if(usererror){
			 error +="Username Already Exist";
			 model.addAttribute("error", error);
			 return new ModelAndView("employeeRegisterForManufacturer");
				
		}
		else
		{
			System.out.println(error);
			employeeService.saveUser(employeeModel);
			return new ModelAndView("success","employeeModel",false);
			}
	}
	@RequestMapping(value="saveemployeedistributer", method = RequestMethod.POST)
	public ModelAndView createEmployeeDistributer(@Valid @ModelAttribute EmployeeModel employeeModel ,BindingResult bindingResult, Model model) {
		String error="";
		System.out.println(error);
	
		Employee emp=employeeService.findEmployee(employeeModel.getUsername());
		boolean usererror=false;
		//System.out.println(cus.getUsername());
		if (!(Objects.isNull(emp)))
		{
			usererror=true;
		}
		if (bindingResult.hasErrors()) {

			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				error += fieldError.getField() + " : " + fieldError.getDefaultMessage() + "<br/>";

			}
		
			 if(usererror){
					 error +="Username Already Exist";
					
				}
			System.out.println("Has errors");
			model.addAttribute("error", error);
			//redirectAttributes.addAttribute("customer", customer.toString());

			return new ModelAndView("employeeRegisterForDistributer");
		}
		else if(usererror){
			 error +="Username Already Exist";
			 model.addAttribute("error", error);
			 return new ModelAndView("employeeRegisterForDistributer");
				
		}
		else
		{
			System.out.println(error);
			employeeService.saveUser(employeeModel);
			return new ModelAndView("success","userModel",false);
			}
	}
	@RequestMapping(value="login", method = RequestMethod.POST)
	public ModelAndView loginEmployee(@Valid @ModelAttribute EmployeeModel employeeModel ,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		String error="";
		System.out.println(error);
		Employee emp=employeeService.findEmployee(employeeModel.getUsername());
		
		boolean usererror=false;
		//System.out.println(emp.getCompanyid());
		//System.out.println(cus.getUsername());
		if ((Objects.isNull(emp)))
		{
			usererror=true;
		}
		if(usererror){
			 error +="Username doesnot Exist";
			 model.addAttribute("error", error);
			 return new ModelAndView("employeeLogin");
				
		}
		if(emp.getUsername().equalsIgnoreCase("admins") && emp.getPassword().matches("Abcd@1234"))
		{
			return new ModelAndView("employeeRegisterForSupplier");
		}
		if(emp.getUsername().equalsIgnoreCase("adminm") && emp.getPassword().matches("Abcd@1234"))
		{
			return new ModelAndView("employeeRegisterForManufacturer");
		}
		if(emp.getUsername().equalsIgnoreCase("admind") && emp.getPassword().matches("Abcd@1234"))
		{
			return new ModelAndView("employeeRegisterForDistributer");
		}
		if(!(employeeModel.getPassword().matches(emp.getPassword())) || !(employeeModel.getRole().matches(emp.getRole())))
		{
			 error +="Check credentials";
			 model.addAttribute("error", error);
			 return new ModelAndView("employeeLogin");
		}
		else if(emp.getCompanyid().equalsIgnoreCase("Supplier_A") || emp.getCompanyid().equalsIgnoreCase("Supplier_B") || emp.getCompanyid().equalsIgnoreCase("Supplier_C")  ) {
			System.out.println("here");
			/*
			ResponseEntity<SupplierController> responseEntity = restTemplate.getForEntity("http://localhost:8086/Supplier/supplier/item" + emp.getCompanyid(),SupplierController.class);
			SupplierController supplierController = responseEntity.getBody();
			System.out.println("done");
			return new ModelAndView("success","userModel",false); 
			
			try {
				HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Supplier/supplier/item/")).POST(BodyPublishers.ofString(emp.getCompanyid())).build();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			if(emp.getRole().equalsIgnoreCase("PlantManager"))
			{
				List<SupplierController> supplier = employeeService.findCompany();
				System.out.println("done printing");
				model.addAttribute("supplier",supplier);
				return new ModelAndView("plantManagerDashboard");
			}
			else if(emp.getRole().equalsIgnoreCase("Manager"))
			{
				List<ItemModel> itemModel = supplierService.findItems(emp.getCompanyid());
				System.out.println("done printing");
				model.addAttribute("itemModel",itemModel);
				model.addAttribute("comp", emp.getCompanyid());
				return new ModelAndView("managerDashboard");
			}
			
		}
		else if(emp.getCompanyid().equalsIgnoreCase("Manufacturer_A") || emp.getCompanyid().equalsIgnoreCase("Manufacturer_B") || emp.getCompanyid().equalsIgnoreCase("Manufacturer_C")  ) {
			System.out.println("here");
			/*
			ResponseEntity<SupplierController> responseEntity = restTemplate.getForEntity("http://localhost:8086/Supplier/supplier/item" + emp.getCompanyid(),SupplierController.class);
			SupplierController supplierController = responseEntity.getBody();
			System.out.println("done");
			return new ModelAndView("success","userModel",false); 
			
			try {
				HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Supplier/supplier/item/")).POST(BodyPublishers.ofString(emp.getCompanyid())).build();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			if(emp.getRole().equalsIgnoreCase("ProcurementManager"))
			{
				List<RawmaterialModel> rawmaterialModel = manufactureService.findRawMaterials(emp.getCompanyid());
				System.out.println("done printing");
				model.addAttribute("rawmaterialModel",rawmaterialModel);
				model.addAttribute("comp", emp.getCompanyid());
				return new ModelAndView("procurementManagerDashboard");
			}
			else if(emp.getRole().equalsIgnoreCase("ProductionManager"))
			{
				List<RawmaterialModel> rawmaterialModel1 = manufactureService.findRawMaterials(emp.getCompanyid());
				System.out.println("done printing");
				model.addAttribute("rawmaterial",rawmaterialModel1);
				model.addAttribute("comp", emp.getCompanyid());
				return new ModelAndView("productionManagerDashboard");
			}
			else if(emp.getRole().equalsIgnoreCase("SupplyManager"))
			{
				ManufactureModel manufactureModel = manufactureService.getManufacture(emp.getCompanyid());  
				System.out.println("done printing");
				model.addAttribute("manufactureModel",manufactureModel);
				//model.addAttribute("comp", emp.getCompanyid());
				return new ModelAndView("supplyManagerDashboard");
			}
			
		}else if(emp.getCompanyid().equalsIgnoreCase("Distributer_A") || emp.getCompanyid().equalsIgnoreCase("Distributer_B") || emp.getCompanyid().equalsIgnoreCase("Distributer_C")  ) {
			System.out.println("here");
			/*
			ResponseEntity<SupplierController> responseEntity = restTemplate.getForEntity("http://localhost:8086/Supplier/supplier/item" + emp.getCompanyid(),SupplierController.class);
			SupplierController supplierController = responseEntity.getBody();
			System.out.println("done");
			return new ModelAndView("success","userModel",false); 
			
			try {
				HttpRequest postRequest =  HttpRequest.newBuilder().uri(new URI("http://localhost:8086/Supplier/supplier/item/")).POST(BodyPublishers.ofString(emp.getCompanyid())).build();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			if(emp.getRole().equalsIgnoreCase("DistributerManager"))
			{
				Distributer distributer = distributerService.getDistributer(emp.getCompanyid());
				System.out.println("done printing");
				model.addAttribute("distributer",distributer);
				model.addAttribute("comp", emp.getCompanyid());
				return new ModelAndView("distributerManagerDashboard");
			}
			
		}
		
		else
			
		{
			return new ModelAndView("success","userModel",false);
		}
	
		return new ModelAndView("success","userModel",false);


}
	
}
