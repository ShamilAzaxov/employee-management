package sh.tech.employeemanagement.dao.repository;

import org.apache.ibatis.annotations.*;
import sh.tech.employeemanagement.dao.entity.Employee;
import sh.tech.employeemanagement.model.dto.EmployeeRequestDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeRepository {

    @Select("select * from employees order by id limit #{limit} offset #{offset}")
    @Result(property = "fullName", column = "full_name")
     List<Employee> getAllEmployees(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select * from employees where id = #{id};")
    @Result(property = "fullName", column = "full_name")
    Optional<Employee> getEmployeeById(Long id);

    @Insert("insert into employees(username, password, full_name, branch, address, email, mobile) values (#{username}, #{password}, #{fullName}, #{branch}, #{address}, #{email}, #{mobile})")
    void createEmployee(Employee employee);

    @Update("update employees set username = #{employee.username}, password = #{employee.password}, full_name = #{employee.fullName}, branch = #{employee.branch}, address = #{employee.address}, email = #{employee.email}, mobile = #{employee.mobile} where id = #{employee.id}")
    void updateEmployee(@Param("employee") Employee employee);

    @Delete("delete from employees where id = #{id}")
    void deleteEmployee(Long id);

    @Select("select * from employees where branch like concat(#{branch}, '%') limit #{limit} offset #{offset}")
    List<Employee> getEmployeesByBranch(String branch, int limit, int offset);
}
