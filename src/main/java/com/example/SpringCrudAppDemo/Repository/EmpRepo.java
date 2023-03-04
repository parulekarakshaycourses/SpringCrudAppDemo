package com.example.SpringCrudAppDemo.Repository;

import com.example.SpringCrudAppDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmpRepo extends JpaRepository<Employee, Long> {
}
