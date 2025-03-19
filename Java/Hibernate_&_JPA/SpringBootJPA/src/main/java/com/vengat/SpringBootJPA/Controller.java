package com.vengat.SpringBootJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	ConfigController cc;
	
//	@RequestMapping("/")
	@GetMapping("/")
	public String welcome() {
		return "Hello msg from vengat..";
	}

	@GetMapping("/data")
	public ConfigController datas() {
		return cc;
	}

}
 