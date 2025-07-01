package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

final class AutoValue_CrashlyticsReport_FilesPayload extends CrashlyticsReport.FilesPayload {
    private final List<CrashlyticsReport.FilesPayload.File> files;
    private final String orgId;

    private AutoValue_CrashlyticsReport_FilesPayload(List<CrashlyticsReport.FilesPayload.File> list, String str) {
        this.files = list;
        this.orgId = str;
    }

    public List<CrashlyticsReport.FilesPayload.File> getFiles() {
        return this.files;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public String toString() {
        return "FilesPayload{files=" + this.files + ", orgId=" + this.orgId + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.orgId;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
            r2 = 0
            if (r1 == 0) goto L_0x002d
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload) r5
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File> r1 = r4.files
            java.util.List r3 = r5.getFiles()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = r4.orgId
            if (r1 != 0) goto L_0x0022
            java.lang.String r5 = r5.getOrgId()
            if (r5 != 0) goto L_0x002d
            goto L_0x002c
        L_0x0022:
            java.lang.String r5 = r5.getOrgId()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x002d
        L_0x002c:
            return r0
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (this.files.hashCode() ^ 1000003) * 1000003;
        String str = this.orgId;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    /* access modifiers changed from: package-private */
    public CrashlyticsReport.FilesPayload.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CrashlyticsReport.FilesPayload.Builder {
        private List<CrashlyticsReport.FilesPayload.File> files;
        private String orgId;

        Builder() {
        }

        private Builder(CrashlyticsReport.FilesPayload filesPayload) {
            this.files = filesPayload.getFiles();
            this.orgId = filesPayload.getOrgId();
        }

        public CrashlyticsReport.FilesPayload.Builder setFiles(List<CrashlyticsReport.FilesPayload.File> list) {
            if (list != null) {
                this.files = list;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        public CrashlyticsReport.FilesPayload.Builder setOrgId(String str) {
            this.orgId = str;
            return this;
        }

        public CrashlyticsReport.FilesPayload build() {
            if (this.files != null) {
                return new AutoValue_CrashlyticsReport_FilesPayload(this.files, this.orgId);
            }
            throw new IllegalStateException("Missing required properties: files");
        }
    }
}
