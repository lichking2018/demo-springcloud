package com.imook.product.server.utils;

import com.imook.product.server.vo.ResultVo;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.utils
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 1:46 PM
 * @Version: v1.0
 */
public class ResultVoUtil {

    public static ResultVo getSuccessResult(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(data);
        resultVo.setCode(0);
        resultVo.setMessage("成功");
        return resultVo;
    }
}
