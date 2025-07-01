package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport extends CrashlyticsReport {
    private final CrashlyticsReport.ApplicationExitInfo appExitInfo;
    private final String appQualitySessionId;
    private final String buildVersion;
    private final String displayVersion;
    private final String firebaseAuthenticationToken;
    private final String firebaseInstallationId;
    private final String gmpAppId;
    private final String installationUuid;
    private final CrashlyticsReport.FilesPayload ndkPayload;
    private final int platform;
    private final String sdkVersion;
    private final CrashlyticsReport.Session session;

    private AutoValue_CrashlyticsReport(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, CrashlyticsReport.Session session2, CrashlyticsReport.FilesPayload filesPayload, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        this.sdkVersion = str;
        this.gmpAppId = str2;
        this.platform = i;
        this.installationUuid = str3;
        this.firebaseInstallationId = str4;
        this.firebaseAuthenticationToken = str5;
        this.appQualitySessionId = str6;
        this.buildVersion = str7;
        this.displayVersion = str8;
        this.session = session2;
        this.ndkPayload = filesPayload;
        this.appExitInfo = applicationExitInfo;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getGmpAppId() {
        return this.gmpAppId;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getInstallationUuid() {
        return this.installationUuid;
    }

    public String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    public String getFirebaseAuthenticationToken() {
        return this.firebaseAuthenticationToken;
    }

    public String getAppQualitySessionId() {
        return this.appQualitySessionId;
    }

    public String getBuildVersion() {
        return this.buildVersion;
    }

    public String getDisplayVersion() {
        return this.displayVersion;
    }

    public CrashlyticsReport.Session getSession() {
        return this.session;
    }

    public CrashlyticsReport.FilesPayload getNdkPayload() {
        return this.ndkPayload;
    }

    public CrashlyticsReport.ApplicationExitInfo getAppExitInfo() {
        return this.appExitInfo;
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.sdkVersion + ", gmpAppId=" + this.gmpAppId + ", platform=" + this.platform + ", installationUuid=" + this.installationUuid + ", firebaseInstallationId=" + this.firebaseInstallationId + ", firebaseAuthenticationToken=" + this.firebaseAuthenticationToken + ", appQualitySessionId=" + this.appQualitySessionId + ", buildVersion=" + this.buildVersion + ", displayVersion=" + this.displayVersion + ", session=" + this.session + ", ndkPayload=" + this.ndkPayload + ", appExitInfo=" + this.appExitInfo + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r1 = r4.firebaseInstallationId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        r1 = r4.firebaseAuthenticationToken;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        r1 = r4.appQualitySessionId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008e, code lost:
        r1 = r4.session;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a3, code lost:
        r1 = r4.ndkPayload;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b8, code lost:
        r1 = r4.appExitInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport
            r2 = 0
            if (r1 == 0) goto L_0x00ce
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport) r5
            java.lang.String r1 = r4.sdkVersion
            java.lang.String r3 = r5.getSdkVersion()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
            java.lang.String r1 = r4.gmpAppId
            java.lang.String r3 = r5.getGmpAppId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
            int r1 = r4.platform
            int r3 = r5.getPlatform()
            if (r1 != r3) goto L_0x00ce
            java.lang.String r1 = r4.installationUuid
            java.lang.String r3 = r5.getInstallationUuid()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
            java.lang.String r1 = r4.firebaseInstallationId
            if (r1 != 0) goto L_0x0042
            java.lang.String r1 = r5.getFirebaseInstallationId()
            if (r1 != 0) goto L_0x00ce
            goto L_0x004c
        L_0x0042:
            java.lang.String r3 = r5.getFirebaseInstallationId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
        L_0x004c:
            java.lang.String r1 = r4.firebaseAuthenticationToken
            if (r1 != 0) goto L_0x0057
            java.lang.String r1 = r5.getFirebaseAuthenticationToken()
            if (r1 != 0) goto L_0x00ce
            goto L_0x0061
        L_0x0057:
            java.lang.String r3 = r5.getFirebaseAuthenticationToken()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
        L_0x0061:
            java.lang.String r1 = r4.appQualitySessionId
            if (r1 != 0) goto L_0x006c
            java.lang.String r1 = r5.getAppQualitySessionId()
            if (r1 != 0) goto L_0x00ce
            goto L_0x0076
        L_0x006c:
            java.lang.String r3 = r5.getAppQualitySessionId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
        L_0x0076:
            java.lang.String r1 = r4.buildVersion
            java.lang.String r3 = r5.getBuildVersion()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
            java.lang.String r1 = r4.displayVersion
            java.lang.String r3 = r5.getDisplayVersion()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r1 = r4.session
            if (r1 != 0) goto L_0x0099
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r1 = r5.getSession()
            if (r1 != 0) goto L_0x00ce
            goto L_0x00a3
        L_0x0099:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r3 = r5.getSession()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
        L_0x00a3:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload r1 = r4.ndkPayload
            if (r1 != 0) goto L_0x00ae
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload r1 = r5.getNdkPayload()
            if (r1 != 0) goto L_0x00ce
            goto L_0x00b8
        L_0x00ae:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload r3 = r5.getNdkPayload()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ce
        L_0x00b8:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo r1 = r4.appExitInfo
            if (r1 != 0) goto L_0x00c3
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo r5 = r5.getAppExitInfo()
            if (r5 != 0) goto L_0x00ce
            goto L_0x00cd
        L_0x00c3:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo r5 = r5.getAppExitInfo()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00ce
        L_0x00cd:
            return r0
        L_0x00ce:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (((((((this.sdkVersion.hashCode() ^ 1000003) * 1000003) ^ this.gmpAppId.hashCode()) * 1000003) ^ this.platform) * 1000003) ^ this.installationUuid.hashCode()) * 1000003;
        String str = this.firebaseInstallationId;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.firebaseAuthenticationToken;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.appQualitySessionId;
        int hashCode4 = (((((hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.buildVersion.hashCode()) * 1000003) ^ this.displayVersion.hashCode()) * 1000003;
        CrashlyticsReport.Session session2 = this.session;
        int hashCode5 = (hashCode4 ^ (session2 == null ? 0 : session2.hashCode())) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.ndkPayload;
        int hashCode6 = (hashCode5 ^ (filesPayload == null ? 0 : filesPayload.hashCode())) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.appExitInfo;
        if (applicationExitInfo != null) {
            i = applicationExitInfo.hashCode();
        }
        return hashCode6 ^ i;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CrashlyticsReport.Builder {
        private CrashlyticsReport.ApplicationExitInfo appExitInfo;
        private String appQualitySessionId;
        private String buildVersion;
        private String displayVersion;
        private String firebaseAuthenticationToken;
        private String firebaseInstallationId;
        private String gmpAppId;
        private String installationUuid;
        private CrashlyticsReport.FilesPayload ndkPayload;
        private int platform;
        private String sdkVersion;
        private CrashlyticsReport.Session session;
        private byte set$0;

        Builder() {
        }

        private Builder(CrashlyticsReport crashlyticsReport) {
            this.sdkVersion = crashlyticsReport.getSdkVersion();
            this.gmpAppId = crashlyticsReport.getGmpAppId();
            this.platform = crashlyticsReport.getPlatform();
            this.installationUuid = crashlyticsReport.getInstallationUuid();
            this.firebaseInstallationId = crashlyticsReport.getFirebaseInstallationId();
            this.firebaseAuthenticationToken = crashlyticsReport.getFirebaseAuthenticationToken();
            this.appQualitySessionId = crashlyticsReport.getAppQualitySessionId();
            this.buildVersion = crashlyticsReport.getBuildVersion();
            this.displayVersion = crashlyticsReport.getDisplayVersion();
            this.session = crashlyticsReport.getSession();
            this.ndkPayload = crashlyticsReport.getNdkPayload();
            this.appExitInfo = crashlyticsReport.getAppExitInfo();
            this.set$0 = 1;
        }

        public CrashlyticsReport.Builder setSdkVersion(String str) {
            if (str != null) {
                this.sdkVersion = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        public CrashlyticsReport.Builder setGmpAppId(String str) {
            if (str != null) {
                this.gmpAppId = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        public CrashlyticsReport.Builder setPlatform(int i) {
            this.platform = i;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        public CrashlyticsReport.Builder setInstallationUuid(String str) {
            if (str != null) {
                this.installationUuid = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        public CrashlyticsReport.Builder setFirebaseInstallationId(String str) {
            this.firebaseInstallationId = str;
            return this;
        }

        public CrashlyticsReport.Builder setFirebaseAuthenticationToken(String str) {
            this.firebaseAuthenticationToken = str;
            return this;
        }

        public CrashlyticsReport.Builder setAppQualitySessionId(String str) {
            this.appQualitySessionId = str;
            return this;
        }

        public CrashlyticsReport.Builder setBuildVersion(String str) {
            if (str != null) {
                this.buildVersion = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public CrashlyticsReport.Builder setDisplayVersion(String str) {
            if (str != null) {
                this.displayVersion = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        public CrashlyticsReport.Builder setSession(CrashlyticsReport.Session session2) {
            this.session = session2;
            return this;
        }

        public CrashlyticsReport.Builder setNdkPayload(CrashlyticsReport.FilesPayload filesPayload) {
            this.ndkPayload = filesPayload;
            return this;
        }

        public CrashlyticsReport.Builder setAppExitInfo(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.appExitInfo = applicationExitInfo;
            return this;
        }

        public CrashlyticsReport build() {
            if (this.set$0 == 1 && this.sdkVersion != null && this.gmpAppId != null && this.installationUuid != null && this.buildVersion != null && this.displayVersion != null) {
                return new AutoValue_CrashlyticsReport(this.sdkVersion, this.gmpAppId, this.platform, this.installationUuid, this.firebaseInstallationId, this.firebaseAuthenticationToken, this.appQualitySessionId, this.buildVersion, this.displayVersion, this.session, this.ndkPayload, this.appExitInfo);
            }
            StringBuilder sb = new StringBuilder();
            if (this.sdkVersion == null) {
                sb.append(" sdkVersion");
            }
            if (this.gmpAppId == null) {
                sb.append(" gmpAppId");
            }
            if ((1 & this.set$0) == 0) {
                sb.append(" platform");
            }
            if (this.installationUuid == null) {
                sb.append(" installationUuid");
            }
            if (this.buildVersion == null) {
                sb.append(" buildVersion");
            }
            if (this.displayVersion == null) {
                sb.append(" displayVersion");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }
    }
}
