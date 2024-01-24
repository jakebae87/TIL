package spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import spring.service.UserService;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class MainController {

	UserService userService;

	@GetMapping("/list")
	public List<Map<String, Object>> getList() {
		List<Map<String, Object>> result = new ArrayList<>();
		
		result = userService.getList();
		
		System.out.println(result);
		
		return result;
	}
	
	@PostMapping("/save")
	public void saveNewData(@RequestParam Map<String, Object> params) {
		userService.saveNewData(params);
	}

}
