package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfqa {
    private final Context zza;
    private final Looper zzb;

    public zzfqa(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfqn zza2 = zzfqq.zza();
        zza2.zza(this.zza.getPackageName());
        zza2.zzc(2);
        zzfqk zza3 = zzfqm.zza();
        zza3.zza(str);
        zza3.zzb(2);
        zza2.zzb(zza3);
        new zzfqb(this.zza, this.zzb, (zzfqq) zza2.zzbr()).zza();
    }
}
