package com.atguigu.springcloud.cloudproviderhystrixpayment8001.service;/**
 * Create by xdd on 2020/6/8.
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

/**
 * @author xdd
 */
@Component
public class PaymentServiceImpl implements PaymentService
{
    @Override
    public String paymentInfo_OK(String id)
    {
        return null;
    }

    @HystrixCommand(commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "600")})
    @Override
    public String paymentInfo_Timeout(String id)
    {
        return "xdd";
    }

    @Override
    public String paymentCircuitBreaker(String id)
    {
        return null;
    }
}
