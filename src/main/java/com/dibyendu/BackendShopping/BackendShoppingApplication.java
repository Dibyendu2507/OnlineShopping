package com.dibyendu.BackendShopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/*
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
*/
//entityManagerFactoryRef = "com.dibyendu.BackendShopping"
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@EnableJpaRepositories(basePackages = {"com.dibyendu.BackendShopping.Product", "com.dibyendu.BackendShopping.Entity"})
@SpringBootApplication
@EntityScan("com.dibyendu.BackendShopping.Entity")
public class BackendShoppingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BackendShoppingApplication.class, args);
	}

}
