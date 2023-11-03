package rick.zhou.controller.admin;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rick.zhou.dto.EmployeeDTO;
import rick.zhou.service.EmployeeService;


/**
 * @author rick.zhou
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void save(@Valid EmployeeDTO employeeDTO) {
        log.info("ADD EMPLOYEE {}", employeeDTO);
        employeeService.save(employeeDTO);
    }
}
