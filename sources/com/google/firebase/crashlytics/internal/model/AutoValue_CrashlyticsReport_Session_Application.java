package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Application extends CrashlyticsReport.Session.Application {
    private final String developmentPlatform;
    private final String developmentPlatformVersion;
    private final String displayVersion;
    private final String identifier;
    private final String installationUuid;
    private final CrashlyticsReport.Session.Application.Organization organization;
    private final String version;

    private AutoValue_CrashlyticsReport_Session_Application(String str, String str2, String str3, CrashlyticsReport.Session.Application.Organization organization2, String str4, String str5, String str6) {
        this.identifier = str;
        this.version = str2;
        this.displayVersion = str3;
        this.organization = organization2;
        this.installationUuid = str4;
        this.developmentPlatform = str5;
        this.developmentPlatformVersion = str6;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getVersion() {
        return this.version;
    }

    public String getDisplayVersion() {
        return this.displayVersion;
    }

    public CrashlyticsReport.Session.Application.Organization getOrganization() {
        return this.organization;
    }

    public String getInstallationUuid() {
        return this.installationUuid;
    }

    public String getDevelopmentPlatform() {
        return this.developmentPlatform;
    }

    public String getDevelopmentPlatformVersion() {
        return this.developmentPlatformVersion;
    }

    public String toString() {
        return "Application{identifier=" + this.identifier + ", version=" + this.version + ", displayVersion=" + this.displayVersion + ", organization=" + this.organization + ", installationUuid=" + this.installationUuid + ", developmentPlatform=" + this.developmentPlatform + ", developmentPlatformVersion=" + this.developmentPlatformVersion + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r1 = r4.organization;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r1 = r4.installationUuid;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        r1 = r4.developmentPlatform;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        r1 = r4.developmentPlatformVersion;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r1 = r4.displayVersion;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
            r2 = 0
            if (r1 == 0) goto L_0x008d
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application) r5
            java.lang.String r1 = r4.identifier
            java.lang.String r3 = r5.getIdentifier()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008d
            java.lang.String r1 = r4.version
            java.lang.String r3 = r5.getVersion()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008d
            java.lang.String r1 = r4.displayVersion
            if (r1 != 0) goto L_0x002e
            java.lang.String r1 = r5.getDisplayVersion()
            if (r1 != 0) goto L_0x008d
            goto L_0x0038
        L_0x002e:
            java.lang.String r3 = r5.getDisplayVersion()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008d
        L_0x0038:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization r1 = r4.organization
            if (r1 != 0) goto L_0x0043
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization r1 = r5.getOrganization()
            if (r1 != 0) goto L_0x008d
            goto L_0x004d
        L_0x0043:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization r3 = r5.getOrganization()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008d
        L_0x004d:
            java.lang.String r1 = r4.installationUuid
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = r5.getInstallationUuid()
            if (r1 != 0) goto L_0x008d
            goto L_0x0062
        L_0x0058:
            java.lang.String r3 = r5.getInstallationUuid()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008d
        L_0x0062:
            java.lang.String r1 = r4.developmentPlatform
            if (r1 != 0) goto L_0x006d
            java.lang.String r1 = r5.getDevelopmentPlatform()
            if (r1 != 0) goto L_0x008d
            goto L_0x0077
        L_0x006d:
            java.lang.String r3 = r5.getDevelopmentPlatform()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008d
        L_0x0077:
            java.lang.String r1 = r4.developmentPlatformVersion
            if (r1 != 0) goto L_0x0082
            java.lang.String r5 = r5.getDevelopmentPlatformVersion()
            if (r5 != 0) goto L_0x008d
            goto L_0x008c
        L_0x0082:
            java.lang.String r5 = r5.getDevelopmentPlatformVersion()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x008d
        L_0x008c:
            return r0
        L_0x008d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (((this.identifier.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode()) * 1000003;
        String str = this.displayVersion;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        CrashlyticsReport.Session.Application.Organization organization2 = this.organization;
        int hashCode3 = (hashCode2 ^ (organization2 == null ? 0 : organization2.hashCode())) * 1000003;
        String str2 = this.installationUuid;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.developmentPlatform;
        int hashCode5 = (hashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.developmentPlatformVersion;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 ^ i;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Session.Application.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CrashlyticsReport.Session.Application.Builder {
        private String developmentPlatform;
        private String developmentPlatformVersion;
        private String displayVersion;
        private String identifier;
        private String installationUuid;
        private CrashlyticsReport.Session.Application.Organization organization;
        private String version;

        Builder() {
        }

        private Builder(CrashlyticsReport.Session.Application application) {
            this.identifier = application.getIdentifier();
            this.version = application.getVersion();
            this.displayVersion = application.getDisplayVersion();
            this.organization = application.getOrganization();
            this.installationUuid = application.getInstallationUuid();
            this.developmentPlatform = application.getDevelopmentPlatform();
            this.developmentPlatformVersion = application.getDevelopmentPlatformVersion();
        }

        public CrashlyticsReport.Session.Application.Builder setIdentifier(String str) {
            if (str != null) {
                this.identifier = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Application.Builder setVersion(String str) {
            if (str != null) {
                this.version = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }

        public CrashlyticsReport.Session.Application.Builder setDisplayVersion(String str) {
            this.displayVersion = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setOrganization(CrashlyticsReport.Session.Application.Organization organization2) {
            this.organization = organization2;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setInstallationUuid(String str) {
            this.installationUuid = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setDevelopmentPlatform(String str) {
            this.developmentPlatform = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setDevelopmentPlatformVersion(String str) {
            this.developmentPlatformVersion = str;
            return this;
        }

        public CrashlyticsReport.Session.Application build() {
            if (this.identifier != null && this.version != null) {
                return new AutoValue_CrashlyticsReport_Session_Application(this.identifier, this.version, this.displayVersion, this.organization, this.installationUuid, this.developmentPlatform, this.developmentPlatformVersion);
            }
            StringBuilder sb = new StringBuilder();
            if (this.identifier == null) {
                sb.append(" identifier");
            }
            if (this.version == null) {
                sb.append(" version");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }
    }
}
