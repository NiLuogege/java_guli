package com.niluogege.serverucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.commonutils.BCrypt;
import com.niluogege.commonutils.JwtUtils;
import com.niluogege.serverucenter.entity.UcenterMember;
import com.niluogege.serverucenter.entity.in.LoginIn;
import com.niluogege.serverucenter.entity.in.RegisterIn;
import com.niluogege.serverucenter.mapper.UcenterMemberMapper;
import com.niluogege.serverucenter.service.UcenterMemberService;
import com.niluogege.servicebase.exceptionhandler.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-25
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    static String s = "$2a$10$DeJncWvyEtcrbfZeL43SzO";

    @Autowired
    private UcenterMemberMapper memberMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean registe(RegisterIn register) {

        String code = register.getCode();
        String nickname = register.getNickname();
        String mobile = register.getMobile();
        String password = register.getPassword();

        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(code) || StringUtils.isEmpty(password)) {
            throw new ServiceException(-1, "手机号 or 密码 or 验证码为空");
        }

        String cacheCode = (String) redisTemplate.boundValueOps("sendLoginMsm_" + mobile).get();

        if (!code.equals(cacheCode)) {
            throw new ServiceException(-1, "验证码错误");
        }


        Integer count = memberMapper.selectCount(new QueryWrapper<UcenterMember>().eq("mobile", mobile));
        if (count > 0) {
            throw new ServiceException(-1, "用户已存在");
        }

        UcenterMember ucenterMember = new UcenterMember();
        BeanUtils.copyProperties(register, ucenterMember);
        ucenterMember.setPassword(BCrypt.hashpw(password, s));


        int insert = memberMapper.insert(ucenterMember);
        redisTemplate.boundValueOps("sendLoginMsm_" + mobile).set("");
        return insert > 0;
    }

    @Override
    public String login(LoginIn login) {
        String mobile = login.getMobile();
        String password = login.getPassword();

        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            throw new ServiceException(-1, "手机号 or 密码 为空");
        }

        UcenterMember user = memberMapper.selectOne(new QueryWrapper<UcenterMember>().eq("mobile", mobile).eq("password", BCrypt.hashpw(password, s)));


        if (user != null) {

            if (user.getIsDisabled()) {
                throw new ServiceException(-1, "手机号被禁用");
            }


            return JwtUtils.getJwtToken(user.getId(), user.getNickname());
        }

        throw new ServiceException(-1, "登录失败");
    }

    @Override
    public UcenterMember getMenberByOperid(String openid) {

        return new UcenterMember();
    }
}
