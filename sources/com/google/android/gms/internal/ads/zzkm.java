package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzkm {
    /* access modifiers changed from: private */
    public long zza;
    /* access modifiers changed from: private */
    public float zzb;
    /* access modifiers changed from: private */
    public long zzc;

    public zzkm() {
        this.zza = -9223372036854775807L;
        this.zzb = -3.4028235E38f;
        this.zzc = -9223372036854775807L;
    }

    /* synthetic */ zzkm(zzko zzko, zzkn zzkn) {
        this.zza = zzko.zza;
        this.zzb = zzko.zzb;
        this.zzc = zzko.zzc;
    }

    public final zzkm zzd(long j) {
        boolean z = true;
        if (j < 0) {
            if (j == -9223372036854775807L) {
                j = -9223372036854775807L;
            } else {
                z = false;
            }
        }
        zzdb.zzd(z);
        this.zzc = j;
        return this;
    }

    public final zzkm zze(long j) {
        this.zza = j;
        return this;
    }

    public final zzkm zzf(float f) {
        boolean z = true;
        if (f <= 0.0f && f != -3.4028235E38f) {
            z = false;
        }
        zzdb.zzd(z);
        this.zzb = f;
        return this;
    }

    public final zzko zzg() {
        return new zzko(this, (zzkn) null);
    }
}
