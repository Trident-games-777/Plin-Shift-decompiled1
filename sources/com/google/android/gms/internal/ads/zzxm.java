package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzxm extends zzxw implements Comparable {
    private final int zze;
    private final int zzf = this.zzd.zza();

    public zzxm(int i, zzbw zzbw, int i2, zzxp zzxp, int i3) {
        super(i, zzbw, i2);
        this.zze = zzlo.zza(i3, zzxp.zzN) ? 1 : 0;
    }

    /* renamed from: zza */
    public final int compareTo(zzxm zzxm) {
        return Integer.compare(this.zzf, zzxm.zzf);
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzxw zzxw) {
        zzxm zzxm = (zzxm) zzxw;
        return false;
    }
}
