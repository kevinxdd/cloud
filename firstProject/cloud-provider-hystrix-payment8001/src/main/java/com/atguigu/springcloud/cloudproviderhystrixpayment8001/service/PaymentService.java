package com.atguigu.springcloud.cloudproviderhystrixpayment8001.service;/**
 * Create by xdd on 2020/6/8.
 */

/**
 * @author xdd
 */
public interface PaymentService
{
    String serverOK(String id);

    String serverTimeOut(String id);

    String serverError(String id);
}
