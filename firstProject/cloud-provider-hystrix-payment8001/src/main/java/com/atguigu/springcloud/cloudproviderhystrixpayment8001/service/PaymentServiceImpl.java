package com.atguigu.springcloud.cloudproviderhystrixpayment8001.service;/**
 * Create by xdd on 2020/6/8.
 */

import com.oracle.tools.packager.Log;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author xdd
 */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService
{
    private String name;

    @Override
    public String serverOK(String id)
    {
        return "线程池： " + Thread.currentThread().getName()
                + "   paymentInfo_OK,id:" + id + " 正常访问！";
    }

    @Override
    public String serverTimeOut(String id)
    {
        int timeNumber = 700;
        try {
            Thread.sleep(timeNumber);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName()
                + "   paymentInfo_OK,id:" + id + " 耗时(秒):" + timeNumber;
    }

    @Override
    public String serverError(String id)
    {
        return null;
    }
}
