package com.saas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> map = new HashMap<>();
        map.put("project", "101-subscription-saas");
        map.put("status", "Live - Subscription SaaS - Tier 10 Scale");
        map.put("tier", "10 - System Design Level - Caching + Security + Testing + Design Patterns");
        map.put("caching", "Caffeine Cache - subscriptions cache - 1000 max, 600s expire - Stats enabled - Redis ready");
        map.put("saas", "Subscription Pattern - Plan Status Tenant Hybrid - Strategy Pattern");
        map.put("live_url", "https://one01-subscription-saas.onrender.com");
        map.put("port", "8103 local, 10000 Render");
        map.put("author", "【entity-Ravi Teja¦canonical_name=Ravi Teja】");
        return map;
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "UP");
        map.put("database", "H2");
        map.put("databaseName", "saasdb");
        map.put("caching", "Caffeine");
        map.put("cacheManager", "Caffeine");
        map.put("cacheSpec", "maximumSize=1000,expireAfterAccess=600s,recordStats");
        map.put("securityHeaders", "X-Content-Type-Options nosniff, X-Frame-Options DENY, X-XSS-Protection");
        map.put("patterns", new String[]{"Builder", "Strategy", "Repository", "Caching"});
        map.put("saas", "Active - Subscription Pattern - Plan Status Tenant Hybrid - Strategy Pattern");
        return map;
    }
}