package com.vitvar.restdemo;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitvar.restdemo.model.Weather;
import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;

@SpringBootApplication
@DependsOn("dataset")
public class RestDemoApplication {

	public static void main(String[] args) {
            SpringApplication.run(RestDemoApplication.class, args);
	}

}
