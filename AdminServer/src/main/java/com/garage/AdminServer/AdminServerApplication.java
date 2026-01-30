package com.garage.AdminServer;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class AdminServerApplication {

	//Admin Server
	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication.class, args);
	}

}
