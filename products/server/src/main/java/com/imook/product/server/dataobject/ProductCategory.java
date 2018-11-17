package com.imook.product.server.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.dataobject
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 12:16 AM
 * @Version: v1.0
 */
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
