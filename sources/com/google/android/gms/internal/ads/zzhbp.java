package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhbp extends zzhbn {
    zzhbp() {
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzgyx zzgyx = (zzgyx) obj;
        zzhbo zzhbo = zzgyx.zzt;
        if (zzhbo != zzhbo.zzc()) {
            return zzhbo;
        }
        zzhbo zzf = zzhbo.zzf();
        zzgyx.zzt = zzf;
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzb() {
        return zzhbo.zzf();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        zzhbo zzhbo = (zzhbo) obj;
        zzhbo.zzh();
        return zzhbo;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, int i2) {
        ((zzhbo) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, long j) {
        ((zzhbo) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzhbo) obj).zzj((i << 3) | 3, (zzhbo) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzg(Object obj, int i, zzgxp zzgxp) {
        ((zzhbo) obj).zzj((i << 3) | 2, zzgxp);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzh(Object obj, int i, long j) {
        ((zzhbo) obj).zzj(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final void zzi(Object obj) {
        ((zzgyx) obj).zzt.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(Object obj, Object obj2) {
        ((zzgyx) obj).zzt = (zzhbo) obj2;
    }
}
