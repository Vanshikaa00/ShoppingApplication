package com.caseStudy.eCart.repo;

import com.caseStudy.eCart.models.OrderHistory;
import com.caseStudy.eCart.models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> {
List <OrderHistory> findAllByUsers(users users);
}
