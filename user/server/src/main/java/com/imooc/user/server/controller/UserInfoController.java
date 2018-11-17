package com.imooc.user.server.controller;

import com.imooc.user.server.constant.CookieConstant;
import com.imooc.user.server.constant.RedisConstant;
import com.imooc.user.server.domain.UserInfo;
import com.imooc.user.server.enums.RoleEnum;
import com.imooc.user.server.service.UserService;
import com.imooc.user.server.util.CookieUtil;
import com.imooc.user.server.util.ResultVoUtil;
import com.imooc.user.server.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: user
 * @Package: com.imooc.user.server.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 9:24 AM
 * @Version: v1.0
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/buyer")
    public ResultVo buyer(@RequestParam("openid") String openid, HttpServletResponse response){

        UserInfo userInfo = userService.findByOpenid(openid);

        if(userInfo==null){
            return ResultVoUtil.error("登录失败");
        }


        if(RoleEnum.BUYER.getCode()!= userInfo.getRole()){
            return ResultVoUtil.error("角色不对");
        }
        CookieUtil.set(response, CookieConstant.OPENID,openid,CookieConstant.expire);
        return ResultVoUtil.success();
    }


    @GetMapping("/seller")
    public ResultVo seller(@RequestParam("openid") String openid,
                           HttpServletRequest request,
                           HttpServletResponse response){

        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);

        if(cookie!=null&&!StringUtils.isEmpty(stringRedisTemplate.opsForValue()
                .get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))){
            return ResultVoUtil.success();
        }



        UserInfo userInfo = userService.findByOpenid(openid);

        if(userInfo==null){
            return ResultVoUtil.error("登录失败");
        }


        if(RoleEnum.SELLER.getCode()!= userInfo.getRole()){
            return ResultVoUtil.error("角色不对");
        }

        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token)
                ,openid
                ,expire
                , TimeUnit.SECONDS);


        CookieUtil.set(response, CookieConstant.TOKEN,token,CookieConstant.expire);
        return ResultVoUtil.success();
    }



}
