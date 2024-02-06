package spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mapperInterface.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	public List<Map<String, Object>> getList() {
		return userMapper.getList();
	}

	public int save(List<Map<String, Object>> inserts) {
		return userMapper.save(inserts);
	}

	public int delete(List<Integer> ids) {
		return userMapper.delete(ids);
	}

	public int edit(List<Map<String, Object>> updates) {
		return userMapper.edit(updates);
	}

	public void branchOut(List<Map<String, Object>> requestData) {

		for (Map<String, Object> data : requestData) {
		    Object isNewValue = data.get("isNew");
		    Object editModeValue = data.get("editMode");

		    if (isNewValue != null && (boolean) isNewValue) {
		        System.out.println(data.get("user_nm") + " hello");
		    } else if (isNewValue == null && editModeValue == null) {
		        System.out.println("수정할게 없다.");
		    }
		}

	}
}
