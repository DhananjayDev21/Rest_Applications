package in.customer_client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.customer_client.feign.CustomerFeignClient;
import in.customer_client.request.CustomerRequestData;
import in.customer_client.response.CustomerResponseData;

@Controller
public class ClientController {

	@Autowired
	private CustomerFeignClient feignClient;

	@GetMapping("/")
	public String loadPage(@RequestParam(name = "success", required = false) boolean success, Model model) {

		 if (success) {
		        model.addAttribute("successMessage", "Data saved successfully.");
		    }
		 
		
		model.addAttribute("Data", new CustomerRequestData());
		return "ClientUI";
	}

	@GetMapping("/customer/{id}")
	public CustomerRequestData getCustomeData(@PathVariable("id") Integer id) {

		return feignClient.getCustomeData(id);

	}

	@PostMapping("/customer/save")
	public String createUser( CustomerRequestData requestData, Model model) {

		feignClient.createUser(requestData);
		
		model.addAttribute("successMessage", "Send Sucessfully!!");
		
		return "redirect:/?success=true";
	}

	@GetMapping("/all")
	public String getAll( Model model) {

		List<CustomerResponseData> allCustomers = feignClient.getAllCustomers();
		
		model.addAttribute("allCustomers", allCustomers);
		
		return "View_Customer";
	}
	
	
	
	  @GetMapping("/customer/delete/{id}")
	    public String deleteUser(@PathVariable("id") Integer id ,Model model) {
	        
		  feignClient.deleteUser(id);
		  
         return "redirect:/all";
	    }
	  
	  @GetMapping("/customer/edit/{id}")
		public String update(@PathVariable("id") Integer id , Model model) {

			CustomerRequestData customeData = feignClient.getCustomeData(id); 
			
			model.addAttribute("Data" ,customeData);
			
			return "ClientUI";
		}
}
