package com.imook.product.server.repository;


import com.imook.product.server.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.repository
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/5 7:22 PM
 * @Version: v1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
