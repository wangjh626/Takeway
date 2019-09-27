package com.wjh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return "Order 的端口是：" + this.port;
    }
}
