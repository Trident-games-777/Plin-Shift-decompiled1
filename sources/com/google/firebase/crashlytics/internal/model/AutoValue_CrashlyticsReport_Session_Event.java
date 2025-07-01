package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {
    private final CrashlyticsReport.Session.Event.Application app;
    private final CrashlyticsReport.Session.Event.Device device;
    private final CrashlyticsReport.Session.Event.Log log;
    private final CrashlyticsReport.Session.Event.RolloutsState rollouts;
    private final long timestamp;
    private final String type;

    private AutoValue_CrashlyticsReport_Session_Event(long j, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device2, CrashlyticsReport.Session.Event.Log log2, CrashlyticsReport.Session.Event.RolloutsState rolloutsState) {
        this.timestamp = j;
        this.type = str;
        this.app = application;
        this.device = device2;
        this.log = log2;
        this.rollouts = rolloutsState;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return this.type;
    }

    public CrashlyticsReport.Session.Event.Application getApp() {
        return this.app;
    }

    public CrashlyticsReport.Session.Event.Device getDevice() {
        return this.device;
    }

    public CrashlyticsReport.Session.Event.Log getLog() {
        return this.log;
    }

    public CrashlyticsReport.Session.Event.RolloutsState getRollouts() {
        return this.rollouts;
    }

    public String toString() {
        return "Event{timestamp=" + this.timestamp + ", type=" + this.type + ", app=" + this.app + ", device=" + this.device + ", log=" + this.log + ", rollouts=" + this.rollouts + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        r1 = r7.log;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        r1 = r7.rollouts;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
            r2 = 0
            if (r1 == 0) goto L_0x0064
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event r8 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event) r8
            long r3 = r7.timestamp
            long r5 = r8.getTimestamp()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0064
            java.lang.String r1 = r7.type
            java.lang.String r3 = r8.getType()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0064
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application r1 = r7.app
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application r3 = r8.getApp()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0064
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device r1 = r7.device
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device r3 = r8.getDevice()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0064
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log r1 = r7.log
            if (r1 != 0) goto L_0x0044
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log r1 = r8.getLog()
            if (r1 != 0) goto L_0x0064
            goto L_0x004e
        L_0x0044:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log r3 = r8.getLog()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0064
        L_0x004e:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$RolloutsState r1 = r7.rollouts
            if (r1 != 0) goto L_0x0059
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$RolloutsState r8 = r8.getRollouts()
            if (r8 != 0) goto L_0x0064
            goto L_0x0063
        L_0x0059:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$RolloutsState r8 = r8.getRollouts()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0064
        L_0x0063:
            return r0
        L_0x0064:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long j = this.timestamp;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.app.hashCode()) * 1000003) ^ this.device.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log2 = this.log;
        int i = 0;
        int hashCode2 = (hashCode ^ (log2 == null ? 0 : log2.hashCode())) * 1000003;
        CrashlyticsReport.Session.Event.RolloutsState rolloutsState = this.rollouts;
        if (rolloutsState != null) {
            i = rolloutsState.hashCode();
        }
        return hashCode2 ^ i;
    }

    public CrashlyticsReport.Session.Event.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CrashlyticsReport.Session.Event.Builder {
        private CrashlyticsReport.Session.Event.Application app;
        private CrashlyticsReport.Session.Event.Device device;
        private CrashlyticsReport.Session.Event.Log log;
        private CrashlyticsReport.Session.Event.RolloutsState rollouts;
        private byte set$0;
        private long timestamp;
        private String type;

        Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event event) {
            this.timestamp = event.getTimestamp();
            this.type = event.getType();
            this.app = event.getApp();
            this.device = event.getDevice();
            this.log = event.getLog();
            this.rollouts = event.getRollouts();
            this.set$0 = 1;
        }

        public CrashlyticsReport.Session.Event.Builder setTimestamp(long j) {
            this.timestamp = j;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder setType(String str) {
            if (str != null) {
                this.type = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        public CrashlyticsReport.Session.Event.Builder setApp(CrashlyticsReport.Session.Event.Application application) {
            if (application != null) {
                this.app = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Event.Builder setDevice(CrashlyticsReport.Session.Event.Device device2) {
            if (device2 != null) {
                this.device = device2;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        public CrashlyticsReport.Session.Event.Builder setLog(CrashlyticsReport.Session.Event.Log log2) {
            this.log = log2;
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder setRollouts(CrashlyticsReport.Session.Event.RolloutsState rolloutsState) {
            this.rollouts = rolloutsState;
            return this;
        }

        public CrashlyticsReport.Session.Event build() {
            if (this.set$0 == 1 && this.type != null && this.app != null && this.device != null) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.timestamp, this.type, this.app, this.device, this.log, this.rollouts);
            }
            StringBuilder sb = new StringBuilder();
            if ((1 & this.set$0) == 0) {
                sb.append(" timestamp");
            }
            if (this.type == null) {
                sb.append(" type");
            }
            if (this.app == null) {
                sb.append(" app");
            }
            if (this.device == null) {
                sb.append(" device");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }
    }
}
