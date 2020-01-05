package com.amky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 
 * @author mkulkarn
 * How to run mvn spring-boot:run 
 */


@SpringBootApplication
public class EmployeeREST extends SpringBootServletInitializer  {
	public static void main(String[] args) {
        SpringApplication.run(EmployeeREST.class, args);
    }
}
