package com.sparta.mydelivery.repository;

import com.sparta.mydelivery.models.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderList, Long> {
}
