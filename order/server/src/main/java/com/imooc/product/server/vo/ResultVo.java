package com.imooc.product.server.vo;

import lombok.Data;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.vo
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 4:18 PM
 * @Version: v1.0
 */
@Data
public class ResultVo<T> {

    private Integer code;

    private String message;

    private T data;
}
