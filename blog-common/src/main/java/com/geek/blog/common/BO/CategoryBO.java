package com.geek.blog.common.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CategoryBO
 * @Description TODO
 * @Author zzm
 * @Data 2019/9/28 19:46
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryBO {

    private String id;

    private String text; //名称

    private String parentId; //父id

    private Boolean children; //是否有子节点  有子节点：1  没有子节点：0
}
