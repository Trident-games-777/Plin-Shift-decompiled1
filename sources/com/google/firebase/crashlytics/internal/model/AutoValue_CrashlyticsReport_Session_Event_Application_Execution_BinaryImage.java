package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {
    private final long baseAddress;
    private final String name;
    private final long size;
    private final String uuid;

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j, long j2, String str, String str2) {
        this.baseAddress = j;
        this.size = j2;
        this.name = str;
        this.uuid = str2;
    }

    public long getBaseAddress() {
        return this.baseAddress;
    }

    public long getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    @Encodable.Ignore
    public String getUuid() {
        return this.uuid;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.baseAddress + ", size=" + this.size + ", name=" + this.name + ", uuid=" + this.uuid + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        r1 = r7.uuid;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
            r2 = 0
            if (r1 == 0) goto L_0x0041
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage r8 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) r8
            long r3 = r7.baseAddress
            long r5 = r8.getBaseAddress()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0041
            long r3 = r7.size
            long r5 = r8.getSize()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0041
            java.lang.String r1 = r7.name
            java.lang.String r3 = r8.getName()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = r7.uuid
            if (r1 != 0) goto L_0x0036
            java.lang.String r8 = r8.getUuid()
            if (r8 != 0) goto L_0x0041
            goto L_0x0040
        L_0x0036:
            java.lang.String r8 = r8.getUuid()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0041
        L_0x0040:
            return r0
        L_0x0041:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long j = this.baseAddress;
        long j2 = this.size;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.name.hashCode()) * 1000003;
        String str = this.uuid;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {
        private long baseAddress;
        private String name;
        private byte set$0;
        private long size;
        private String uuid;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long j) {
            this.baseAddress = j;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long j) {
            this.size = j;
            this.set$0 = (byte) (this.set$0 | 2);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String str) {
            if (str != null) {
                this.name = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(String str) {
            this.uuid = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build() {
            if (this.set$0 == 3 && this.name != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.baseAddress, this.size, this.name, this.uuid);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.set$0 & 1) == 0) {
                sb.append(" baseAddress");
            }
            if ((this.set$0 & 2) == 0) {
                sb.append(" size");
            }
            if (this.name == null) {
                sb.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }
    }
}
