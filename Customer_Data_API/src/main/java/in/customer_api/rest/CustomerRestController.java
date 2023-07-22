package in.customer_api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.customer_api.entity.CustomerEntity;
import in.customer_api.repository.CustomerRepository;
import in.customer_api.service.CustomerService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerRestController  {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository repository;

	@GetMapping("/customer/{id}")
	public ResponseEntity<CustomerEntity> getCustomeData(@PathVariable("id") Integer id) {
		
		CustomerEntity cutomerData = customerService.getCutomerData(id);
			
		return new ResponseEntity<CustomerEntity>(cutomerData, HttpStatus.OK);
		
	}
	
	@PostMapping("/customer/save")
	public ResponseEntity<CustomerEntity > createCutomerData(@RequestBody CustomerEntity entity) {
		
		CustomerEntity createCutomerData = customerService.createCutomerData(entity);
	
//		return new ResponseEntity<> (createCutomerData,HttpStatus.CREATED);
		
        return ResponseEntity.status(HttpStatus.CREATED).body(createCutomerData);

		}
	
//	@PutMapping("/customer/edit/{id}")
//    public ResponseEntity<CustomerEntity> updateUser(@PathVariable("id") Integer id, @RequestBody CustomerEntity customerEntity) {
//		CustomerEntity existingUser = repository.findById(id).orElse(null);
//        if (existingUser != null) {
//            existingUser.setName(customerEntity.getName());
//            existingUser.setEmail(customerEntity.getEmail());
//            CustomerEntity updatedUser = repository.save(existingUser);
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
	
	@PutMapping("/customer/edit/{id}")
	public ResponseEntity<CustomerEntity> getCustomer(@PathVariable("id") Integer id,@RequestBody CustomerEntity entity) {
	    CustomerEntity customer= repository.findById(id).orElse(null);
	    if (customer != null) {
	    	customer.setName(entity.getName());
	    	customer.setEmail(entity.getEmail());
	    	CustomerEntity save = repository.save(customer);
	        return new ResponseEntity<>(save, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}


    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAllUsers() {
        List<CustomerEntity > users = repository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	
}
