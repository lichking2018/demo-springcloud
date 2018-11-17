package com.imooc.product.server.utils;


import com.imooc.product.server.vo.ResultVo;

/**
 * @ProjectName: order
 * @Package: com.imooc.order.utils
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 4:19 PM
 * @Version: v1.0
 */
public class ResultVoUtil {

    public static ResultVo getSuccess(Object o){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMessage("成功");
        resultVo.setData(o);
        return resultVo;
    }
}
