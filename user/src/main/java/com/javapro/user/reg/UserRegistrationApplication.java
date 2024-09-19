package com.javapro.user.reg;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@ComponentScan( basePackages = { "com.javapro.user.reg.*"} )
//@EnableJpaRepositories("com.javapro.user.reg.repository")
//@EntityScan( basePackages = {"com.javapro.user.reg.entity.*"} )
public class UserRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
