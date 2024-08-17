package sh.tech.employeemanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sh.tech.employeemanagement.dao.entity.Employee;
import sh.tech.employeemanagement.model.dto.EmployeeRequestDto;
import sh.tech.employeemanagement.model.dto.EmployeeResponseDto;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    Employee toEntity(EmployeeRequestDto requestDto);

    EmployeeResponseDto toDto(Employee employee);
}
