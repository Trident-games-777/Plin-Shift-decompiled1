package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.zae;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
public class SignInClientImpl extends GmsClient<zaf> implements zae {
    public static final /* synthetic */ int zaa = 0;
    private final boolean zab = true;
    private final ClientSettings zac;
    private final Bundle zad;
    private final Integer zae;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SignInClientImpl(android.content.Context r8, android.os.Looper r9, boolean r10, com.google.android.gms.common.internal.ClientSettings r11, android.os.Bundle r12, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks r13, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener r14) {
        /*
            r7 = this;
            r3 = 44
            r0 = r7
            r1 = r8
            r2 = r9
            r4 = r11
            r5 = r13
            r6 = r14
            r0.<init>((android.content.Context) r1, (android.os.Looper) r2, (int) r3, (com.google.android.gms.common.internal.ClientSettings) r4, (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) r5, (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r6)
            r8 = 1
            r0.zab = r8
            r0.zac = r4
            r0.zad = r12
            java.lang.Integer r8 = r4.zab()
            r0.zae = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.signin.internal.SignInClientImpl.<init>(android.content.Context, android.os.Looper, boolean, com.google.android.gms.common.internal.ClientSettings, android.os.Bundle, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener):void");
    }

    public static Bundle createBundleFromClientSettings(ClientSettings clientSettings) {
        clientSettings.zaa();
        Integer zab2 = clientSettings.zab();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.getAccount());
        if (zab2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zab2.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof zaf ? (zaf) queryLocalInterface : new zaf(iBinder);
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.zac.getRealClientPackageName())) {
            this.zad.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zac.getRealClientPackageName());
        }
        return this.zad;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public final boolean requiresSignIn() {
        return this.zab;
    }

    public final void zaa() {
        try {
            ((zaf) getService()).zae(((Integer) Preconditions.checkNotNull(this.zae)).intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public final void zab() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    public final void zac(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((zaf) getService()).zaf(iAccountAccessor, ((Integer) Preconditions.checkNotNull(this.zae)).intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public final void zad(zae zae2) {
        Preconditions.checkNotNull(zae2, "Expecting a valid ISignInCallbacks");
        try {
            Account accountOrDefault = this.zac.getAccountOrDefault();
            ((zaf) getService()).zag(new zai(1, new zat(accountOrDefault, ((Integer) Preconditions.checkNotNull(this.zae)).intValue(), "<<default account>>".equals(accountOrDefault.name) ? Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount() : null)), zae2);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zae2.zab(new zak(1, new ConnectionResult(8, (PendingIntent) null), (zav) null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }
}
