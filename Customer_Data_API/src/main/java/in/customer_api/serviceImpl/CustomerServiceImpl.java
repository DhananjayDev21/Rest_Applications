package in.customer_api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.customer_api.entity.CustomerEntity;
import in.customer_api.repository.CustomerRepository;
import in.customer_api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public CustomerEntity createCutomerData(CustomerEntity entity) {
		
		CustomerEntity save = repository.save(entity);
				
		return save;
	}

	@Override
	public CustomerEntity getCutomerData(Integer id) {
		
		Optional<CustomerEntity> findById = repository.findById(id);
		
		if(findById.isPresent()) {
			
			CustomerEntity customerId = findById.get();
			
			return customerId;
		}
		
		return null;
	}

//	@Override
//	public CustomerEntity updateById(CustomerEntity entity) {
//		
//		repository.save(entity);
//		
//		return null;
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<CustomerEntity> getAllUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
