package com.imooc.user.server.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ProjectName: user
 * @Package: com.imooc.user.server.domain
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/13 9:18 AM
 * @Version: v1.0
 */
@Data
@Entity
public class UserInfo {
    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;

}
