package com.example.SpringCrudAppDemo.Controller;

import com.example.SpringCrudAppDemo.Entity.Employee;
import com.example.SpringCrudAppDemo.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmpController
{
    @Autowired
    EmpRepo empRepo;

    @GetMapping("/")
    public String home()
    {
        return "index";
    }

    @GetMapping("/emp/reg/")
    public String empReg(Model model)
    {
        List<Employee> list = empRepo.findAll();
        model.addAttribute("empList", list);

        return "empReg";
    }

//    @PostMapping("/emps/")
//    public String addEmp(Model model, Employee emp)
//    {
//        empRepo.save(emp);
//        model.addAttribute("msg", "Employee Registration Successfull");
//        return "empReg";
//    }

    @PostMapping("/emps/")
    public String addEmp(Model model, String name, String designation, double salary)
    {
        Employee emp = new Employee(name, designation, salary);
        empRepo.save(emp);

        List<Employee> list = empRepo.findAll();
        model.addAttribute("empList", list);
        model.addAttribute("msg", "Employee Registration Successfull");
        return "empReg";
    }

    @GetMapping("/emps/delete/{empID}/")
    public String empReg(Model model, @PathVariable long empID)
    {
        empRepo.deleteById(empID);

        List<Employee> list = empRepo.findAll();
        model.addAttribute("empList", list);
        model.addAttribute("msg", "Employee Deleted Successfull");

        return "empReg";
    }

}
