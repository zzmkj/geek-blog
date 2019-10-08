package com.geek.blog.main.controller;

import com.geek.blog.common.model.Form;
import com.geek.blog.common.service.FormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName FormController
 * @Description
 * @Author lrg
 * @Date 2019-10-08 19:28
 * @Version 1.0
 */
@Controller
@Slf4j
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/index")
    public String index(Model model){
        List<Form> formList = formService.findAll();
        model.addAttribute("formList", formList);
        return "admin_form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(Form form) {
        formService.save(form);
        return "success";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        formService.deleteById(id);
        return "redirect:/form/index";
    }

}
