package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbv extends zzb {
    private final zzr zza;
    private final String zzb;

    public zzbv(Context context, String str, String str2) {
        this.zza = new zzr(zzv.zzq().zzc(context, str));
        this.zzb = str2;
    }

    public final void zza() {
        this.zza.zza(this.zzb);
    }
}
