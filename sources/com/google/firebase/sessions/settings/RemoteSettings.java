package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\r\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0015H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0011\u0010)\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010*R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Landroidx/datastore/core/DataStore;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "samplingRate", "", "getSamplingRate", "()Ljava/lang/Double;", "sessionEnabled", "", "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "settingsCache", "Lcom/google/firebase/sessions/settings/SettingsCache;", "getSettingsCache", "()Lcom/google/firebase/sessions/settings/SettingsCache;", "settingsCache$delegate", "Lkotlin/Lazy;", "clearCachedSettings", "", "clearCachedSettings$com_google_firebase_firebase_sessions", "isSettingsStale", "removeForwardSlashesIn", "", "s", "updateSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RemoteSettings.kt */
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String FORWARD_SLASH_STRING = "/";
    @Deprecated
    public static final String TAG = "SessionConfigFetcher";
    private final ApplicationInfo appInfo;
    private final CoroutineContext backgroundDispatcher;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final Mutex fetchInProgress = MutexKt.Mutex$default(false, 1, (Object) null);
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final Lazy settingsCache$delegate;

    public RemoteSettings(CoroutineContext coroutineContext, FirebaseInstallationsApi firebaseInstallationsApi2, ApplicationInfo applicationInfo, CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, DataStore<Preferences> dataStore) {
        Intrinsics.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi2, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(applicationInfo, "appInfo");
        Intrinsics.checkNotNullParameter(crashlyticsSettingsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.backgroundDispatcher = coroutineContext;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.appInfo = applicationInfo;
        this.configsFetcher = crashlyticsSettingsFetcher;
        this.settingsCache$delegate = LazyKt.lazy(new RemoteSettings$settingsCache$2(dataStore));
    }

    /* access modifiers changed from: private */
    public final SettingsCache getSettingsCache() {
        return (SettingsCache) this.settingsCache$delegate.getValue();
    }

    public Boolean getSessionEnabled() {
        return getSettingsCache().sessionsEnabled();
    }

    /* renamed from: getSessionRestartTimeout-FghU774  reason: not valid java name */
    public Duration m7767getSessionRestartTimeoutFghU774() {
        Integer sessionRestartTimeout = getSettingsCache().sessionRestartTimeout();
        if (sessionRestartTimeout == null) {
            return null;
        }
        Duration.Companion companion = Duration.Companion;
        return Duration.m9153boximpl(DurationKt.toDuration(sessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    public Double getSamplingRate() {
        return getSettingsCache().sessionSamplingRate();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093 A[Catch:{ all -> 0x0161 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009e A[SYNTHETIC, Splitter:B:38:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1 A[Catch:{ all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateSettings(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "SessionConfigFetcher"
            r4 = 3
            r5 = 1
            r6 = 2
            r7 = 0
            if (r2 == 0) goto L_0x0060
            if (r2 == r5) goto L_0x0053
            if (r2 == r6) goto L_0x0043
            if (r2 != r4) goto L_0x003b
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0038 }
            goto L_0x0159
        L_0x0038:
            r15 = move-exception
            goto L_0x0165
        L_0x003b:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0043:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r8 = r0.L$0
            com.google.firebase.sessions.settings.RemoteSettings r8 = (com.google.firebase.sessions.settings.RemoteSettings) r8
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x004f }
            goto L_0x00b3
        L_0x004f:
            r15 = move-exception
            r0 = r2
            goto L_0x0165
        L_0x0053:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r8 = r0.L$0
            com.google.firebase.sessions.settings.RemoteSettings r8 = (com.google.firebase.sessions.settings.RemoteSettings) r8
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r2
            goto L_0x0089
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlinx.coroutines.sync.Mutex r15 = r14.fetchInProgress
            boolean r15 = r15.isLocked()
            if (r15 != 0) goto L_0x0078
            com.google.firebase.sessions.settings.SettingsCache r15 = r14.getSettingsCache()
            boolean r15 = r15.hasCacheExpired$com_google_firebase_firebase_sessions()
            if (r15 != 0) goto L_0x0078
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0078:
            kotlinx.coroutines.sync.Mutex r15 = r14.fetchInProgress
            r0.L$0 = r14
            r0.L$1 = r15
            r0.label = r5
            java.lang.Object r2 = r15.lock(r7, r0)
            if (r2 != r1) goto L_0x0088
            goto L_0x0157
        L_0x0088:
            r8 = r14
        L_0x0089:
            com.google.firebase.sessions.settings.SettingsCache r2 = r8.getSettingsCache()     // Catch:{ all -> 0x0161 }
            boolean r2 = r2.hasCacheExpired$com_google_firebase_firebase_sessions()     // Catch:{ all -> 0x0161 }
            if (r2 != 0) goto L_0x009e
            java.lang.String r0 = "Remote settings cache not expired. Using cached values."
            android.util.Log.d(r3, r0)     // Catch:{ all -> 0x0161 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0161 }
            r15.unlock(r7)
            return r0
        L_0x009e:
            com.google.firebase.sessions.InstallationId$Companion r2 = com.google.firebase.sessions.InstallationId.Companion     // Catch:{ all -> 0x0161 }
            com.google.firebase.installations.FirebaseInstallationsApi r9 = r8.firebaseInstallationsApi     // Catch:{ all -> 0x0161 }
            r0.L$0 = r8     // Catch:{ all -> 0x0161 }
            r0.L$1 = r15     // Catch:{ all -> 0x0161 }
            r0.label = r6     // Catch:{ all -> 0x0161 }
            java.lang.Object r2 = r2.create(r9, r0)     // Catch:{ all -> 0x0161 }
            if (r2 != r1) goto L_0x00b0
            goto L_0x0157
        L_0x00b0:
            r13 = r2
            r2 = r15
            r15 = r13
        L_0x00b3:
            com.google.firebase.sessions.InstallationId r15 = (com.google.firebase.sessions.InstallationId) r15     // Catch:{ all -> 0x004f }
            java.lang.String r15 = r15.getFid()     // Catch:{ all -> 0x004f }
            java.lang.String r9 = ""
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r9)     // Catch:{ all -> 0x004f }
            if (r9 == 0) goto L_0x00cc
            java.lang.String r15 = "Error getting Firebase Installation ID. Skipping this Session Event."
            android.util.Log.w(r3, r15)     // Catch:{ all -> 0x004f }
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004f }
            r2.unlock(r7)
            return r15
        L_0x00cc:
            r9 = 5
            kotlin.Pair[] r9 = new kotlin.Pair[r9]     // Catch:{ all -> 0x004f }
            java.lang.String r10 = "X-Crashlytics-Installation-ID"
            kotlin.Pair r15 = kotlin.TuplesKt.to(r10, r15)     // Catch:{ all -> 0x004f }
            r10 = 0
            r9[r10] = r15     // Catch:{ all -> 0x004f }
            java.lang.String r15 = "X-Crashlytics-Device-Model"
            kotlin.jvm.internal.StringCompanionObject r10 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch:{ all -> 0x004f }
            java.lang.String r10 = "%s/%s"
            java.lang.String r11 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x004f }
            java.lang.String r12 = android.os.Build.MODEL     // Catch:{ all -> 0x004f }
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r12}     // Catch:{ all -> 0x004f }
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r6)     // Catch:{ all -> 0x004f }
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ all -> 0x004f }
            java.lang.String r11 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)     // Catch:{ all -> 0x004f }
            java.lang.String r10 = r8.removeForwardSlashesIn(r10)     // Catch:{ all -> 0x004f }
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r10)     // Catch:{ all -> 0x004f }
            r9[r5] = r15     // Catch:{ all -> 0x004f }
            java.lang.String r15 = "X-Crashlytics-OS-Build-Version"
            java.lang.String r5 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x004f }
            java.lang.String r10 = "INCREMENTAL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)     // Catch:{ all -> 0x004f }
            java.lang.String r5 = r8.removeForwardSlashesIn(r5)     // Catch:{ all -> 0x004f }
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r5)     // Catch:{ all -> 0x004f }
            r9[r6] = r15     // Catch:{ all -> 0x004f }
            java.lang.String r15 = "X-Crashlytics-OS-Display-Version"
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x004f }
            java.lang.String r6 = "RELEASE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x004f }
            java.lang.String r5 = r8.removeForwardSlashesIn(r5)     // Catch:{ all -> 0x004f }
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r5)     // Catch:{ all -> 0x004f }
            r9[r4] = r15     // Catch:{ all -> 0x004f }
            java.lang.String r15 = "X-Crashlytics-API-Client-Version"
            com.google.firebase.sessions.ApplicationInfo r5 = r8.appInfo     // Catch:{ all -> 0x004f }
            java.lang.String r5 = r5.getSessionSdkVersion()     // Catch:{ all -> 0x004f }
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r5)     // Catch:{ all -> 0x004f }
            r5 = 4
            r9[r5] = r15     // Catch:{ all -> 0x004f }
            java.util.Map r15 = kotlin.collections.MapsKt.mapOf(r9)     // Catch:{ all -> 0x004f }
            java.lang.String r5 = "Fetching settings from server."
            android.util.Log.d(r3, r5)     // Catch:{ all -> 0x004f }
            com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher r3 = r8.configsFetcher     // Catch:{ all -> 0x004f }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1 r5 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1     // Catch:{ all -> 0x004f }
            r5.<init>(r8, r7)     // Catch:{ all -> 0x004f }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x004f }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2 r6 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2     // Catch:{ all -> 0x004f }
            r6.<init>(r7)     // Catch:{ all -> 0x004f }
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ all -> 0x004f }
            r0.L$0 = r2     // Catch:{ all -> 0x004f }
            r0.L$1 = r7     // Catch:{ all -> 0x004f }
            r0.label = r4     // Catch:{ all -> 0x004f }
            java.lang.Object r15 = r3.doConfigFetch(r15, r5, r6, r0)     // Catch:{ all -> 0x004f }
            if (r15 != r1) goto L_0x0158
        L_0x0157:
            return r1
        L_0x0158:
            r0 = r2
        L_0x0159:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0038 }
            r0.unlock(r7)
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0161:
            r0 = move-exception
            r13 = r0
            r0 = r15
            r15 = r13
        L_0x0165:
            r0.unlock(r7)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.updateSettings(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean isSettingsStale() {
        return getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), (CoroutineContext) null, (CoroutineStart) null, new RemoteSettings$clearCachedSettings$1(this, (Continuation<? super RemoteSettings$clearCachedSettings$1>) null), 3, (Object) null);
    }

    private final String removeForwardSlashesIn(String str) {
        return new Regex(FORWARD_SLASH_STRING).replace((CharSequence) str, "");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "()V", "FORWARD_SLASH_STRING", "", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RemoteSettings.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
