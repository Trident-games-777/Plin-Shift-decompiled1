package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgl implements zzgc {
    private final zzgx zza = new zzgx();
    private zzhd zzb;
    private String zzc;
    private int zzd = 8000;
    private int zze = 8000;
    private boolean zzf;

    public final zzgl zzb(boolean z) {
        this.zzf = true;
        return this;
    }

    public final zzgl zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzgl zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzgl zze(zzhd zzhd) {
        this.zzb = zzhd;
        return this;
    }

    public final zzgl zzf(String str) {
        this.zzc = str;
        return this;
    }

    /* renamed from: zzg */
    public final zzgq zza() {
        zzgq zzgq = new zzgq(this.zzc, this.zzd, this.zze, this.zzf, false, this.zza, (zzfwr) null, false, (zzgp) null);
        zzhd zzhd = this.zzb;
        if (zzhd != null) {
            zzgq.zzf(zzhd);
        }
        return zzgq;
    }
}
