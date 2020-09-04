package com.example.test.service;

import com.example.test.dtos.Info;
import com.example.test.dtos.PartnerDTO;
import com.example.test.dtos.UserDTO;
import com.example.test.entities.Partner;
import com.example.test.entities.PartnerLog;
import com.example.test.entities.User;
import com.example.test.entities.UserLog;
import com.example.test.repository.PartnerLogRepository;
import com.example.test.repository.PartnerRepository;
import com.example.test.repository.UserLogRepository;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetLogService {

    @Autowired
    PartnerLogRepository partnerLogRepository;

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserLogRepository userLogRepository;

    public ResponseEntity<?> getPartnerLog(PartnerDTO partnerDTO) {
        Partner partner = partnerRepository.findById(partnerDTO.getId()).orElse(null);
        if (partner!=null) {
            List<PartnerLog> partnerLogList = partnerLogRepository.findAllByIdAndDeliveryDayGreaterThanEqualAndDeliveryDayLessThanEqual(partnerDTO.getId(), partnerDTO.getDayStart(), partnerDTO.getDayEnd());
        return new ResponseEntity<>(partnerLogList, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("null",HttpStatus.BAD_GATEWAY);
    }
    public ResponseEntity<?> getUserLog(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElse(null);
        if (user!=null) {
            List<UserLog> userLogList = userLogRepository.findAllByIdAndDeliveryDayGreaterThanEqualAndDeliveryDayLessThanEqual(userDTO.getId(), userDTO.getDayStart(), userDTO.getDayEnd());
        return new ResponseEntity<>(userLogList, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("null",HttpStatus.BAD_GATEWAY);
    }



}
