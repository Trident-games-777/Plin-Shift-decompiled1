package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {
    private final CrashlyticsReport.Session.Application app;
    private final String appQualitySessionId;
    private final boolean crashed;
    private final CrashlyticsReport.Session.Device device;
    private final Long endedAt;
    private final List<CrashlyticsReport.Session.Event> events;
    private final String generator;
    private final int generatorType;
    private final String identifier;
    private final CrashlyticsReport.Session.OperatingSystem os;
    private final long startedAt;
    private final CrashlyticsReport.Session.User user;

    private AutoValue_CrashlyticsReport_Session(String str, String str2, String str3, long j, Long l, boolean z, CrashlyticsReport.Session.Application application, CrashlyticsReport.Session.User user2, CrashlyticsReport.Session.OperatingSystem operatingSystem, CrashlyticsReport.Session.Device device2, List<CrashlyticsReport.Session.Event> list, int i) {
        this.generator = str;
        this.identifier = str2;
        this.appQualitySessionId = str3;
        this.startedAt = j;
        this.endedAt = l;
        this.crashed = z;
        this.app = application;
        this.user = user2;
        this.os = operatingSystem;
        this.device = device2;
        this.events = list;
        this.generatorType = i;
    }

    public String getGenerator() {
        return this.generator;
    }

    @Encodable.Ignore
    public String getIdentifier() {
        return this.identifier;
    }

    public String getAppQualitySessionId() {
        return this.appQualitySessionId;
    }

    public long getStartedAt() {
        return this.startedAt;
    }

    public Long getEndedAt() {
        return this.endedAt;
    }

    public boolean isCrashed() {
        return this.crashed;
    }

    public CrashlyticsReport.Session.Application getApp() {
        return this.app;
    }

    public CrashlyticsReport.Session.User getUser() {
        return this.user;
    }

    public CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.os;
    }

    public CrashlyticsReport.Session.Device getDevice() {
        return this.device;
    }

    public List<CrashlyticsReport.Session.Event> getEvents() {
        return this.events;
    }

    public int getGeneratorType() {
        return this.generatorType;
    }

    public String toString() {
        return "Session{generator=" + this.generator + ", identifier=" + this.identifier + ", appQualitySessionId=" + this.appQualitySessionId + ", startedAt=" + this.startedAt + ", endedAt=" + this.endedAt + ", crashed=" + this.crashed + ", app=" + this.app + ", user=" + this.user + ", os=" + this.os + ", device=" + this.device + ", events=" + this.events + ", generatorType=" + this.generatorType + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        r1 = r7.endedAt;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        r1 = r7.user;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
        r1 = r7.os;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        r1 = r7.device;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00aa, code lost:
        r1 = r7.events;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r1 = r7.appQualitySessionId;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
            r2 = 0
            if (r1 == 0) goto L_0x00c8
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r8 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session) r8
            java.lang.String r1 = r7.generator
            java.lang.String r3 = r8.getGenerator()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
            java.lang.String r1 = r7.identifier
            java.lang.String r3 = r8.getIdentifier()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
            java.lang.String r1 = r7.appQualitySessionId
            if (r1 != 0) goto L_0x002e
            java.lang.String r1 = r8.getAppQualitySessionId()
            if (r1 != 0) goto L_0x00c8
            goto L_0x0038
        L_0x002e:
            java.lang.String r3 = r8.getAppQualitySessionId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x0038:
            long r3 = r7.startedAt
            long r5 = r8.getStartedAt()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00c8
            java.lang.Long r1 = r7.endedAt
            if (r1 != 0) goto L_0x004d
            java.lang.Long r1 = r8.getEndedAt()
            if (r1 != 0) goto L_0x00c8
            goto L_0x0057
        L_0x004d:
            java.lang.Long r3 = r8.getEndedAt()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x0057:
            boolean r1 = r7.crashed
            boolean r3 = r8.isCrashed()
            if (r1 != r3) goto L_0x00c8
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application r1 = r7.app
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application r3 = r8.getApp()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r1 = r7.user
            if (r1 != 0) goto L_0x0076
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r1 = r8.getUser()
            if (r1 != 0) goto L_0x00c8
            goto L_0x0080
        L_0x0076:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r3 = r8.getUser()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x0080:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r1 = r7.os
            if (r1 != 0) goto L_0x008b
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r1 = r8.getOs()
            if (r1 != 0) goto L_0x00c8
            goto L_0x0095
        L_0x008b:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r3 = r8.getOs()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x0095:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r1 = r7.device
            if (r1 != 0) goto L_0x00a0
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r1 = r8.getDevice()
            if (r1 != 0) goto L_0x00c8
            goto L_0x00aa
        L_0x00a0:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r3 = r8.getDevice()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x00aa:
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event> r1 = r7.events
            if (r1 != 0) goto L_0x00b5
            java.util.List r1 = r8.getEvents()
            if (r1 != 0) goto L_0x00c8
            goto L_0x00bf
        L_0x00b5:
            java.util.List r3 = r8.getEvents()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x00bf:
            int r1 = r7.generatorType
            int r8 = r8.getGeneratorType()
            if (r1 != r8) goto L_0x00c8
            return r0
        L_0x00c8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (((this.generator.hashCode() ^ 1000003) * 1000003) ^ this.identifier.hashCode()) * 1000003;
        String str = this.appQualitySessionId;
        int i = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j = this.startedAt;
        int i2 = (((hashCode ^ hashCode2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.endedAt;
        int hashCode3 = (((((i2 ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.crashed ? 1231 : 1237)) * 1000003) ^ this.app.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user2 = this.user;
        int hashCode4 = (hashCode3 ^ (user2 == null ? 0 : user2.hashCode())) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.os;
        int hashCode5 = (hashCode4 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        CrashlyticsReport.Session.Device device2 = this.device;
        int hashCode6 = (hashCode5 ^ (device2 == null ? 0 : device2.hashCode())) * 1000003;
        List<CrashlyticsReport.Session.Event> list = this.events;
        if (list != null) {
            i = list.hashCode();
        }
        return ((hashCode6 ^ i) * 1000003) ^ this.generatorType;
    }

    public CrashlyticsReport.Session.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CrashlyticsReport.Session.Builder {
        private CrashlyticsReport.Session.Application app;
        private String appQualitySessionId;
        private boolean crashed;
        private CrashlyticsReport.Session.Device device;
        private Long endedAt;
        private List<CrashlyticsReport.Session.Event> events;
        private String generator;
        private int generatorType;
        private String identifier;
        private CrashlyticsReport.Session.OperatingSystem os;
        private byte set$0;
        private long startedAt;
        private CrashlyticsReport.Session.User user;

        Builder() {
        }

        private Builder(CrashlyticsReport.Session session) {
            this.generator = session.getGenerator();
            this.identifier = session.getIdentifier();
            this.appQualitySessionId = session.getAppQualitySessionId();
            this.startedAt = session.getStartedAt();
            this.endedAt = session.getEndedAt();
            this.crashed = session.isCrashed();
            this.app = session.getApp();
            this.user = session.getUser();
            this.os = session.getOs();
            this.device = session.getDevice();
            this.events = session.getEvents();
            this.generatorType = session.getGeneratorType();
            this.set$0 = 7;
        }

        public CrashlyticsReport.Session.Builder setGenerator(String str) {
            if (str != null) {
                this.generator = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public CrashlyticsReport.Session.Builder setIdentifier(String str) {
            if (str != null) {
                this.identifier = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Builder setAppQualitySessionId(String str) {
            this.appQualitySessionId = str;
            return this;
        }

        public CrashlyticsReport.Session.Builder setStartedAt(long j) {
            this.startedAt = j;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        public CrashlyticsReport.Session.Builder setEndedAt(Long l) {
            this.endedAt = l;
            return this;
        }

        public CrashlyticsReport.Session.Builder setCrashed(boolean z) {
            this.crashed = z;
            this.set$0 = (byte) (this.set$0 | 2);
            return this;
        }

        public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application application) {
            if (application != null) {
                this.app = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User user2) {
            this.user = user2;
            return this;
        }

        public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.os = operatingSystem;
            return this;
        }

        public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device device2) {
            this.device = device2;
            return this;
        }

        public CrashlyticsReport.Session.Builder setEvents(List<CrashlyticsReport.Session.Event> list) {
            this.events = list;
            return this;
        }

        public CrashlyticsReport.Session.Builder setGeneratorType(int i) {
            this.generatorType = i;
            this.set$0 = (byte) (this.set$0 | 4);
            return this;
        }

        public CrashlyticsReport.Session build() {
            if (this.set$0 == 7 && this.generator != null && this.identifier != null && this.app != null) {
                return new AutoValue_CrashlyticsReport_Session(this.generator, this.identifier, this.appQualitySessionId, this.startedAt, this.endedAt, this.crashed, this.app, this.user, this.os, this.device, this.events, this.generatorType);
            }
            StringBuilder sb = new StringBuilder();
            if (this.generator == null) {
                sb.append(" generator");
            }
            if (this.identifier == null) {
                sb.append(" identifier");
            }
            if ((this.set$0 & 1) == 0) {
                sb.append(" startedAt");
            }
            if ((this.set$0 & 2) == 0) {
                sb.append(" crashed");
            }
            if (this.app == null) {
                sb.append(" app");
            }
            if ((this.set$0 & 4) == 0) {
                sb.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }
    }
}
