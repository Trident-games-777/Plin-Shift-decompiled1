package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfnz implements zzfns {
    private static zzfnz zza;
    private float zzb = 0.0f;
    private zzfnn zzc;
    private zzfnr zzd;

    public zzfnz(zzfno zzfno, zzfnm zzfnm) {
    }

    public static zzfnz zzb() {
        if (zza == null) {
            zza = new zzfnz(new zzfno(), new zzfnm());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    public final void zzc(boolean z) {
        if (z) {
            zzfpb.zzd().zzi();
        } else {
            zzfpb.zzd().zzh();
        }
    }

    public final void zzd(Context context) {
        this.zzc = new zzfnn(new Handler(), context, new zzfnl(), this);
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzd == null) {
            this.zzd = zzfnr.zza();
        }
        for (zzfna zzg : this.zzd.zzb()) {
            zzg.zzg().zzl(f);
        }
    }

    public final void zzf() {
        zzfnq.zza().zze(this);
        zzfnq.zza().zzf();
        zzfpb.zzd().zzi();
        this.zzc.zza();
    }

    public final void zzg() {
        zzfpb.zzd().zzj();
        zzfnq.zza().zzg();
        this.zzc.zzb();
    }
}
