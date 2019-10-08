package com.geek.blog.main.controller;

import com.geek.blog.common.model.Form;
import com.geek.blog.common.model.FormItem;
import com.geek.blog.common.service.FormItemService;
import com.geek.blog.common.service.FormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName FormItemController
 * @Description
 * @Author lrg
 * @Date 2019-10-08 19:48
 * @Version 1.0
 */
@RequestMapping("/formItem")
@Controller
@Slf4j
public class FormItemController {

    @Autowired
    private FormItemService formItemService;

    @Autowired
    private FormService formService;

    @GetMapping("/{id}")
    public String find(@PathVariable String id,
                       Model model) {
        model.addAttribute("formId", id);
        List<FormItem> formItemList = formItemService.findAll();
        model.addAttribute("formItemList", formItemList);
        return "admin_formItem";
    }

    @GetMapping("/add/{formid}")
    public String add(@PathVariable String formid) {
        Form form = formService.findById(formid);
        FormItem formItem = new FormItem();
        formItem.setForm(form);
        formItemService.save(formItem);
        return "redirect:/formItem/" + formid;
    }

    @GetMapping("/name/{id}/{name}")
    @ResponseBody
    public String editName(@PathVariable String id, @PathVariable String name) {
        FormItem formItem = formItemService.findById(id);
        formItem.setName(name);
        formItemService.save(formItem);
        return "success";
    }

    @GetMapping("/type/{id}/{type}")
    @ResponseBody
    public String edittype(@PathVariable String id, @PathVariable String type) {
        FormItem formItem = formItemService.findById(id);
        formItem.setType(type);
        formItemService.save(formItem);
        return "success";
    }
}