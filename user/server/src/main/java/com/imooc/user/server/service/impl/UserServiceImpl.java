package com.imooc.user.server.service.impl;

import com.imooc.user.server.domain.UserInfo;
import com.imooc.user.server.repository.UserInfoRepository;
import com.imooc.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: user
 * @Package: com.imooc.user.server.service.impl
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 9:23 AM
 * @Version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
