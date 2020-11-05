package hu.dw9yg6.springbootweb;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {

	@GetMapping(value="/hello", produces = MediaType.TEXT_PLAIN_VALUE)
	public String index() {

	    return "Hello Spring Boot Web World";
	}
	
	@RequestMapping(path="/{name}")
	public String DW9YG6Hello(@PathVariable("") String name) {
	        
	        String hello = "Hello, " + name;
	        
	        return hello;
	    }
}
