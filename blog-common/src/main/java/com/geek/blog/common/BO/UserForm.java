package com.geek.blog.common.BO;

import lombok.Data;

import java.util.List;

/**
 * @ClassName UserForm
 * @Description
 * @Author lrg
 * @Date 2019-10-11 19:24
 * @Version 1.0
 */
@Data
public class UserForm {

    private String formid;  // 表单id

    private List<String> textFormItemid; // 文本表单项id

    private List<String> textFormItemResult; // 文本类型结果


}
