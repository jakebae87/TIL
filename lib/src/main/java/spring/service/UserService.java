package spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mapperInterface.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	public List<Map<String, Object>> getList(String searchValue) {
		return userMapper.getList(searchValue);
	}

	public int save(List<Map<String, Object>> inserts) {
		return userMapper.save(inserts);
	}

	public int delete(List<Map<String, Object>> data) {
		return userMapper.delete(data);
	}

	public int edit(List<Map<String, Object>> updates) {
		return userMapper.edit(updates);
	}

	public int branchOut(List<Map<String, Object>> requestData) {

		int saveResult = 0, updateResult = 0;

		List<Map<String, Object>> newData = new ArrayList<>();
		List<Map<String, Object>> updateData = new ArrayList<>();

		for (Map<String, Object> data : requestData) {
			Object isNew = data.get("isNew"); // 새로운 행일 경우에 Object true를 isNew에 담는다.
			Object editMode = data.get("editMode"); // 수정 기능이 활성화된 객체(Object true)를 editMode에 담는다.

			if (isNew != null && (boolean) isNew) { // 새로운 행일 경우
				newData.add(data);
			}
			if (editMode != null && (boolean) editMode) { // 기존 데이터를 수정할 경우
				updateData.add(data);
			} else if (isNew == null && editMode == null) { // 새로운 행도 아니고 수정할 내용이 없는데 체크박스 선택된 경우
				System.out.println("저장할 내용이 없습니다.");
			}
		}

		if (newData.size() > 0) {
			saveResult = userMapper.save(newData);
		} else if (updateData.size() > 0) {
			updateResult = userMapper.edit(updateData);
		}

		return saveResult + updateResult;

	}
}
