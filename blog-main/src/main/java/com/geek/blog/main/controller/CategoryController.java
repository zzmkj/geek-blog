package com.geek.blog.main.controller;

import com.geek.blog.common.BO.CategoryBO;
import com.geek.blog.common.model.Category;
import com.geek.blog.common.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author zzm
 * @Data 2019/9/27 19:32
 * @Version 1.0
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public String findAll(Model model) {
        List<Category> categoryList = categoryService.findByParentId("0");

        model.addAttribute("categoryList", categoryList);
        return "admin_category";
    }

    @ResponseBody
    @PostMapping
    public void save(CategoryBO categoryBO) {
        categoryService.save(categoryBO);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") String id) {
        return categoryService.findById(id);
    }

    @ResponseBody
    @GetMapping("/{parentId}/children")
    public List<Category> findByParentId(@PathVariable("parentId")String parentId) {
        return categoryService.findByParentId(parentId);
    }

    @ResponseBody
    @GetMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") String id) {
        categoryService.deleteById(id);
    }

}
