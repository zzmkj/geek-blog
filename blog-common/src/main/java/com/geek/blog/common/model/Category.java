package com.geek.blog.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName Category
 * @Description TODO
 * @Author zzm
 * @Data 2019/9/27 19:17
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category implements Serializable {

    @Id
    private String id;

    private String text; //名称

    private String parentId; //父id

    private Boolean children; //是否有子节点  有子节点：1  没有子节点：0

}
