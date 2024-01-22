package spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MainController {

	@GetMapping("/list")
	public List<Map<String, Object>> getList(@RequestParam Map<String, Object> params) {
		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> number = new HashMap<>();

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			number.put(key, value);
		}

		if ("3".equals(number.get("number").toString())) {
			Map<String, Object> number1 = new HashMap<String, Object>() {
				private static final long serialVersionUID = 1L;
				{
					put("name", "황비홍");
					put("age", "11");
					put("height", "175");
				}
			};
			result.add(number1);

			Map<String, Object> number2 = new HashMap<String, Object>() {
				private static final long serialVersionUID = 1L;
				{
					put("name", "나루토");
					put("age", "19");
					put("height", "171");
				}
			};
			result.add(number2);
		}

		return result;
	}

	@GetMapping("/detail")
	public Map<String, Object> getDetail(@RequestParam Map<String, Object> params) {
		Map<String, Object> result = new HashMap<>();

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			result.put(key, value);
		}

		return result;
	}
}
