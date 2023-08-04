package in.serosoft.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/welcome")
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_PARENT')")
	public String welcomeAPI() {
		return "Welcome ADMIN User...!";
	}

	@PreAuthorize("hasRole('ROLE_STUDENT')")
	@GetMapping("/hello")
	public String helloAPI() {
		return "Hello Student User...!";
	}
	@GetMapping("/hi")
	@PreAuthorize("hasRole('ROLE_PARENT')")
	public String hiAPI() {
		return "Hello Parent User...!";
	}
}
