package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private GirlProperties girlProperties;
	
	@GetMapping("/say")
	public String say(@RequestParam(value="id",required=false,defaultValue="0") Integer myId){
		return "id: "+myId;
//		return girlProperties.getCupSize();
	}
}
