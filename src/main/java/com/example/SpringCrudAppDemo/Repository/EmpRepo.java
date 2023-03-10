package com.example.SpringCrudAppDemo.Repository;
import com.example.SpringCrudAppDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmpRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findBySalary(double salary);

    List<Employee> findByDesignation(String desig);

    List<Employee> findByNameAndDesignation(String name, String des);

    @Query("from Employee where salary > :salary")
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findBySalaryLessThan(double salary);

    List<Employee> findByNameAndSalaryGreaterThan(String name, double salary);

}
