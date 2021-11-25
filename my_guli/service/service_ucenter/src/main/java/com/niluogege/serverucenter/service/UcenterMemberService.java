package com.niluogege.serverucenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niluogege.serverucenter.entity.UcenterMember;
import com.niluogege.serverucenter.entity.in.LoginIn;
import com.niluogege.serverucenter.entity.in.RegisterIn;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-25
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    boolean registe(RegisterIn register);

    String login(LoginIn login);
}
