package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzada implements zzadq {
    private final zzadc zza;
    private final long zzb;

    public zzada(zzadc zzadc, long j) {
        this.zza = zzadc;
        this.zzb = j;
    }

    private final zzadr zzb(long j, long j2) {
        return new zzadr((j * AnimationKt.MillisToNanos) / ((long) this.zza.zze), this.zzb + j2);
    }

    public final long zza() {
        return this.zza.zza();
    }

    public final zzado zzg(long j) {
        long j2;
        zzdb.zzb(this.zza.zzk);
        zzadc zzadc = this.zza;
        zzadb zzadb = zzadc.zzk;
        long[] jArr = zzadb.zza;
        long[] jArr2 = zzadb.zzb;
        int zzd = zzen.zzd(jArr, zzadc.zzb(j), true, false);
        long j3 = 0;
        if (zzd == -1) {
            j2 = 0;
        } else {
            j2 = jArr[zzd];
        }
        if (zzd != -1) {
            j3 = jArr2[zzd];
        }
        zzadr zzb2 = zzb(j2, j3);
        if (zzb2.zzb == j || zzd == jArr.length - 1) {
            return new zzado(zzb2, zzb2);
        }
        int i = zzd + 1;
        return new zzado(zzb2, zzb(jArr[i], jArr2[i]));
    }

    public final boolean zzh() {
        return true;
    }
}
