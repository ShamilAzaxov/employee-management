package sh.tech.employeemanagement.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequestDto {
    Long id;
    @NotNull(message = "fill username field")
    @NotBlank(message = "fill username field")
    String username;
    @NotNull(message = "fill password field")
    @NotBlank(message = "fill password field")
    String password;
    @NotNull(message = "fill fullName field")
    @NotBlank(message = "fill fullName field")
    String fullName;
    @NotNull(message = "fill branch field")
    @NotBlank(message = "fill branch field")
    String branch;
    @NotNull(message = "fill address field")
    @NotBlank(message = "fill address field")
    String address;
    @NotNull(message = "fill email field")
    @NotBlank(message = "fill email field")
    String email;
    @NotNull(message = "fill mobile field")
    @NotBlank(message = "fill mobile field")
    String mobile;
}
