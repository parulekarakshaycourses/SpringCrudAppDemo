package com.example.SpringCrudAppDemo.Controller;

import com.example.SpringCrudAppDemo.Entity.Employee;
import com.example.SpringCrudAppDemo.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController
{
    @Autowired
    EmpRepo empRepo;

    @GetMapping("/")
    public String homePage()
    {
        return "index";
    }

    @GetMapping("/emp/reg/")
    public String empReg(Model model)
    {
        List<Employee> listEmp = empRepo.findAll();
        model.addAttribute("listEmp", listEmp);
        return "empReg";
    }

    @GetMapping("/emp/delete/{empID}/")
    public String empDelete(Model model, @PathVariable Long empID)
    {




        empRepo.deleteById(empID);
        List<Employee> listEmp = empRepo.findAll();
        model.addAttribute("listEmp", listEmp);
        return "empReg";
    }

    @PostMapping("/emp/save/")
    public String addEmp(Model model, Employee emp)
    {
        empRepo.save(emp);
        List<Employee> listEmp = empRepo.findAll();
        model.addAttribute("listEmp", listEmp);
        return "empReg";
    }

}