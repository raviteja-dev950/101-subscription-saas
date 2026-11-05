package com.saas.controller;

import com.saas.model.Subscription;
import com.saas.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription request) {
        Subscription sub = service.createSubscription(
            request.getTenantId(),
            request.getPlan(),
            request.getStatus(),
            request.getBillingCycle(),
            request.getUserId(),
            request.getDataValue()
        );
        return ResponseEntity.ok(sub);
    }

    @GetMapping
    @Cacheable("subscriptions")
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> list = service.getAllSubscriptions();
        return ResponseEntity.ok()
                .header("X-Cache", "Caffeine - subscriptions")
                .header("Cache-Control", "public, max-age=3600")
                .body(list);
    }

    @GetMapping("/{id}")
    @Cacheable("subscription")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
        Subscription sub = service.getSubscriptionById(id);
        if (sub != null) {
            sub.setViewCount(sub.getViewCount() + 1);
        }
        return ResponseEntity.ok(sub);
    }

    // Strategy Pattern - Plan vs Status vs Tenant vs Hybrid - Core SaaS Feature
    @GetMapping("/strategy")
    public ResponseEntity<Map<String, Object>> getByStrategy(@RequestParam String type, @RequestParam(required = false) String filter) {
        List<Subscription> result = service.getSubscriptionByStrategy(type, filter);
        Map<String, Object> map = new HashMap<>();
        map.put("strategy", type + "-Strategy");
        map.put("filter", filter);
        map.put("count", result.size());
        map.put("data", result);
        return ResponseEntity.ok()
                .header("X-Strategy", type + "-Strategy")
                .body(map);
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchByPlan(@RequestParam String plan) {
        List<Subscription> result = service.searchByPlan(plan);
        Map<String, Object> map = new HashMap<>();
        map.put("query", plan);
        map.put("count", result.size());
        map.put("data", result);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.countSubscriptions());
    }

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("Subscription SaaS - Tier 10 SCALE - Caching Caffeine 1000 max 600s Stats + Security Headers + Builder Pattern + Strategy Pattern Plan Status Tenant Hybrid + Repository Pattern + H2 saasdb + JUnit 5 6/6 Green Bar");
    }
}