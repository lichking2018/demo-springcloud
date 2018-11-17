package com.imooc.product.server.repository;


import com.imooc.product.server.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.repository
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 2:24 PM
 * @Version: v1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
