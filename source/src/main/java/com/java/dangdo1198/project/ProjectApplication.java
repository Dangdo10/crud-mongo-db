package com.java.dangdo1198.project;

import com.java.dangdo1198.project.dao.DeviceDAO;
import com.java.dangdo1198.project.model.Device;
import com.java.dangdo1198.project.service.DeviceService;
import com.java.dangdo1198.project.service.DeviceServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectApplication.class, args);

	}

}
