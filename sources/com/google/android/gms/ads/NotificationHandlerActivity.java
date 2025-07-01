package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsz;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class NotificationHandlerActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.NotificationHandlerActivity";

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            zzbsz zzo = zzbc.zza().zzo(this, new zzbpc());
            if (zzo == null) {
                zzm.zzg("OfflineUtils is null");
            } else {
                zzo.zze(getIntent());
            }
        } catch (RemoteException e) {
            zzm.zzg("RemoteException calling handleNotificationIntent: ".concat(e.toString()));
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        finish();
    }
}
