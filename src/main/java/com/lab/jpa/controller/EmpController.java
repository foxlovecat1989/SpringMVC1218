package com.lab.jpa.controller;

import com.lab.jpa.repository.CompanyDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpController {
    
    @Autowired
    private CompanyDao companyDao;
    
    @RequestMapping("/")
    public String read(Model model){
        List emp_list = companyDao.queryForAllEmps();
        model.addAttribute("emp_list", emp_list);
        return "emp_page";
    }
}
