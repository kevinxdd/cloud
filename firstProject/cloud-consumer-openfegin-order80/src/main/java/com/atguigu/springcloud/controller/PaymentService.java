package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Create by xdd on 2020/3/18.
 *
 * feign  默认超时 是1秒钟 但是可以设置 feign 的默认设置
 *
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentService
{
    @GetMapping(value = "payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @PostMapping(value = "payment/create")
    CommonResult create(Payment payment);
}
