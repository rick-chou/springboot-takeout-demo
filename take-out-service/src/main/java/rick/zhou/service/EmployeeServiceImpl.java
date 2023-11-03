package rick.zhou.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import rick.zhou.constant.MessageConstant;
import rick.zhou.constant.PasswordConstant;
import rick.zhou.constant.StatusConstant;
import rick.zhou.dto.EmployeeDTO;
import rick.zhou.entity.Employee;
import rick.zhou.exception.DuplicateEmployeeException;
import rick.zhou.mapper.EmployeeMapper;

/**
 * @author rick.zhou
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void save(EmployeeDTO employeeDTO) {

        if (employeeMapper.getByUsername(employeeDTO.getUsername()) == null) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO, employee);
            employee.setStatus(StatusConstant.ENABLE);
            employee.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));
            // TODO use the current user
            employee.setCreateUser(1L);
            employee.setUpdateUser(1L);
            employeeMapper.save(employee);
        } else {
            throw new DuplicateEmployeeException("username " + employeeDTO.getUsername() + " " + MessageConstant.ALREADY_EXIST);
        }
    }
}
