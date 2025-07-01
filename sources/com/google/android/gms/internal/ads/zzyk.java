package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzyk {
    public final int zza;
    public final zzlr[] zzb;
    public final zzyd[] zzc;
    public final zzcd zzd;
    public final Object zze;

    public zzyk(zzlr[] zzlrArr, zzyd[] zzydArr, zzcd zzcd, Object obj) {
        int length = zzlrArr.length;
        zzdb.zzd(length == zzydArr.length);
        this.zzb = zzlrArr;
        this.zzc = (zzyd[]) zzydArr.clone();
        this.zzd = zzcd;
        this.zze = obj;
        this.zza = length;
    }

    public final boolean zza(zzyk zzyk, int i) {
        if (zzyk != null && Objects.equals(this.zzb[i], zzyk.zzb[i]) && Objects.equals(this.zzc[i], zzyk.zzc[i])) {
            return true;
        }
        return false;
    }

    public final boolean zzb(int i) {
        return this.zzb[i] != null;
    }
}
