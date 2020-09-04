package com.example.test.repository;

import com.example.test.dtos.PartnerDTO;
import com.example.test.entities.PartnerLog;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PartnerLogRepository extends JpaRepository<PartnerLog, Long> {

    List<PartnerLog> findAllByIdAndDeliveryDayGreaterThanEqualAndDeliveryDayLessThanEqual(long id, Date startDate, Date endDate);

    PartnerLog findByAccNumber(long accNumber);
}
