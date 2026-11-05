package com.saas.service;

import com.saas.model.Subscription;
import com.saas.repository.SubscriptionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {

    @Mock
    private SubscriptionRepository repository;

    @InjectMocks
    private SubscriptionService service;

    @Test
    public void testBuilderPattern() {
        Subscription sub = new Subscription.Builder()
                .tenantId("tenant1")
                .plan("PRO")
                .status("ACTIVE")
                .billingCycle("MONTHLY")
                .userId("user1")
                .dataValue(29.99)
                .build();

        assertNotNull(sub);
        assertEquals("tenant1", sub.getTenantId());
        assertEquals("PRO", sub.getPlan());
        System.out.println("Builder Pattern Test Passed: " + sub.getPlan());
    }

    @Test
    public void testSubscriptionEntity() {
        Subscription sub = new Subscription();
        sub.setTenantId("tenant1");
        sub.setPlan("BASIC");
        sub.setStatus("TRIAL");
        sub.setBillingCycle("YEARLY");
        sub.setUserId("user1");
        sub.setDataValue(99.99);

        assertEquals("tenant1", sub.getTenantId());
        assertEquals("BASIC", sub.getPlan());
        System.out.println("Subscription Entity Test Passed");
    }

    @Test
    public void testFormatSubscriptionInfo() {
        Subscription sub = new Subscription();
        sub.setTenantId("tenant1");
        sub.setPlan("PRO");
        sub.setStatus("ACTIVE");
        sub.setBillingCycle("MONTHLY");

        String info = service.formatSubscriptionInfo(sub);
        assertNotNull(info);
        assertTrue(info.contains("tenant1"));
        System.out.println("Format Subscription Test Passed: " + info);
    }

    @Test
    public void testGetSubscriptionById_Mockito() {
        Subscription sub = new Subscription();
        sub.setId(1L);
        sub.setTenantId("tenant1");
        sub.setPlan("PRO");

        when(repository.findById(1L)).thenReturn(Optional.of(sub));

        Subscription result = service.getSubscriptionById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(repository, times(1)).findById(1L);
        System.out.println("Mockito Test Passed: getSubscriptionById");
    }

    @Test
    public void testSearchByPlan_Mockito() {
        Subscription sub = new Subscription();
        sub.setPlan("PRO");

        when(repository.findByPlanOrderByCreatedAtDesc("PRO")).thenReturn(Arrays.asList(sub));

        List<Subscription> result = service.searchByPlan("PRO");
        assertEquals(1, result.size());
        System.out.println("Search Test Passed: Found 1 rec for plan PRO");
    }

    @Test
    public void testGetAllSubscriptions_Mockito() {
        Subscription sub1 = new Subscription();
        sub1.setPlan("BASIC");
        Subscription sub2 = new Subscription();
        sub2.setPlan("PRO");

        when(repository.findAllByOrderByCreatedAtDesc()).thenReturn(Arrays.asList(sub1, sub2));

        List<Subscription> result = service.getAllSubscriptions();
        assertEquals(2, result.size());
        System.out.println("Mockito Test Passed: getAllSubscriptions - Mocked 2 subs");
    }
}