package com.geek.blog.common.service;

import com.geek.blog.common.model.FormItem;
import com.geek.blog.common.repository.FormItemRepository;
import com.geek.blog.common.utils.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName FormItemService
 * @Description
 * @Author lrg
 * @Date 2019-10-08 19:23
 * @Version 1.0
 */
@Service
@Slf4j
public class FormItemService {

    @Autowired
    private FormItemRepository formItemRepository;

    // 增加
    public void save(FormItem formItem) {
        if (StringUtils.isBlank(formItem.getId())) {
            formItem.setId(IDUtil.uuid());
        }
        formItemRepository.save(formItem);
    }

    //删除
    public void deleteById(String id) {
        formItemRepository.deleteById(id);
    }

    //查询全部
    public List<FormItem> findAll() {
        List<FormItem> formItemList = formItemRepository.findAll();
        return formItemList;
    }

    //查询单个
    public FormItem findById(String id) {
        FormItem formItem = formItemRepository.findById(id).get();
        return formItem;
    }

}
