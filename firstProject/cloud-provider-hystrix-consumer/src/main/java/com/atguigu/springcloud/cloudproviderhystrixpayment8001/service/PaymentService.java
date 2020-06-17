package com.atguigu.springcloud.cloudproviderhystrixpayment8001.service;/**
 * Create by xdd on 2020/6/8.
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sun.awt.SunHints;

import java.util.Properties;

/**
 * @author xdd
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentServiceImpl.class)

public interface PaymentService
{

    @GetMapping("/payment/hystrix/ok/{id}")
     String paymentInfo_OK(@PathVariable("id") String id) ;

    @GetMapping("/payment/hystrix/timeout/{id}")
     String paymentInfo_Timeout(@PathVariable("id") String id);

    @GetMapping("/payment/circuit/{id}")
     String paymentCircuitBreaker(@PathVariable("id") String id);

    default String baseReturn(){
        return "默认返回";
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {

            System.out.println(i+"/"+(i&3));
        }
    }
}
