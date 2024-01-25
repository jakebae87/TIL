package spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<String> saveOne(@RequestBody Map<String, Object> params) {
		userService.saveOne(params);
		return ResponseEntity.ok("저장 성공");
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteOne(@RequestParam("id") String id) {
		int result = userService.deleteOne(id);

		if (result > 0) {
			return ResponseEntity.ok("삭제 성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 실패");
		}
	}
	
	@PutMapping("/edit")
	public ResponseEntity<String> editOne(@RequestBody Map<String, Object> params) {
		userService.editOne(params);
		System.out.println(params);
		return ResponseEntity.ok("수정 성공");
	}
}
