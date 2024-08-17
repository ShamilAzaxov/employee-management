package sh.tech.employeemanagement.service;

import sh.tech.employeemanagement.model.criteria.PageCriteria;
import sh.tech.employeemanagement.model.dto.EmployeeRequestDto;
import sh.tech.employeemanagement.model.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> getAllEmployees(PageCriteria criteria);
    EmployeeResponseDto getEmployee(Long id);
    void saveUpdateEmployee(EmployeeRequestDto employeeRequestDto);
    void deleteEmployee(Long id);
    List<EmployeeResponseDto> getEmployeesByBranch(PageCriteria pageCriteria, String department);
}
