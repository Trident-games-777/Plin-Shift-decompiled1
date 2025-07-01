package com.google.android.datatransport;

final class AutoValue_Event<T> extends Event<T> {
    private final Integer code;
    private final EventContext eventContext;
    private final T payload;
    private final Priority priority;
    private final ProductData productData;

    AutoValue_Event(Integer num, T t, Priority priority2, ProductData productData2, EventContext eventContext2) {
        this.code = num;
        if (t != null) {
            this.payload = t;
            if (priority2 != null) {
                this.priority = priority2;
                this.productData = productData2;
                this.eventContext = eventContext2;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public Integer getCode() {
        return this.code;
    }

    public T getPayload() {
        return this.payload;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public ProductData getProductData() {
        return this.productData;
    }

    public EventContext getEventContext() {
        return this.eventContext;
    }

    public String toString() {
        return "Event{code=" + this.code + ", payload=" + this.payload + ", priority=" + this.priority + ", productData=" + this.productData + ", eventContext=" + this.eventContext + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r1 = r4.productData;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r1 = r4.eventContext;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.datatransport.Event
            r2 = 0
            if (r1 == 0) goto L_0x0063
            com.google.android.datatransport.Event r5 = (com.google.android.datatransport.Event) r5
            java.lang.Integer r1 = r4.code
            if (r1 != 0) goto L_0x0016
            java.lang.Integer r1 = r5.getCode()
            if (r1 != 0) goto L_0x0063
            goto L_0x0020
        L_0x0016:
            java.lang.Integer r3 = r5.getCode()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
        L_0x0020:
            T r1 = r4.payload
            java.lang.Object r3 = r5.getPayload()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
            com.google.android.datatransport.Priority r1 = r4.priority
            com.google.android.datatransport.Priority r3 = r5.getPriority()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
            com.google.android.datatransport.ProductData r1 = r4.productData
            if (r1 != 0) goto L_0x0043
            com.google.android.datatransport.ProductData r1 = r5.getProductData()
            if (r1 != 0) goto L_0x0063
            goto L_0x004d
        L_0x0043:
            com.google.android.datatransport.ProductData r3 = r5.getProductData()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
        L_0x004d:
            com.google.android.datatransport.EventContext r1 = r4.eventContext
            if (r1 != 0) goto L_0x0058
            com.google.android.datatransport.EventContext r5 = r5.getEventContext()
            if (r5 != 0) goto L_0x0063
            goto L_0x0062
        L_0x0058:
            com.google.android.datatransport.EventContext r5 = r5.getEventContext()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0063
        L_0x0062:
            return r0
        L_0x0063:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.AutoValue_Event.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Integer num = this.code;
        int i = 0;
        int hashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode()) * 1000003;
        ProductData productData2 = this.productData;
        int hashCode2 = (hashCode ^ (productData2 == null ? 0 : productData2.hashCode())) * 1000003;
        EventContext eventContext2 = this.eventContext;
        if (eventContext2 != null) {
            i = eventContext2.hashCode();
        }
        return hashCode2 ^ i;
    }
}
