package spring.mapperInterface;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	List<Map<String, Object>> getList();

	int saveOne(Map<String, Object> params);

	int deleteOne(String id);

	int editOne(Map<String, Object> params);
}
