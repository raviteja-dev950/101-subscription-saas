---
name: Bug report
about: Report bug in Subscription SaaS - Tenant \n trim fix, data_value fix, @JsonIgnore alias
title: '[BUG] 101-subscription-saas - Description'
labels: bug, Tier 10, System Design, subscription-saas
assignees: raviteja-dev950
---

**Describe the bug**
A clear description - e.g., `GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha returns [] empty but DB has tenant-alpha` - tenantId has `\n` newline from Postman Enter.

**To Reproduce**
Steps:
1. Go to `POST /api/subscriptions?plan=STARTER&status=TRIAL&tenantId=tenant-alpha&billingCycle=MONTHLY&dataValue=29.99`
2. Enter pressed adds `\n` -> `tenantId="tenant-alpha\n"`
3. `GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha` -> [] empty
4. See error

**Expected behavior**
Should return 2 items tenant-alpha CLEAN without \n - trim() fix cleanTenantId=tenantId.trim() + cleanType=type.trim() + d.getTenantId().trim() - FIXED [] to 2 items - Same as 99 isolated + 100 resource fix.

**Screenshots**
If applicable, add screenshots - demo11 Tenant FIXED - demo12 Hybrid sorted 299.99,99.99,29.99,9.99.

**Environment:**
 - OS: Windows 11
 - Java: 17 / 21.0.10
 - Port: 8103 local, 10000 Render
 - DB: H2 saasdb file ./data/saasdb
 - Cache: Caffeine 1000 max 600s Stats recordStats
 - Security: Headers nosniff DENY XSS
 - Pattern: Builder Subscription.Builder + Strategy Plan Status Tenant Hybrid sorted price DESC

**Additional context**
Bug same as 99 isolated fix and 100 resource fix - Critical Tier 10 SCALE fix - Also check data_value fix for reserved keyword value + @JsonIgnore alias fix for getValue()/setValue() + @RequestBody vs @RequestParam 400 fix + ddl-auto=update for Table SUBSCRIPTIONS not found + META-INF bug + openjdk not found + COPY target error + dbc typo + H2 driver + dialect space.
