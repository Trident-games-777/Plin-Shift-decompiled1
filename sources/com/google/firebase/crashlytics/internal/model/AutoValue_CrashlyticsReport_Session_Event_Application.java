package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.Session.Event.Application {
    private final List<CrashlyticsReport.Session.Event.Application.ProcessDetails> appProcessDetails;
    private final Boolean background;
    private final CrashlyticsReport.Session.Event.Application.ProcessDetails currentProcessDetails;
    private final List<CrashlyticsReport.CustomAttribute> customAttributes;
    private final CrashlyticsReport.Session.Event.Application.Execution execution;
    private final List<CrashlyticsReport.CustomAttribute> internalKeys;
    private final int uiOrientation;

    private AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution execution2, List<CrashlyticsReport.CustomAttribute> list, List<CrashlyticsReport.CustomAttribute> list2, Boolean bool, CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails, List<CrashlyticsReport.Session.Event.Application.ProcessDetails> list3, int i) {
        this.execution = execution2;
        this.customAttributes = list;
        this.internalKeys = list2;
        this.background = bool;
        this.currentProcessDetails = processDetails;
        this.appProcessDetails = list3;
        this.uiOrientation = i;
    }

    public CrashlyticsReport.Session.Event.Application.Execution getExecution() {
        return this.execution;
    }

    public List<CrashlyticsReport.CustomAttribute> getCustomAttributes() {
        return this.customAttributes;
    }

    public List<CrashlyticsReport.CustomAttribute> getInternalKeys() {
        return this.internalKeys;
    }

    public Boolean getBackground() {
        return this.background;
    }

    public CrashlyticsReport.Session.Event.Application.ProcessDetails getCurrentProcessDetails() {
        return this.currentProcessDetails;
    }

    public List<CrashlyticsReport.Session.Event.Application.ProcessDetails> getAppProcessDetails() {
        return this.appProcessDetails;
    }

    public int getUiOrientation() {
        return this.uiOrientation;
    }

    public String toString() {
        return "Application{execution=" + this.execution + ", customAttributes=" + this.customAttributes + ", internalKeys=" + this.internalKeys + ", background=" + this.background + ", currentProcessDetails=" + this.currentProcessDetails + ", appProcessDetails=" + this.appProcessDetails + ", uiOrientation=" + this.uiOrientation + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r1 = r4.internalKeys;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        r1 = r4.background;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r1 = r4.currentProcessDetails;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
        r1 = r4.appProcessDetails;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.customAttributes;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
            r2 = 0
            if (r1 == 0) goto L_0x0089
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application) r5
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution r1 = r4.execution
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution r3 = r5.getExecution()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute> r1 = r4.customAttributes
            if (r1 != 0) goto L_0x0022
            java.util.List r1 = r5.getCustomAttributes()
            if (r1 != 0) goto L_0x0089
            goto L_0x002c
        L_0x0022:
            java.util.List r3 = r5.getCustomAttributes()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x002c:
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute> r1 = r4.internalKeys
            if (r1 != 0) goto L_0x0037
            java.util.List r1 = r5.getInternalKeys()
            if (r1 != 0) goto L_0x0089
            goto L_0x0041
        L_0x0037:
            java.util.List r3 = r5.getInternalKeys()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x0041:
            java.lang.Boolean r1 = r4.background
            if (r1 != 0) goto L_0x004c
            java.lang.Boolean r1 = r5.getBackground()
            if (r1 != 0) goto L_0x0089
            goto L_0x0056
        L_0x004c:
            java.lang.Boolean r3 = r5.getBackground()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x0056:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$ProcessDetails r1 = r4.currentProcessDetails
            if (r1 != 0) goto L_0x0061
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$ProcessDetails r1 = r5.getCurrentProcessDetails()
            if (r1 != 0) goto L_0x0089
            goto L_0x006b
        L_0x0061:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$ProcessDetails r3 = r5.getCurrentProcessDetails()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x006b:
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$ProcessDetails> r1 = r4.appProcessDetails
            if (r1 != 0) goto L_0x0076
            java.util.List r1 = r5.getAppProcessDetails()
            if (r1 != 0) goto L_0x0089
            goto L_0x0080
        L_0x0076:
            java.util.List r3 = r5.getAppProcessDetails()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x0080:
            int r1 = r4.uiOrientation
            int r5 = r5.getUiOrientation()
            if (r1 != r5) goto L_0x0089
            return r0
        L_0x0089:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (this.execution.hashCode() ^ 1000003) * 1000003;
        List<CrashlyticsReport.CustomAttribute> list = this.customAttributes;
        int i = 0;
        int hashCode2 = (hashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<CrashlyticsReport.CustomAttribute> list2 = this.internalKeys;
        int hashCode3 = (hashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.background;
        int hashCode4 = (hashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = this.currentProcessDetails;
        int hashCode5 = (hashCode4 ^ (processDetails == null ? 0 : processDetails.hashCode())) * 1000003;
        List<CrashlyticsReport.Session.Event.Application.ProcessDetails> list3 = this.appProcessDetails;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return ((hashCode5 ^ i) * 1000003) ^ this.uiOrientation;
    }

    public CrashlyticsReport.Session.Event.Application.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Builder {
        private List<CrashlyticsReport.Session.Event.Application.ProcessDetails> appProcessDetails;
        private Boolean background;
        private CrashlyticsReport.Session.Event.Application.ProcessDetails currentProcessDetails;
        private List<CrashlyticsReport.CustomAttribute> customAttributes;
        private CrashlyticsReport.Session.Event.Application.Execution execution;
        private List<CrashlyticsReport.CustomAttribute> internalKeys;
        private byte set$0;
        private int uiOrientation;

        Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event.Application application) {
            this.execution = application.getExecution();
            this.customAttributes = application.getCustomAttributes();
            this.internalKeys = application.getInternalKeys();
            this.background = application.getBackground();
            this.currentProcessDetails = application.getCurrentProcessDetails();
            this.appProcessDetails = application.getAppProcessDetails();
            this.uiOrientation = application.getUiOrientation();
            this.set$0 = 1;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setExecution(CrashlyticsReport.Session.Event.Application.Execution execution2) {
            if (execution2 != null) {
                this.execution = execution2;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        public CrashlyticsReport.Session.Event.Application.Builder setCustomAttributes(List<CrashlyticsReport.CustomAttribute> list) {
            this.customAttributes = list;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setInternalKeys(List<CrashlyticsReport.CustomAttribute> list) {
            this.internalKeys = list;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setBackground(Boolean bool) {
            this.background = bool;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setCurrentProcessDetails(CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails) {
            this.currentProcessDetails = processDetails;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setAppProcessDetails(List<CrashlyticsReport.Session.Event.Application.ProcessDetails> list) {
            this.appProcessDetails = list;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setUiOrientation(int i) {
            this.uiOrientation = i;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application build() {
            if (this.set$0 == 1 && this.execution != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(this.execution, this.customAttributes, this.internalKeys, this.background, this.currentProcessDetails, this.appProcessDetails, this.uiOrientation);
            }
            StringBuilder sb = new StringBuilder();
            if (this.execution == null) {
                sb.append(" execution");
            }
            if ((1 & this.set$0) == 0) {
                sb.append(" uiOrientation");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }
    }
}
