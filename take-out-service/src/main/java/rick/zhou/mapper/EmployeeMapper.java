package rick.zhou.mapper;

import org.apache.ibatis.annotations.Mapper;
import rick.zhou.entity.Employee;

/**
 * @author rick.zhou
 */
@Mapper
public interface EmployeeMapper {
    public void save(Employee employee);

    public Employee getByUsername(String username);
}
