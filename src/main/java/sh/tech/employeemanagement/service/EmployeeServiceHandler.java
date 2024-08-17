package sh.tech.employeemanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sh.tech.employeemanagement.dao.entity.Employee;
import sh.tech.employeemanagement.dao.repository.EmployeeRepository;
import sh.tech.employeemanagement.exception.NotFoundException;
import sh.tech.employeemanagement.mapper.EmployeeMapper;
import sh.tech.employeemanagement.model.criteria.PageCriteria;
import sh.tech.employeemanagement.model.dto.EmployeeRequestDto;
import sh.tech.employeemanagement.model.dto.EmployeeResponseDto;

import java.util.List;

import static sh.tech.employeemanagement.model.enums.ExceptionConstants.EMPLOYEE_NOT_FOUND_EXCEPTION;

@Service
@RequiredArgsConstructor
public class EmployeeServiceHandler implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponseDto> getAllEmployees(PageCriteria pageCriteria) {
        int limit = pageCriteria.getCount();
        int offset = pageCriteria.getPage() * limit;
        return employeeRepository.getAllEmployees(limit, offset)
                .stream().map(employeeMapper::toDto).toList();
    }

    @Override
    public EmployeeResponseDto getEmployee(Long id) {
        Employee employee = employeeRepository.getEmployeeById(id).orElseThrow(() ->
                new NotFoundException(EMPLOYEE_NOT_FOUND_EXCEPTION.getCode(),
                        EMPLOYEE_NOT_FOUND_EXCEPTION.getMessage()));
        return employeeMapper.toDto(employee);
    }

    @Override
    public void saveUpdateEmployee(EmployeeRequestDto requestDto) {
        Employee employee = employeeMapper.toEntity(requestDto);
        if (requestDto.getId() != 0)
            employeeRepository.updateEmployee(employee);
        else
            employeeRepository.createEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<EmployeeResponseDto> getEmployeesByBranch(PageCriteria pageCriteria, String department) {
        int limit = pageCriteria.getCount();
        int offset = pageCriteria.getPage() * limit;
        return employeeRepository.getEmployeesByBranch(department, limit, offset).stream().map(employeeMapper::toDto).toList();
    }
}
