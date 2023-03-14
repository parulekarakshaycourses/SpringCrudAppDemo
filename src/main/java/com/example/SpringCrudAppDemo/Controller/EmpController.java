package com.example.SpringCrudAppDemo.Controller;

import com.example.SpringCrudAppDemo.Entity.Employee;
import com.example.SpringCrudAppDemo.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    int maxSize = 5;

    @GetMapping("/emp/reg/{curPage}/")
    public String empReg(Model model, @PathVariable int curPage)
    {
        Pageable pageable = PageRequest.of(curPage-1, maxSize, Sort.by("id").descending());
        Page<Employee> page = empRepo.findAll(pageable);
        int totalPages = page.getTotalPages();
        List<Employee> listEmp = page.toList();

        model.addAttribute("listEmp", listEmp);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("curPage", curPage);
        return "empReg";
    }

    @GetMapping("/emp/delete/{empID}/")
    public String empDelete(Model model, @PathVariable Long empID)
    {
        empRepo.deleteById(empID);
        Pageable pageable = PageRequest.of(0, maxSize, Sort.by("id").descending());
        Page<Employee> page = empRepo.findAll(pageable);
        int totalPages = page.getTotalPages();
        List<Employee> listEmp = page.toList();

        model.addAttribute("listEmp", listEmp);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("curPage", 1);
        return "empReg";
    }

    @PostMapping("/emp/save/")
    public String addEmp(Model model, Employee emp)
    {
        empRepo.save(emp);
        Pageable pageable = PageRequest.of(0, maxSize, Sort.by("id").descending());
        Page<Employee> page = empRepo.findAll(pageable);
        int totalPages = page.getTotalPages();
        List<Employee> listEmp = page.toList();

        model.addAttribute("listEmp", listEmp);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("curPage", 1);
        return "empReg";
    }

}
