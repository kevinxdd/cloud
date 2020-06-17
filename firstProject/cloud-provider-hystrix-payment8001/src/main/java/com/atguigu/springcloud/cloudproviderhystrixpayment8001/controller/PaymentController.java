package com.atguigu.springcloud.cloudproviderhystrixpayment8001.controller;/**
 * Create by xdd on 2020/6/8.
 */

import com.atguigu.springcloud.cloudproviderhystrixpayment8001.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xdd
 */
@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") String id) {
        String result = paymentService.serverOK(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") String id) {
        String result = paymentService.serverTimeOut(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") String id) {
        String result = paymentService.serverError(id);
        log.info("*****result: " + result);
        return result;
    }
}
