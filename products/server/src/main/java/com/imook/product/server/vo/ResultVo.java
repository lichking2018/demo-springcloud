package com.imook.product.server.vo;

import lombok.Data;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.vo
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 12:58 PM
 * @Version: v1.0
 */
@Data
public class ResultVo<T> {

    private Integer code;

    private String message;

    private T data;
}
