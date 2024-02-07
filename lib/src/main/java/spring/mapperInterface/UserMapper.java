package spring.mapperInterface;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	List<Map<String, Object>> getList(String searchValue);

	int save(List<Map<String, Object>> inserts);

	int delete(List<Integer> ids);

	int edit(List<Map<String, Object>> updates);
}
