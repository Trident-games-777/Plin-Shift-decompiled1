package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

final class AutoValue_InstallIdProvider_InstallIds extends InstallIdProvider.InstallIds {
    private final String crashlyticsInstallId;
    private final String firebaseAuthenticationToken;
    private final String firebaseInstallationId;

    AutoValue_InstallIdProvider_InstallIds(String str, String str2, String str3) {
        if (str != null) {
            this.crashlyticsInstallId = str;
            this.firebaseInstallationId = str2;
            this.firebaseAuthenticationToken = str3;
            return;
        }
        throw new NullPointerException("Null crashlyticsInstallId");
    }

    public String getCrashlyticsInstallId() {
        return this.crashlyticsInstallId;
    }

    public String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    public String getFirebaseAuthenticationToken() {
        return this.firebaseAuthenticationToken;
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.crashlyticsInstallId + ", firebaseInstallationId=" + this.firebaseInstallationId + ", firebaseAuthenticationToken=" + this.firebaseAuthenticationToken + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r1 = r4.firebaseAuthenticationToken;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.firebaseInstallationId;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds
            r2 = 0
            if (r1 == 0) goto L_0x0042
            com.google.firebase.crashlytics.internal.common.InstallIdProvider$InstallIds r5 = (com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds) r5
            java.lang.String r1 = r4.crashlyticsInstallId
            java.lang.String r3 = r5.getCrashlyticsInstallId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0042
            java.lang.String r1 = r4.firebaseInstallationId
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = r5.getFirebaseInstallationId()
            if (r1 != 0) goto L_0x0042
            goto L_0x002c
        L_0x0022:
            java.lang.String r3 = r5.getFirebaseInstallationId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0042
        L_0x002c:
            java.lang.String r1 = r4.firebaseAuthenticationToken
            if (r1 != 0) goto L_0x0037
            java.lang.String r5 = r5.getFirebaseAuthenticationToken()
            if (r5 != 0) goto L_0x0042
            goto L_0x0041
        L_0x0037:
            java.lang.String r5 = r5.getFirebaseAuthenticationToken()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0042
        L_0x0041:
            return r0
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.AutoValue_InstallIdProvider_InstallIds.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (this.crashlyticsInstallId.hashCode() ^ 1000003) * 1000003;
        String str = this.firebaseInstallationId;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.firebaseAuthenticationToken;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 ^ i;
    }
}
