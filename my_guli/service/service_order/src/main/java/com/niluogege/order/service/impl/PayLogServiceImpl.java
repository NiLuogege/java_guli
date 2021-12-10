package com.niluogege.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.order.entity.PayLog;
import com.niluogege.order.mapper.PayLogMapper;
import com.niluogege.order.service.PayLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author niluogege
 * @since 2021-12-10
 */
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

}
