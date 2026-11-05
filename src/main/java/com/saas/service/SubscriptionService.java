package com.saas.service;

import com.saas.model.Subscription;
import com.saas.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository repository;

    @CacheEvict(value = {"subscriptions", "subscription"}, allEntries = true)
    public Subscription createSubscription(String tenantId, String plan, String status, String billingCycle, String userId, Double price) {
        // trim() fix - Same as 99 isolated and 100 resource fix - Prevents \n bug
        String cleanTenantId = tenantId != null ? tenantId.trim() : tenantId;
        String cleanPlan = plan != null ? plan.trim() : plan;
        String cleanStatus = status != null ? status.trim() : status;
        String cleanBillingCycle = billingCycle != null ? billingCycle.trim() : billingCycle;
        String cleanUserId = userId != null ? userId.trim() : userId;

        Subscription sub = new Subscription.Builder()
                .tenantId(cleanTenantId)
                .plan(cleanPlan)
                .status(cleanStatus)
                .billingCycle(cleanBillingCycle)
                .userId(cleanUserId)
                .dataValue(price)
                .viewCount(0)
                .build();

        return repository.save(sub);
    }

    @Cacheable("subscriptions")
    public List<Subscription> getAllSubscriptions() {
        return repository.findAllByOrderByCreatedAtDesc();
    }

    @Cacheable("subscription")
    public Subscription getSubscriptionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String formatSubscriptionInfo(Subscription sub) {
        return String.format("Tenant %s: %s plan (%s) - %s", sub.getTenantId(), sub.getPlan(), sub.getStatus(), sub.getBillingCycle());
    }

    public boolean isRelevant(Subscription sub, String query) {
        return sub.getPlan() != null && sub.getPlan().toLowerCase().contains(query.toLowerCase());
    }

    // Strategy Pattern - Plan vs Status vs Tenant vs Hybrid - Same as 99/100
    public List<Subscription> getSubscriptionByStrategy(String type, String filter) {
        String cleanType = type != null ? type.trim().toLowerCase() : "";
        String cleanFilter = filter != null ? filter.trim() : "";

        List<Subscription> all = repository.findAllByOrderByCreatedAtDesc();

        if (cleanType.equals("plan")) {
            return all.stream()
                    .filter(d -> d.getPlan() != null && d.getPlan().trim().equalsIgnoreCase(cleanFilter))
                    .collect(Collectors.toList());
        } else if (cleanType.equals("status")) {
            return all.stream()
                    .filter(d -> d.getStatus() != null && d.getStatus().trim().equalsIgnoreCase(cleanFilter))
                    .collect(Collectors.toList());
        } else if (cleanType.equals("tenant")) {
            return all.stream()
                    .filter(d -> d.getTenantId() != null && d.getTenantId().trim().equalsIgnoreCase(cleanFilter))
                    .collect(Collectors.toList());
        } else if (cleanType.equals("hybrid")) {
            return all.stream()
                    .sorted((a, b) -> Double.compare(b.getDataValue() != null ? b.getDataValue() : 0, a.getDataValue() != null ? a.getDataValue() : 0))
                    .collect(Collectors.toList());
        }
        return all;
    }

    public List<Subscription> searchByPlan(String plan) {
        String cleanPlan = plan != null ? plan.trim() : plan;
        return repository.findByPlanOrderByCreatedAtDesc(cleanPlan);
    }

    public long countSubscriptions() {
        return repository.count();
    }
}