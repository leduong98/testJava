package com.example.test.service;

import com.example.test.dtos.Info;
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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayService {

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartnerLogRepository partnerLogRepository;

    @Autowired
    UserLogRepository userLogRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseEntity<?> payMent(Info info) {
        Partner partner = partnerRepository.findById(info.getPartnerId()).orElse(null);
        User user = userRepository.findById(info.getUserId()).orElse(null);
        PartnerLog partnerLog = partnerLogRepository.findById(info.getOrderId()).orElse(null);
        UserLog userLog = userLogRepository.findById(info.getOrderId()).orElse(null);

        if(info.getPassWord().equals(partner.getPassword())){

            if (info.getDeliveryMoney() >= 0) {
                partner.setAccountBalance(partner.getAccountBalance() + info.getDeliveryMoney());
                if(user.getAccountBalance()>= info.getDeliveryMoney()){
                    user.setAccountBalance(user.getAccountBalance() - info.getDeliveryMoney());
                }
            }
            partnerLog.setId(info.getOrderId());
            partnerLog.setDeliveryDay(info.getDeliveryDay());
            partnerLog.setDeliveryFee(info.getDeliveryFee());
            partnerLog.setDeliveryMoney(info.getDeliveryMoney());
            partnerLog.setName(info.getName());
            partnerLog.setPartner(partner);
            partnerLogRepository.save(partnerLog);

            userLog.setId(info.getOrderId());
            userLog.setDeliveryDay(info.getDeliveryDay());
            userLog.setDeliveryFee(info.getDeliveryFee());
            userLog.setDeliveryMoney(info.getDeliveryMoney());
            userLog.setName(info.getName());
            userLog.setUser(user);
            userLogRepository.save(userLog);
        }
        return new ResponseEntity<>("giao dich thanh cong", HttpStatus.OK);
    }

}
