package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfgl {
    public static void zza(Context context, boolean z) {
        if (z) {
            zzm.zzi("This request is sent from a test device.");
            return;
        }
        zzbc.zzb();
        String zzz = zzf.zzz(context);
        zzm.zzi("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"" + zzz + "\")) to get test ads on this device.");
    }

    public static void zzb(int i, Throwable th, String str) {
        zzm.zzi("Ad failed to load : " + i);
        zze.zzb(str, th);
        if (i != 3) {
            zzv.zzp().zzv(th, str);
        }
    }
}
