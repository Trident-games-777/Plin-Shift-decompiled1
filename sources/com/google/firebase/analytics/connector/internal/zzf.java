package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.1.2 */
final class zzf implements AppMeasurementSdk.OnEventListener {
    private final /* synthetic */ zzg zza;

    public zzf(zzg zzg) {
        this.zza = zzg;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (str != null && zzb.zze(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle("params", bundle);
            this.zza.zza.onMessageTriggered(3, bundle2);
        }
    }
}
