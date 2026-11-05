package com.saas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenantId;
    private String plan;
    private String status;
    private String billingCycle;
    private String userId;

    @Column(name = "data_value")
    private Double dataValue;

    private Integer viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime timestamp;

    public Subscription() {
        this.createdAt = LocalDateTime.now();
        this.timestamp = LocalDateTime.now();
        this.viewCount = 0;
    }

    // Builder Pattern - Same as 99/100
    public static class Builder {
        private Subscription sub = new Subscription();

        public Builder tenantId(String tenantId) { sub.tenantId = tenantId; return this; }
        public Builder plan(String plan) { sub.plan = plan; return this; }
        public Builder status(String status) { sub.status = status; return this; }
        public Builder billingCycle(String billingCycle) { sub.billingCycle = billingCycle; return this; }
        public Builder userId(String userId) { sub.userId = userId; return this; }
        public Builder dataValue(Double dataValue) { sub.dataValue = dataValue; return this; }
        public Builder viewCount(Integer viewCount) { sub.viewCount = viewCount; return this; }
        public Subscription build() { return sub; }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public String getPlan() { return plan; }
    public void setPlan(String plan) { this.plan = plan; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getBillingCycle() { return billingCycle; }
    public void setBillingCycle(String billingCycle) { this.billingCycle = billingCycle; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Double getDataValue() { return dataValue; }
    public void setDataValue(Double dataValue) { this.dataValue = dataValue; }

    @JsonIgnore
    public Double getValue() { return dataValue; }
    @JsonIgnore
    public void setValue(Double value) { this.dataValue = value; }

    public Integer getViewCount() { return viewCount; }
    public void setViewCount(Integer viewCount) { this.viewCount = viewCount; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}