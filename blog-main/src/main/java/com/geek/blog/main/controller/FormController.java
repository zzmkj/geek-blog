package com.geek.blog.main.controller;

import com.geek.blog.common.BO.UserForm;
import com.geek.blog.common.model.Form;
import com.geek.blog.common.model.FormItem;
import com.geek.blog.common.service.FormItemService;
import com.geek.blog.common.service.FormService;
import com.geek.blog.common.utils.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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

    @Autowired
    private FormItemService formItemService;

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

    @GetMapping("/index/form")
    public String indexForm(Model model) {
        List<Form> formList = formService.findAll();
        model.addAttribute("formList", formList);
        return "index";
    }

    @PostMapping("/user")
    public String user(UserForm userForm) {

        Map<String, String> map = new HashMap<>();
        log.info("userForm：{}", userForm);
        String formid = userForm.getFormid();
        Form form = formService.findById(formid);
        Form resultForm = new Form();
        BeanUtils.copyProperties(form, resultForm);
        resultForm.setId(IDUtil.uuid());
        resultForm.setPid(form.getId());
        resultForm.setUserid(IDUtil.uuid());
        formService.save(resultForm);
        List<String> textFormItemid = userForm.getTextFormItemid();
        List<String> textFormItemResult = userForm.getTextFormItemResult();
        IntStream.range(0, userForm.getTextFormItemid().size()).forEachOrdered((i) -> {
            String formItemid = textFormItemid.get(i);
            String result = textFormItemResult.get(i);

            FormItem formItem = formItemService.findById(formItemid);
            FormItem resultFormItem = new FormItem();
            BeanUtils.copyProperties(formItem, resultFormItem);
            resultFormItem.setId(IDUtil.uuid());
            resultFormItem.setResult(Arrays.asList(result));
            resultFormItem.setFid(formItem.getId());
            resultFormItem.setForm(resultForm);
            formItemService.save(resultFormItem);
        });
        /*textFormItemid.stream().forEachOrdered((formItemid) -> {
            FormItem formItem = formItemService.findById(formItemid);
            formItem
        });*/
        return "redirect:/formItem/" + userForm.getFormid() + "/formItem";
    }

}
