package com.imooc.user.server.repository;

import com.imooc.user.server.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: user
 * @Package: com.imooc.user.server.repository
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 9:21 AM
 * @Version: v1.0
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,String>{

    UserInfo findByOpenid(String openId);


}
