package com.example.test.controller;

import com.example.test.dtos.Info;
import com.example.test.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/test")
public class PayController {

        @Autowired
        private PayService payService;

        @PostMapping(value = "/pay")
        public ResponseEntity<?> payMent(@Valid @RequestBody Info info) {
            return payService.payMent(info);
        }
}
