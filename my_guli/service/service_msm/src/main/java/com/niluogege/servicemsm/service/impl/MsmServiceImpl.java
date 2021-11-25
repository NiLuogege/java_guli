package com.niluogege.servicemsm.service.impl;

import com.niluogege.servicemsm.service.MsmService;
import org.springframework.stereotype.Service;

@Service
public class MsmServiceImpl implements MsmService {
    @Override
    public boolean send(String phone, String code) {
        System.out.println("发送短信 phone="+phone+" code="+code);
        return true;
    }
}
