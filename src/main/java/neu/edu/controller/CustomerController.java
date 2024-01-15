package neu.edu.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.FieldError;

import neu.edu.controller.model.BestOptions;
import neu.edu.controller.model.Customer;
import neu.edu.controller.model.Distributer;
import neu.edu.controller.model.DistributerProduct;
import neu.edu.controller.model.EmployeeModel;
import neu.edu.controller.model.ManufactureModel;
import neu.edu.controller.model.ProductModel;
import neu.edu.entity.Customers;
import neu.edu.entity.Employee;
import neu.edu.service.CustomerService;
import neu.edu.service.DistributerService;
import neu.edu.service.ManufactureService;

@Controller
public class CustomerController {

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private CustomerService customerService;
	@Autowired
	private DistributerService distributerService;
	@Autowired
	private ManufactureService manufactureService;
	@RequestMapping(value = "register", method = RequestMethod.GET)

	public  ModelAndView getRegsiterPage(@ModelAttribute("error") String error,Model model) {
		model.addAttribute("error",error);
	    return new ModelAndView("register");

	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView createCustomers(@Valid  @ModelAttribute Customer customer ,BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
		
	
		String error="";
		System.out.println(error);
		Customers cus=customerService.findCustomer(customer.getUsername());
		boolean usererror=false;
		//System.out.println(cus.getUsername());
		if (!(Objects.isNull(cus)))
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

			return new ModelAndView("register");
		}
		else if(usererror){
			 error +="Username Already Exist";
			 redirectAttributes.addAttribute("error", error);
			 return new ModelAndView("redirect:register");
				
		}
		else
		{
			System.out.println(error);
			customerService.saveUser(customer);
			 return new ModelAndView("customerLogin");
			}
		
	}
	@RequestMapping(value = "customerLogin", method = RequestMethod.GET)
	public  ModelAndView getEmployeeLogin(@ModelAttribute("error") String error,Model model) {
		model.addAttribute("error",error);
	    return new ModelAndView("customerLogin");

	}
	@RequestMapping(value="customerlogin", method = RequestMethod.POST)
	public ModelAndView loginEmployee(@Valid @ModelAttribute Customers customers ,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		String error="";
		System.out.println(error);
		Customers emp=customerService.findCustomer(customers.getUsername());
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
			 return new ModelAndView("customerLogin");
				
		}
		if(!(customers.getPassword().matches(emp.getPassword())))
		{
			 error +="Check credentials";
			 model.addAttribute("error", error);
			 return new ModelAndView("customerLogin");
		}
		else
		{
			List<Distributer>ds= distributerService.getDistributers("abc");
			model.addAttribute("distributer", ds);
			return new ModelAndView("customerHomepage");
		}
	}
	@RequestMapping(value="productlist", method = RequestMethod.POST)
	public ModelAndView producylist(@Valid @ModelAttribute Distributer distributer ,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		
		model.addAttribute("comp", distributer.getDistributerid());
		return new ModelAndView("productList");
		
	}
	@RequestMapping(value = "logoutcustomer", method = RequestMethod.GET)
	public ModelAndView getLogoutPage(HttpSession session) {
		session.invalidate();
		return new ModelAndView("customerLogin");

	}
	@RequestMapping(value="bestoptionsprocess", method = RequestMethod.POST)
	public ModelAndView bestoptionsprocess(@Valid @ModelAttribute DistributerProduct distributerProduct ,BindingResult bindingResult, Model model) throws URISyntaxException, IOException, InterruptedException {
		
		//model.addAttribute("comp", distributer.getDistributerid());
		System.out.print(distributerProduct.getProductname());
		DistributerProduct p=distributerService.checkProduct(distributerProduct);
		ArrayList<BestOptions> List = new ArrayList<BestOptions>();
		if(Objects.isNull(p))
		{
			String[] ar={"Manufacturer_A", "Manufacturer_B", "Manufacturer_C"};
			
			for(int i=0;i<ar.length;i++)
			{
			ProductModel pm= new ProductModel();
			pm.setProductname(distributerProduct.getProductname());
			pm.setManufactureid(ar[i]);
			ProductModel pm1=manufactureService.checkProduct(pm);
			BestOptions bp= new BestOptions();
			if(!(Objects.isNull(pm1)))
			{
				int cost=pm1.getCost();
				String time="";
				ManufactureModel mm= manufactureService.getManufacture(pm1.getManufactureid());
				int weights=0;
				if(mm.getDriverissues().equalsIgnoreCase("Yes"))
				{
					weights=weights+5;
				}
				if(mm.getLabourissues().equalsIgnoreCase("Yes"))
				{
					weights=weights+5;
				}
				if(mm.getDriverissues().equalsIgnoreCase("Yes"))
				{
					weights=weights+5;
				}
				if(mm.getWeather().equalsIgnoreCase("Cloudy"))
				{
					weights=weights+5;
				}
				if(mm.getWeather().equalsIgnoreCase("Rainy"))
				{
					weights=weights+5;
				}
				if(weights>10)
				{
					time="More than week";
					int cost1=(int) (cost*0.25);
					cost=cost+cost1;
				}
				else
				{
					time="Less than week";
					int cost1=(int) (cost*0.10);
					cost=cost+cost1;
				}
				
				bp.setCost(cost);
				bp.setDistributerid(pm1.getManufactureid());
				bp.setOrderid(pm1.getManufactureid()+weights);
				bp.setProductname(pm1.getProductname());
				bp.setTime(time);
				
			}
			List.add(bp);
				
		}
			model.addAttribute("list", List);
			return new ModelAndView("bestOptions");
		}
	else
		{
			
		BestOptions bp1= new BestOptions();
		int cost =(int) (p.getCost()*0.10);
		bp1.setCost(p.getCost()+cost);
		bp1.setDistributerid(p.getDistributerid());
		bp1.setProductname(p.getProductname());
		bp1.setOrderid(p.getProductupc());
		String t="Less than A week";
		bp1.setTime(t);
		List.add(bp1);
		model.addAttribute("list", List);
		return new ModelAndView("bestOptions");
		}
		
		
	
		
	}
}
