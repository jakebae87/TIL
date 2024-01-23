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
}
