package in.customer_api.service;

import in.customer_api.entity.CustomerEntity;

public interface CustomerService {
	
	public CustomerEntity createCutomerData(CustomerEntity entity);
	
	public CustomerEntity getCutomerData(Integer id);
	
//	public CustomerEntity updateById(CustomerEntity entity);
//	
//	public void deleteById(Integer id);
//
//	public List <CustomerEntity> getAllUsers();
}
