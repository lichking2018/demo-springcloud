package com.imook.product.server.service.impl;


import com.imook.product.server.dataobject.ProductCategory;
import com.imook.product.server.repository.ProductCategoryRepository;
import com.imook.product.server.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.service.impl
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 12:51 PM
 * @Version: v1.0
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> types) {
        return productCategoryRepository.findByCategoryTypeIn(types);
    }
}
