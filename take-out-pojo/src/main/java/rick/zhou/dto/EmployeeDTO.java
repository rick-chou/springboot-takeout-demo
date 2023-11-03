package rick.zhou.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * @author rick.zhou
 */
@Data
public class EmployeeDTO implements Serializable {

    private Long id;

    @NotBlank(message = "please input name")
    private String name;

    @NotBlank(message = "please input username")
    private String username;

    @NotBlank(message = "please input phone")
    private String phone;

    @NotBlank(message = "please input sex")
    private String sex;

    @NotBlank(message = "please input idNumber")
    private String idNumber;
}
