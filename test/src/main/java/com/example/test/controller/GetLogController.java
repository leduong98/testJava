package com.example.test.controller;

import com.example.test.dtos.Info;
import com.example.test.dtos.PartnerDTO;
import com.example.test.dtos.UserDTO;
import com.example.test.service.GetLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/test")
public class GetLogController {

    @Autowired
    private GetLogService getLogService;

    @GetMapping(value = "/getuserlog")
    public ResponseEntity<?> getUserLog(@RequestBody UserDTO userDTO) {
        return getLogService.getUserLog(userDTO);
    }

    @GetMapping(value = "/getpartnerlog")
    public ResponseEntity<?> getPartnerLog(@RequestBody PartnerDTO partnerDTO) {
        return getLogService.getPartnerLog(partnerDTO);
    }

}
