package com.google.firebase.crashlytics.internal.model;

import com.google.common.base.Ascii;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {
    private final List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> buildIdMappingForArch;
    private final int importance;
    private final int pid;
    private final String processName;
    private final long pss;
    private final int reasonCode;
    private final long rss;
    private final long timestamp;
    private final String traceFile;

    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i, String str, int i2, int i3, long j, long j2, long j3, String str2, List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list) {
        this.pid = i;
        this.processName = str;
        this.reasonCode = i2;
        this.importance = i3;
        this.pss = j;
        this.rss = j2;
        this.timestamp = j3;
        this.traceFile = str2;
        this.buildIdMappingForArch = list;
    }

    public int getPid() {
        return this.pid;
    }

    public String getProcessName() {
        return this.processName;
    }

    public int getReasonCode() {
        return this.reasonCode;
    }

    public int getImportance() {
        return this.importance;
    }

    public long getPss() {
        return this.pss;
    }

    public long getRss() {
        return this.rss;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTraceFile() {
        return this.traceFile;
    }

    public List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> getBuildIdMappingForArch() {
        return this.buildIdMappingForArch;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.pid + ", processName=" + this.processName + ", reasonCode=" + this.reasonCode + ", importance=" + this.importance + ", pss=" + this.pss + ", rss=" + this.rss + ", timestamp=" + this.timestamp + ", traceFile=" + this.traceFile + ", buildIdMappingForArch=" + this.buildIdMappingForArch + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        r1 = r7.traceFile;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        r1 = r7.buildIdMappingForArch;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
            r2 = 0
            if (r1 == 0) goto L_0x0078
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo r8 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo) r8
            int r1 = r7.pid
            int r3 = r8.getPid()
            if (r1 != r3) goto L_0x0078
            java.lang.String r1 = r7.processName
            java.lang.String r3 = r8.getProcessName()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0078
            int r1 = r7.reasonCode
            int r3 = r8.getReasonCode()
            if (r1 != r3) goto L_0x0078
            int r1 = r7.importance
            int r3 = r8.getImportance()
            if (r1 != r3) goto L_0x0078
            long r3 = r7.pss
            long r5 = r8.getPss()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0078
            long r3 = r7.rss
            long r5 = r8.getRss()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0078
            long r3 = r7.timestamp
            long r5 = r8.getTimestamp()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0078
            java.lang.String r1 = r7.traceFile
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = r8.getTraceFile()
            if (r1 != 0) goto L_0x0078
            goto L_0x0062
        L_0x0058:
            java.lang.String r3 = r8.getTraceFile()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0078
        L_0x0062:
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$BuildIdMappingForArch> r1 = r7.buildIdMappingForArch
            if (r1 != 0) goto L_0x006d
            java.util.List r8 = r8.getBuildIdMappingForArch()
            if (r8 != 0) goto L_0x0078
            goto L_0x0077
        L_0x006d:
            java.util.List r8 = r8.getBuildIdMappingForArch()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0078
        L_0x0077:
            return r0
        L_0x0078:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long j = this.pss;
        long j2 = this.rss;
        long j3 = this.timestamp;
        int hashCode = (((((((((((((this.pid ^ 1000003) * 1000003) ^ this.processName.hashCode()) * 1000003) ^ this.reasonCode) * 1000003) ^ this.importance) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str = this.traceFile;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list = this.buildIdMappingForArch;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 ^ i;
    }

    static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {
        private List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> buildIdMappingForArch;
        private int importance;
        private int pid;
        private String processName;
        private long pss;
        private int reasonCode;
        private long rss;
        private byte set$0;
        private long timestamp;
        private String traceFile;

        Builder() {
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setPid(int i) {
            this.pid = i;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setProcessName(String str) {
            if (str != null) {
                this.processName = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setReasonCode(int i) {
            this.reasonCode = i;
            this.set$0 = (byte) (this.set$0 | 2);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setImportance(int i) {
            this.importance = i;
            this.set$0 = (byte) (this.set$0 | 4);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setPss(long j) {
            this.pss = j;
            this.set$0 = (byte) (this.set$0 | 8);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setRss(long j) {
            this.rss = j;
            this.set$0 = (byte) (this.set$0 | Ascii.DLE);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setTimestamp(long j) {
            this.timestamp = j;
            this.set$0 = (byte) (this.set$0 | 32);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setTraceFile(String str) {
            this.traceFile = str;
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setBuildIdMappingForArch(List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list) {
            this.buildIdMappingForArch = list;
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo build() {
            if (this.set$0 == 63 && this.processName != null) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.pid, this.processName, this.reasonCode, this.importance, this.pss, this.rss, this.timestamp, this.traceFile, this.buildIdMappingForArch);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.set$0 & 1) == 0) {
                sb.append(" pid");
            }
            if (this.processName == null) {
                sb.append(" processName");
            }
            if ((this.set$0 & 2) == 0) {
                sb.append(" reasonCode");
            }
            if ((this.set$0 & 4) == 0) {
                sb.append(" importance");
            }
            if ((this.set$0 & 8) == 0) {
                sb.append(" pss");
            }
            if ((this.set$0 & Ascii.DLE) == 0) {
                sb.append(" rss");
            }
            if ((this.set$0 & 32) == 0) {
                sb.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }
    }
}
