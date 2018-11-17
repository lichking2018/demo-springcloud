package com.imook.product.server.service;


import com.imook.product.server.dataobject.ProductInfo;
import com.imook.product.server.dto.CartDto;

import java.util.List;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.service
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 12:43 PM
 * @Version: v1.0
 */
public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    void decreaseStock(List<CartDto> cartDtos);
}
