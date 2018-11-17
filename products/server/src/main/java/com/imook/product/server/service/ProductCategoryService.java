package com.imook.product.server.service;


import com.imook.product.server.dataobject.ProductCategory;

import java.util.List;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.service
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 12:50 PM
 * @Version: v1.0
 */
public interface ProductCategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> types);
}
