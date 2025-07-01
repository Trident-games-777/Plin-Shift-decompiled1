package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcnt {
    private final String zza;
    private final zzbor zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public zzcny zzd;
    private final zzbjr zze = new zzcnq(this);
    private final zzbjr zzf = new zzcns(this);

    public zzcnt(String str, zzbor zzbor, Executor executor) {
        this.zza = str;
        this.zzb = zzbor;
        this.zzc = executor;
    }

    static /* bridge */ /* synthetic */ boolean zzg(zzcnt zzcnt, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(zzcnt.zza);
    }

    public final void zzc(zzcny zzcny) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcny;
    }

    public final void zzd(zzcfk zzcfk) {
        zzcfk.zzag("/updateActiveView", this.zze);
        zzcfk.zzag("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf(zzcfk zzcfk) {
        zzcfk.zzaz("/updateActiveView", this.zze);
        zzcfk.zzaz("/untrackActiveViewUnit", this.zzf);
    }
}
