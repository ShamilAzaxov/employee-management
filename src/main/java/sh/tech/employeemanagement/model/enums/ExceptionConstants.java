package sh.tech.employeemanagement.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionConstants {
    EMPLOYEE_NOT_FOUND_EXCEPTION("NOT_FOUND", "Employee Not Found"),
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occurred");

    private final String code;
    private final String message;
}
