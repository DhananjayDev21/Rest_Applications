package in.customer_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomerClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerClientAppApplication.class, args);
	}

}
