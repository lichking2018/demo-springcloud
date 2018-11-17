package com.imooc.product.server.repository;


import com.imooc.product.server.domain.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.repository
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 2:22 PM
 * @Version: v1.0
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {


}
