package in.customer_client.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.customer_client.request.CustomerRequestData;
import in.customer_client.response.CustomerResponseData;

@FeignClient(name = "CustomerDataApi", url = "http://localhost:9090")
public interface CustomerFeignClient {

	@GetMapping("/customer/{id}")
	CustomerRequestData getCustomeData(@PathVariable("id") Integer id);

	@PostMapping("/customer/save")
	CustomerRequestData createUser(@RequestBody CustomerRequestData requestData);
	
	@GetMapping("/all")
	List<CustomerResponseData> getAllCustomers();
	
	@PutMapping("/customer/edit/{id}")
	CustomerRequestData updateUser( @PathVariable("id") Integer id, @RequestBody CustomerRequestData requestData);
	
	@DeleteMapping("/customer/delete/{id}")
    Void deleteUser(@PathVariable("id") Integer id);
}
