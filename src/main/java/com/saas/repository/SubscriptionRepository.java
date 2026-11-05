package com.saas.repository;

import com.saas.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findAllByOrderByCreatedAtDesc();
    List<Subscription> findByPlanOrderByCreatedAtDesc(String plan);
    List<Subscription> findByStatusContainingIgnoreCase(String status);
    List<Subscription> findByTenantId(String tenantId);
    List<Subscription> findByPlan(String plan);
    List<Subscription> findByStatus(String status);
}