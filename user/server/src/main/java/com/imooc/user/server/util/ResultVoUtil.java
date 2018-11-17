package com.imooc.user.server.util;

import com.imooc.user.server.vo.ResultVo;

/**
 * @ProjectName: user
 * @Package: com.imooc.user.server.util
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 9:31 AM
 * @Version: v1.0
 */
public class ResultVoUtil {

    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMessage("成功");
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo success(){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMessage("成功");
        return resultVo;
    }

    public static ResultVo error(String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMessage(message);
        resultVo.setData(null);
        return resultVo;
    }
}
