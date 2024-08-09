package com.DemoCompare.webservices.rest.DemoCompare_restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


// REST API
@RestController
public class HelloWorldController {
	
	// /hello_world
	// "Hello World"
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	// Json return
	// java Bean..
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Fuck  mom");
	}
	
	// Path Parameters
	// /hello-world/path-variable/{name}
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name ) {
		return new HelloWorldBean(String.format("Hello %s", name));
	}
}
