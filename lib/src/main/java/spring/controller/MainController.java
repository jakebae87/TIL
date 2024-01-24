package spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

		return result;
	}

	@PostMapping("/save")
	public void saveOne(@RequestBody Map<String, Object> params) {
		System.out.println("클라이언트 request body: " + params);
		userService.saveOne(params);
	}

	@DeleteMapping("/delete")
	public void deleteOne(@RequestParam("id") String id) {
		int result = userService.deleteOne(id);
		System.out.println(result);
	}

}
