package sh.tech.employeemanagement.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sh.tech.employeemanagement.model.criteria.PageCriteria;
import sh.tech.employeemanagement.model.dto.EmployeeRequestDto;
import sh.tech.employeemanagement.model.dto.EmployeeResponseDto;
import sh.tech.employeemanagement.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
@Validated
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees(PageCriteria pageCriteria) {
        return ResponseEntity.ok(employeeService.getAllEmployees(pageCriteria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable("id")
                                                               @NotNull(message = "fill id parameter")
                                                               @Valid Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody @Valid EmployeeRequestDto employeeRequestDto) {
        employeeService.saveUpdateEmployee(employeeRequestDto);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") @NotNull(message = "fill id parameter") @Valid Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/branch")
    public ResponseEntity<List<EmployeeResponseDto>> getEmployeesByDepartment(PageCriteria pageCriteria,
                                                                              @RequestParam String department) {
        return ResponseEntity.ok(employeeService.getEmployeesByBranch(pageCriteria, department));
    }
}
