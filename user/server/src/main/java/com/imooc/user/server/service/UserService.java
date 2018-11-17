package com.imooc.user.server.service;

import com.imooc.user.server.domain.UserInfo;

/**
 * @ProjectName: user
 * @Package: com.imooc.user.server.service
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 9:22 AM
 * @Version: v1.0
 */
public interface UserService {
    UserInfo findByOpenid(String openid);
}
