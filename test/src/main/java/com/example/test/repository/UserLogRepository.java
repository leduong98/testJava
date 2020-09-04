package com.example.test.repository;


import com.example.test.entities.PartnerLog;
import com.example.test.entities.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserLogRepository extends JpaRepository<UserLog, Long> {
    List<UserLog> findAllByIdAndDeliveryDayGreaterThanEqualAndDeliveryDayLessThanEqual(long id, Date startDate, Date endDate);

    UserLog findByAccNumber(long accNumber);
}
